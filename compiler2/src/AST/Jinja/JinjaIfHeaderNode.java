package AST.Jinja;

import AST.Node;

public class JinjaIfHeaderNode extends Node {

    private final JinjaContentNode condition;

    public JinjaIfHeaderNode(int line, int column,
                             JinjaContentNode condition) {
        super("JinjaIfHeaderNode", line, column);
        this.condition = condition;
    }

    public JinjaContentNode getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", conditionTokens=" + (condition != null ? condition.getTokens().size() : 0);
    }
}
