package AST.HTML;

import AST.Node;

public class AttrStringNode extends Node {

    private final String value;

    public AttrStringNode(int line, int column, String value) {
        super("AttrStringNode", line, column);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return super.toString() + ", value=\"" + value + "\"";
    }
}

