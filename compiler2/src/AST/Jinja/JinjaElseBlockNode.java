package AST.Jinja;

import AST.Node;
import java.util.List;

public class JinjaElseBlockNode extends Node {

    private final List<Node> body;

    public JinjaElseBlockNode(int line, int column,
                              List<Node> body) {
        super("JinjaElseBlockNode", line, column);
        this.body = body;
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
