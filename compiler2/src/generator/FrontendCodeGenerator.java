package generator;

import AST.CSS.*;
import AST.DocumentNode;
import AST.HTML.*;
import AST.Jinja.*;
import AST.Node;

import java.util.List;
import java.util.Set;

public class FrontendCodeGenerator {

    private final StringBuilder html = new StringBuilder();
    private final StringBuilder css  = new StringBuilder();

    // ============================================================
    // ENTRY
    // ============================================================
    public void generate(List<Node> nodes) {
        if (nodes == null) return;
        for (Node node : nodes) visit(node);
    }

    // ============================================================
    // VISITOR
    // ============================================================
    private void visit(Node node) {
        if (node == null) return;

        if      (node instanceof DocumentNode)       emitDocument((DocumentNode) node);
        else if (node instanceof HtmlElementNode)    emitHtmlElement((HtmlElementNode) node);
        else if (node instanceof HtmlTextNode)       html.append(((HtmlTextNode) node).getText());
        else if (node instanceof HtmlAttributeNode)  emitHtmlAttribute((HtmlAttributeNode) node);
        else if (node instanceof AttrStringNode)     html.append(((AttrStringNode) node).getValue());
        else if (node instanceof AttrIdentifierNode) html.append(((AttrIdentifierNode) node).getValue());
        else if (node instanceof StyleBlockNode)     emitStyleBlock((StyleBlockNode) node);
        else if (node instanceof CssContentNode)     emitCssContent((CssContentNode) node);
        else if (node instanceof CssTokenNode)       emitCssToken((CssTokenNode) node);
        else if (node instanceof JinjaVarNode)       emitJinjaVar((JinjaVarNode) node);
        else if (node instanceof JinjaBlockNode)     emitJinjaBlock((JinjaBlockNode) node);
        else if (node instanceof JinjaForBlockNode)  emitJinjaFor((JinjaForBlockNode) node);
        else if (node instanceof JinjaIfBlockNode)   emitJinjaIf((JinjaIfBlockNode) node);
        else if (node instanceof JinjaElifBlockNode) emitJinjaElif((JinjaElifBlockNode) node);
        else if (node instanceof JinjaElseBlockNode) emitJinjaElse((JinjaElseBlockNode) node);
        else if (node instanceof JinjaContentNode)   emitJinjaContent((JinjaContentNode) node);
        else if (node instanceof JinjaTokenNode)
            html.append(((JinjaTokenNode) node).getText()).append(" ");
    }

    // ============================================================
    // DOCUMENT
    // ============================================================
    private void emitDocument(DocumentNode node) {
        if (node.hasDoctype()) html.append("<!DOCTYPE html>\n");
        for (Node child : node.getChildren()) visit(child);
    }

    // ============================================================
    // HTML ELEMENT
    // ============================================================
    private void emitHtmlElement(HtmlElementNode node) {
        String tag = node.getTagName();
        html.append("<").append(tag);
        for (HtmlAttributeNode attr : node.getAttributes()) emitHtmlAttribute(attr);
        html.append(">");
        for (Node child : node.getChildren()) {
            if (child == null || child instanceof HtmlAttributeNode) continue;
            visit(child);
        }
        if (!isVoid(tag)) html.append("</").append(tag).append(">");
    }

    private boolean isVoid(String tag) {
        return tag.equals("img")  || tag.equals("input") ||
                tag.equals("meta") || tag.equals("link")  ||
                tag.equals("br")   || tag.equals("hr");
    }

    // ============================================================
    // ATTRIBUTE
    // ============================================================
    private void emitHtmlAttribute(HtmlAttributeNode node) {
        html.append(" ").append(node.getName());
        if (node.isBooleanAttribute()) return;
        html.append("=\"");
        boolean first = true;
        for (Node v : node.getValues()) {
            if (v instanceof AttrIdentifierNode id && id.getValue().equals("required")) continue;
            if (!first) html.append(" ");
            visit(v);
            first = false;
        }
        html.append("\"");
    }

    // ============================================================
    // CSS
    // ============================================================
    private static final Set<String> PSEUDO_SELECTORS = Set.of(
            "hover", "focus", "active", "visited", "checked", "disabled",
            "first-child", "last-child", "nth-child", "not", "root",
            "placeholder", "before", "after", "first-of-type", "last-of-type",
            "nth-of-type", "only-child", "empty", "link", "target", "enabled",
            "read-only", "read-write", "optional", "required", "valid", "invalid"
    );

    private static final Set<String> TIME_UNITS = Set.of("s", "ms");

    // StyleBlockNode → يكتب في css buffer فقط، بدون أي tag
    private void emitStyleBlock(StyleBlockNode node) {
        if (node.getCssContent() == null) return;
        emitCssContent(node.getCssContent());
    }

