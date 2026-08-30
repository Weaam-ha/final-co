package generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Renders the supported Jinja subset into a standalone HTML document.
 *
 * <p>This class never executes Python or starts Flask. It intentionally reads only
 * top-level Python literals (lists, dictionaries, strings, numbers, booleans and
 * None), then expands Jinja variables, for-blocks and if/else-blocks using those
 * values. Unsupported dynamic Python expressions are ignored rather than run.</p>
 */
public final class StaticTemplateRenderer {
    private static final Pattern TOP_LEVEL_ASSIGNMENT = Pattern.compile(
            "(?m)^([A-Za-z_][A-Za-z0-9_]*)\\s*=\\s*");
    private static final Pattern FOR_HEADER = Pattern.compile(
            "^for\\s+([A-Za-z_][A-Za-z0-9_]*)\\s+in\\s+(.+)$", Pattern.DOTALL);
    private static final Pattern VARIABLE = Pattern.compile("\\{\\{\\s*(.*?)\\s*}}", Pattern.DOTALL);

    private StaticTemplateRenderer() {
    }

    /** Extracts safe, top-level literal assignments from the Python source files. */
    public static Map<String, Object> extractContext(Path... pythonFiles) throws IOException {
        Map<String, Object> context = new LinkedHashMap<>();
        for (Path pythonFile : pythonFiles) {
            if (pythonFile == null || !Files.isRegularFile(pythonFile)) {
                continue;
            }
            String source = Files.readString(pythonFile);
            Matcher assignments = TOP_LEVEL_ASSIGNMENT.matcher(source);
            while (assignments.find()) {
                String name = assignments.group(1);
                int valueStart = assignments.end();
                try {
                    PythonLiteralParser parser = new PythonLiteralParser(source, valueStart);
                    Object value = parser.parseValue();
                    context.put(name, value);
                } catch (IllegalArgumentException ignored) {
                    // Non-literal code such as app = Flask(__name__) is ignored
                    // deliberately: static generation must never execute Python.
                }
            }
        }
        return context;
    }

    /** Renders Jinja control blocks and variables into plain, standalone HTML. */
    public static String render(String template, Map<String, Object> context) {
        if (template == null) {
            return "";
        }
        Map<String, Object> safeContext = context == null
                ? new LinkedHashMap<>()
                : new LinkedHashMap<>(context);
        return renderBlocks(template, safeContext);
    }

    private static String renderBlocks(String template, Map<String, Object> context) {
        StringBuilder output = new StringBuilder();
        int cursor = 0;

        while (true) {
            Tag opening = nextTag(template, cursor);
            if (opening == null) {
                output.append(replaceVariables(template.substring(cursor), context));
                return output.toString();
            }

            output.append(replaceVariables(template.substring(cursor, opening.start), context));
            String command = opening.command;

            if (command.startsWith("for ")) {
                Block block = findBlock(template, opening.end, "for");
                if (block == null) {
                    throw new IllegalArgumentException("Unclosed Jinja for block: " + command);
                }
                Matcher header = FOR_HEADER.matcher(command);
                if (!header.matches()) {
                    throw new IllegalArgumentException("Invalid Jinja for header: " + command);
                }

                String variableName = header.group(1);
                Object iterable = resolve(header.group(2), context);
                for (Object item : asIterable(iterable)) {
                    Map<String, Object> childContext = new LinkedHashMap<>(context);
                    childContext.put(variableName, item);
                    output.append(renderBlocks(template.substring(block.bodyStart, block.bodyEnd), childContext));
                }
                cursor = block.endEnd;
                continue;
            }

            if (command.startsWith("if ")) {
                Block block = findBlock(template, opening.end, "if");
                if (block == null) {
                    throw new IllegalArgumentException("Unclosed Jinja if block: " + command);
                }
                boolean condition = isTruthy(resolve(command.substring(3), context));
                if (condition) {
                    output.append(renderBlocks(template.substring(block.bodyStart, block.bodyEnd), context));
                } else if (block.elseStart >= 0) {
                    output.append(renderBlocks(template.substring(block.elseEnd, block.endStart), context));
                }
                cursor = block.endEnd;
                continue;
            }

            // A valid template never reaches an end-tag at this level. Removing it is
            // safer than leaving Jinja syntax in a file advertised as static HTML.
            cursor = opening.end;
        }
    }

