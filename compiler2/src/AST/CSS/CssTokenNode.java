
package AST.CSS;

import AST.Node;

public abstract class CssTokenNode extends Node {

    private final String text;

    public CssTokenNode(String name, int line, int column, String text) {
        super(name, line, column);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return super.toString() + ", text=\"" + text + "\"";
    }
}
