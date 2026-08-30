package AST.Jinja;

import AST.Node;

public class JinjaLBracketNode extends Node {

    public JinjaLBracketNode(int line, int col, String value) {
        super(value, line, col);
    }

    @Override
    public String toString() {
        return name + " (line=" + line + ", col=" + column + ")";
    }
}