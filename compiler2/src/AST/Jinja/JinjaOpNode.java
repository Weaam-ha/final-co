package AST.Jinja;

import AST.Node;

public class JinjaOpNode extends Node {

    public JinjaOpNode(int line, int col, String operator) {
        super(operator, line, col);
    }

    @Override
    public String toString() {
        return name + " (line=" + line + ", col=" + column + ")";
    }
}