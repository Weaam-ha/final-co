package AST.HTML;

import AST.Node;

public class AttrIdentifierNode extends Node {

    private final String value;

    public AttrIdentifierNode(int line, int column, String value) {
        super("AttrIdentifierNode", line, column);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return super.toString() + ", value=" + value;
    }
}

