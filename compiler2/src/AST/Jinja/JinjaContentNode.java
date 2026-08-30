package AST.Jinja;

import AST.Node;
import java.util.ArrayList;
import java.util.List;

public class JinjaContentNode extends Node {

    private final List<Node> tokens = new ArrayList<>();

    public JinjaContentNode(int line, int column) {
        super("JinjaContentNode", line, column);
    }

    public List<Node> getTokens() {
        return tokens;
    }

    @Override
    public String toString() {
        return super.toString() + ", tokens=" + tokens.size();
    }
}

