package AST.Jinja;

import AST.Node;

public class JinjaForHeaderNode extends Node {

    private final JinjaIdentifierNode variable;
    private final JinjaContentNode iterable;

    public JinjaForHeaderNode(int line, int column,
                              JinjaIdentifierNode variable,
                              JinjaContentNode iterable) {
        super("JinjaForHeaderNode", line, column);
        this.variable = variable;
        this.iterable = iterable;
    }

    public JinjaIdentifierNode getVariable() {
        return variable;
    }

    public JinjaContentNode getIterable() {
        return iterable;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", var=" + (variable != null ? variable.getText() : "null")
                + ", iterableTokens=" + (iterable != null ? iterable.getTokens().size() : 0);
    }
}
