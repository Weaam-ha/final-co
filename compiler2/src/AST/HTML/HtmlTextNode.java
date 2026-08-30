package AST.HTML;

import AST.Node;

public class HtmlTextNode extends Node {

    private final String text;

    public HtmlTextNode(int line, int column, String text) {
        super("HtmlTextNode", line, column);
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