    private void emitCssContent(CssContentNode node) {
        List<Node> tokens = node.getTokens();

        boolean lastWasMinus       = false;
        boolean lastWasOpenParen   = false;
        boolean lastWasColon       = false;
        boolean lastWasDoubleColon = false;

        for (int i = 0; i < tokens.size(); i++) {
            Node curr = tokens.get(i);

            if (!(curr instanceof CssTokenNode)) {
                visit(curr);
                lastWasMinus = lastWasOpenParen = lastWasColon = lastWasDoubleColon = false;
                continue;
            }

            String t = ((CssTokenNode) curr).getText();

            // رقم متبوع بوحدة زمنية (0.18s / 0.45s)
            boolean currIsNumeric = (curr instanceof CssNumberNode);
            boolean nextIsTimeId  = false;
            if (currIsNumeric && i + 1 < tokens.size()) {
                Node next = tokens.get(i + 1);
                if (next instanceof CssIdentifierNode) {
                    String nxt = ((CssTokenNode) next).getText();
                    if (TIME_UNITS.contains(nxt)) nextIsTimeId = true;
                }
            }

            boolean noSpaceBefore =
                    i == 0              ||
                            lastWasMinus        ||
                            lastWasOpenParen    ||
                            lastWasColon        ||
                            lastWasDoubleColon  ||
                            t.equals(")")       || t.equals("]") ||
                            t.equals(";")       || t.equals(",") ||
                            t.equals("{")       || t.equals("}") ||
                            t.equals("(")       || t.equals("[") ||
                            t.equals(".")       || t.equals("=") ||
                            t.equals("::")      || t.equals(":");

            if (!noSpaceBefore) css.append(" ");

            // رقم + وحدة زمنية: اطبعهما معاً بدون مسافة
            if (nextIsTimeId) {
                css.append(t);
                i++;
                css.append(((CssTokenNode) tokens.get(i)).getText());
                lastWasMinus = lastWasOpenParen = lastWasColon = lastWasDoubleColon = false;
                continue;
            }

            // معالجة ":" بحسب السياق
            if (t.equals(":")) {
                if (isPropertyColon(tokens, i)) {
                    css.append(": ");
                    lastWasColon = false;
                } else {
                    css.append(":");
                    lastWasColon = true;
                }
                lastWasMinus = lastWasOpenParen = lastWasDoubleColon = false;
                continue;
            }

            emitCssToken((CssTokenNode) curr);

            lastWasMinus       = t.equals("-");
            lastWasOpenParen   = t.equals("(") || t.equals("[");
            lastWasDoubleColon = t.equals("::");
            lastWasColon       = false;
        }
    }

    private boolean isPropertyColon(List<Node> tokens, int colonIndex) {
        if (colonIndex + 1 < tokens.size()) {
            Node next = tokens.get(colonIndex + 1);
            if (next instanceof CssIdentifierNode) {
                String nextText = ((CssTokenNode) next).getText();
                if (PSEUDO_SELECTORS.contains(nextText)) return false;
            }
        }
        return true;
    }

    private void emitCssToken(CssTokenNode node) {
        String t = node.getText();

        if      (t.equals("{"))  css.append(" {\n");
        else if (t.equals("}"))  css.append("}\n\n");
        else if (t.equals("::")) css.append("::");
        else if (t.equals(";"))  css.append(";\n");
        else if (t.equals(","))  css.append(", ");
        else if (t.equals("("))  css.append("(");
        else if (t.equals(")"))  css.append(")");
        else if (t.equals("["))  css.append("[");
        else if (t.equals("]"))  css.append("]");
        else if (t.equals("."))  css.append(".");
        else if (t.equals("="))  css.append("=");
        else if (t.equals("-"))  css.append("-");
        else                     css.append(t);
    }

    // ============================================================
    // JINJA
    // ============================================================
    private void emitJinjaVar(JinjaVarNode node) {
        html.append("{{ ");
        emitJinjaContent(node.getContent());
        html.append(" }}");
    }

    private void emitJinjaBlock(JinjaBlockNode node) {
        html.append("{% ");
        emitJinjaContent(node.getContent());
        html.append(" %}");
    }

    private void emitJinjaFor(JinjaForBlockNode node) {
        html.append("{% for ")
                .append(node.getHeader().getVariable().getText())
                .append(" in ");
        emitJinjaContent(node.getHeader().getIterable());
        html.append(" %}");
        for (Node n : node.getBody()) visit(n);
        html.append("{% endfor %}");
    }

    private void emitJinjaIf(JinjaIfBlockNode node) {
        html.append("{% if ");
        emitJinjaContent(node.getHeader().getCondition());
        html.append(" %}");
        for (Node n : node.getIfBody()) visit(n);
        for (JinjaElifBlockNode elif : node.getElifBlocks()) emitJinjaElif(elif);
        if (node.getElseBlock() != null) emitJinjaElse(node.getElseBlock());
        html.append("{% endif %}");
    }

    private void emitJinjaElif(JinjaElifBlockNode node) {
        html.append("{% elif ");
        emitJinjaContent(node.getCondition());
        html.append(" %}");
        for (Node n : node.getBody()) visit(n);
    }

    private void emitJinjaElse(JinjaElseBlockNode node) {
        html.append("{% else %}");
        for (Node n : node.getBody()) visit(n);
    }

    private void emitJinjaContent(JinjaContentNode node) {
        boolean needSpace = false;
        for (Node t : node.getTokens()) {
            String text = (t instanceof JinjaTokenNode tok) ? tok.getText() : t.getName();
            boolean isWord = text.matches("[A-Za-z0-9_]+");
            if (needSpace && isWord) html.append(" ");
            html.append(text);
            needSpace = isWord;
        }
    }

    // ============================================================
    // OUTPUT — ملفان منفصلان
    // ============================================================
    public String getHTML() { return html.toString(); }
    public String getCSS()  { return css.toString();  }
}