    private static Block findBlock(String template, int bodyStart, String blockType) {
        int depth = 1;
        int cursor = bodyStart;
        int elseStart = -1;
        int elseEnd = -1;

        while (true) {
            Tag tag = nextTag(template, cursor);
            if (tag == null) {
                return null;
            }
            String command = tag.command;
            if (command.startsWith(blockType + " ")) {
                depth++;
            } else if (command.equals("end" + blockType)) {
                depth--;
                if (depth == 0) {
                    return new Block(bodyStart, elseStart >= 0 ? elseStart : tag.start,
                            elseStart, elseEnd, tag.start, tag.end);
                }
            } else if (blockType.equals("if") && depth == 1 && command.equals("else")) {
                elseStart = tag.start;
                elseEnd = tag.end;
            }
            cursor = tag.end;
        }
    }

    private static Tag nextTag(String template, int from) {
        int start = template.indexOf("{%", from);
        if (start < 0) {
            return null;
        }
        int close = template.indexOf("%}", start + 2);
        if (close < 0) {
            throw new IllegalArgumentException("Unclosed Jinja tag at character " + start);
        }
        return new Tag(start, close + 2, template.substring(start + 2, close).trim());
    }

    private static String replaceVariables(String text, Map<String, Object> context) {
        Matcher matcher = VARIABLE.matcher(text);
        StringBuffer rendered = new StringBuffer();
        while (matcher.find()) {
            Object value = resolve(matcher.group(1), context);
            String replacement = value == null ? "" : escapeHtml(String.valueOf(value));
            matcher.appendReplacement(rendered, Matcher.quoteReplacement(replacement));
        }
        matcher.appendTail(rendered);
        return rendered.toString();
    }

    private static Object resolve(String expression, Map<String, Object> context) {
        String value = expression == null ? "" : expression.trim();
        if (value.isEmpty()) {
            return null;
        }
        if ((value.startsWith("\"") && value.endsWith("\""))
                || (value.startsWith("'") && value.endsWith("'"))) {
            return value.substring(1, value.length() - 1);
        }
        if (value.equals("True")) {
            return Boolean.TRUE;
        }
        if (value.equals("False") || value.equals("None")) {
            return value.equals("False") ? Boolean.FALSE : null;
        }

        String[] parts = value.split("\\.");
        Object current = context.get(parts[0].trim());
        for (int i = 1; current != null && i < parts.length; i++) {
            String part = parts[i].trim();
            if (current instanceof Map<?, ?> map) {
                current = map.get(part);
            } else {
                current = null;
            }
        }
        return current;
    }

    private static List<Object> asIterable(Object value) {
        if (value instanceof List<?> list) {
            return new ArrayList<>(list);
        }
        if (value instanceof Map<?, ?> map) {
            return new ArrayList<>(map.values());
        }
        return List.of();
    }

    private static boolean isTruthy(Object value) {
        if (value == null || Boolean.FALSE.equals(value)) {
            return false;
        }
        if (value instanceof String text) {
            return !text.isBlank();
        }
        if (value instanceof Number number) {
            return number.doubleValue() != 0.0;
        }
        if (value instanceof List<?> list) {
            return !list.isEmpty();
        }
        if (value instanceof Map<?, ?> map) {
            return !map.isEmpty();
        }
        return true;
    }

    private static String escapeHtml(String value) {
        return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }

    private record Tag(int start, int end, String command) {
    }

    private record Block(int bodyStart, int bodyEnd, int elseStart, int elseEnd,
                         int endStart, int endEnd) {
    }

    /** A deliberately small parser for Python literal data; it never evaluates code. */
    private static final class PythonLiteralParser {
        private final String text;
        private int position;

        private PythonLiteralParser(String text, int position) {
            this.text = text;
            this.position = position;
        }

