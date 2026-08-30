package AST.Jinja;

import AST.Node;
import java.util.List;

public class JinjaForBlockNode extends Node {

    private final JinjaForHeaderNode header;
    private final List<Node> body;

    public JinjaForBlockNode(int line, int column,
                             JinjaForHeaderNode header,
                             List<Node> body) {
        super("JinjaForBlockNode", line, column);
        this.header = header;
        this.body = body;
    }

    public JinjaForHeaderNode getHeader() {
        return header;
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
