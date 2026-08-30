package AST.Jinja;

import AST.Node;

public class JinjaBlockNode extends Node {

    private final JinjaContentNode content;

    public JinjaBlockNode(int line, int column, JinjaContentNode content) {
        super("JinjaBlockNode", line, column);
        this.content = content;
    }

    public JinjaContentNode getContent() {
        return content;
    }

    @Override
    public String toString() {
        return super.toString() + ", hasContent=" + (content != null);
    }
}