        private Object parseValue() {
            skipWhitespace();
            if (position >= text.length()) {
                throw new IllegalArgumentException("Expected a literal value");
            }
            char current = text.charAt(position);
            if (current == '[') {
                return parseList();
            }
            if (current == '{') {
                return parseDictionary();
            }
            if (current == '\'' || current == '\"') {
                return parseString();
            }
            if (current == '-' || Character.isDigit(current)) {
                return parseNumber();
            }
            if (consumeWord("True")) {
                return Boolean.TRUE;
            }
            if (consumeWord("False")) {
                return Boolean.FALSE;
            }
            if (consumeWord("None")) {
                return null;
            }
            throw new IllegalArgumentException("Only Python literals are supported");
        }

        private List<Object> parseList() {
            expect('[');
            List<Object> values = new ArrayList<>();
            skipWhitespace();
            if (consume(']')) {
                return values;
            }
            while (true) {
                values.add(parseValue());
                skipWhitespace();
                if (consume(']')) {
                    return values;
                }
                expect(',');
                skipWhitespace();
                if (consume(']')) {
                    return values;
                }
            }
        }

        private Map<String, Object> parseDictionary() {
            expect('{');
            Map<String, Object> values = new LinkedHashMap<>();
            skipWhitespace();
            if (consume('}')) {
                return values;
            }
            while (true) {
                skipWhitespace();
                if (position >= text.length()
                        || (text.charAt(position) != '\'' && text.charAt(position) != '\"')) {
                    throw new IllegalArgumentException("Dictionary keys must be strings");
                }
                String key = parseString();
                skipWhitespace();
                expect(':');
                Object value = parseValue();
                values.put(key, value);
                skipWhitespace();
                if (consume('}')) {
                    return values;
                }
                expect(',');
                skipWhitespace();
                if (consume('}')) {
                    return values;
                }
            }
        }

        private String parseString() {
            char quote = text.charAt(position++);
            StringBuilder value = new StringBuilder();
            while (position < text.length()) {
                char current = text.charAt(position++);
                if (current == quote) {
                    return value.toString();
                }
                if (current == '\\' && position < text.length()) {
                    char escaped = text.charAt(position++);
                    value.append(switch (escaped) {
                        case 'n' -> '\n';
                        case 'r' -> '\r';
                        case 't' -> '\t';
                        case '\\' -> '\\';
                        case '\'' -> '\'';
                        case '\"' -> '\"';
                        default -> escaped;
                    });
                } else {
                    value.append(current);
                }
            }
            throw new IllegalArgumentException("Unclosed Python string literal");
        }

        private Number parseNumber() {
            int start = position;
            if (text.charAt(position) == '-') {
                position++;
            }
            while (position < text.length() && Character.isDigit(text.charAt(position))) {
                position++;
            }
            boolean decimal = false;
            if (position < text.length() && text.charAt(position) == '.') {
                decimal = true;
                position++;
                while (position < text.length() && Character.isDigit(text.charAt(position))) {
                    position++;
                }
            }
            String raw = text.substring(start, position);
            try {
                return decimal ? Double.parseDouble(raw) : Long.parseLong(raw);
            } catch (NumberFormatException error) {
                throw new IllegalArgumentException("Invalid number: " + raw, error);
            }
        }

        private void expect(char expected) {
            skipWhitespace();
            if (!consume(expected)) {
                throw new IllegalArgumentException("Expected '" + expected + "'");
            }
        }

        private boolean consume(char expected) {
            if (position < text.length() && text.charAt(position) == expected) {
                position++;
                return true;
            }
            return false;
        }

        private boolean consumeWord(String word) {
            if (!text.startsWith(word, position)) {
                return false;
            }
            int end = position + word.length();
            if (end < text.length() && (Character.isLetterOrDigit(text.charAt(end))
                    || text.charAt(end) == '_')) {
                return false;
            }
            position = end;
            return true;
        }

        private void skipWhitespace() {
            while (position < text.length() && Character.isWhitespace(text.charAt(position))) {
                position++;
            }
        }
    }
}
