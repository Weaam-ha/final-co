package AST.CSS;

public class CssEqualNode extends CssTokenNode {
    public CssEqualNode(int line, int column, String text) {
        super("CssEqualNode", line, column, text);
    }
}