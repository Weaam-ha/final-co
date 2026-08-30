package AST.Jinja;

import AST.Node;

public class JinjaRBracketNode extends Node {

    public JinjaRBracketNode(int line, int col, String value) {
        super(value, line, col);
    }

    @Override
    public String toString() {
        return name + " (line=" + line + ", col=" + column + ")";
    }
}