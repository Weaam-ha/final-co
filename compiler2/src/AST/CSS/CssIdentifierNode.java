package AST.CSS;

public class CssIdentifierNode extends CssTokenNode {
    public CssIdentifierNode(int line, int column, String text) {
        super("CssIdentifierNode", line, column, text);
    }
}

