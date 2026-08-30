package AST.CSS;

public class CssStringNode extends CssTokenNode {
    public CssStringNode(int line, int column, String text) {
        super("CssStringNode", line, column, text);
    }
}

