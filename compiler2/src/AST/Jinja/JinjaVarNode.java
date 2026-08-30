package AST.Jinja;

import AST.Node;

public class JinjaVarNode extends Node {

    private final JinjaContentNode content;

    public JinjaVarNode(int line, int column, JinjaContentNode content) {
        super("JinjaVarNode", line, column);
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

