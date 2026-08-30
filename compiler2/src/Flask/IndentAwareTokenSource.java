package Flask;

import org.antlr.v4.runtime.*;

import java.util.ArrayDeque;
import java.util.Deque;

public class IndentAwareTokenSource implements TokenSource {

    private final Lexer lexer;
    private final Deque<Integer> indents = new ArrayDeque<>();
    private final Deque<Token> pending = new ArrayDeque<>();

    // Tracks (), [], {} nesting. Python suppresses indentation tracking
    // while inside brackets (implicit line joining) — without this,
    // multi-line list/dict/call literals produce bogus INDENT/DEDENT
    // tokens that listLiteral/dictLiteral/argList don't expect.
    private int bracketDepth = 0;

    public IndentAwareTokenSource(Lexer lexer) {
        this.lexer = lexer;
        indents.push(0);
    }

    @Override
    public Token nextToken() {
        if (!pending.isEmpty()) {
            return pending.poll();
        }

        Token t = lexer.nextToken();
        updateBracketDepth(t);

        if (t.getType() == Token.EOF) {
            while (indents.peek() != null && indents.peek() > 0) {
                indents.pop();
                pending.add(synthetic(FlaskPythonLexer.DEDENT, t, "<DEDENT>"));
            }
            pending.add(t);
            return pending.poll();
        }

        if (t.getType() == FlaskPythonLexer.NEWLINE) {
            pending.add(t); // always emit the NEWLINE itself

            if (bracketDepth == 0) {
                int width = indentWidthAfterLastNewline(t.getText());
                int top = indents.peek();
                if (width > top) {
                    indents.push(width);
                    pending.add(synthetic(FlaskPythonLexer.INDENT, t, "<INDENT>"));
                } else {
                    while (width < indents.peek()) {
                        indents.pop();
                        pending.add(synthetic(FlaskPythonLexer.DEDENT, t, "<DEDENT>"));
                    }
                }
            }
            // else: inside brackets — NEWLINE emitted, no indent tracking.

            return pending.poll();
        }

        return t;
    }

    private void updateBracketDepth(Token t) {
        switch (t.getType()) {
            case FlaskPythonLexer.LPAREN, FlaskPythonLexer.LBRACKET, FlaskPythonLexer.LBRACE ->
                    bracketDepth++;
            case FlaskPythonLexer.RPAREN, FlaskPythonLexer.RBRACKET, FlaskPythonLexer.RBRACE ->
                    bracketDepth = Math.max(0, bracketDepth - 1);
            default -> { }
        }
    }

    private int indentWidthAfterLastNewline(String text) {
        int idx = Math.max(text.lastIndexOf('\n'), text.lastIndexOf('\r'));
        String indentPart = idx >= 0 ? text.substring(idx + 1) : "";
        int width = 0;
        for (int i = 0; i < indentPart.length(); i++) {
            char c = indentPart.charAt(i);
            if (c == '\t') width += 8 - (width % 8);
            else if (c == ' ') width += 1;
        }
        return width;
    }

    private Token synthetic(int type, Token model, String text) {
        CommonToken ct = new CommonToken(model);
        ct.setType(type);
        ct.setText(text);
        return ct;
    }

    @Override public int getCharPositionInLine() { return lexer.getCharPositionInLine(); }
    @Override public CharStream getInputStream() { return lexer.getInputStream(); }
    @Override public String getSourceName() { return lexer.getSourceName(); }
    @Override public int getLine() { return lexer.getLine(); }
    @Override public void setTokenFactory(TokenFactory<?> factory) { lexer.setTokenFactory(factory); }
    @Override public TokenFactory<?> getTokenFactory() { return lexer.getTokenFactory(); }
}