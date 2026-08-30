package AST.Jinja;

import AST.Node;
import java.util.List;

public class JinjaElifBlockNode extends Node {

    private final JinjaContentNode condition;
    private final List<Node> body;

    public JinjaElifBlockNode(int line, int column,
                              JinjaContentNode condition,
                              List<Node> body) {
        super("JinjaElifBlockNode", line, column);
        this.condition = condition;
        this.body = body;
    }

    public JinjaContentNode getCondition() {
        return condition;
    }

    public List<Node> getBody() {
        return body;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", bodySize=" + (body != null ? body.size() : 0);
    }
}
