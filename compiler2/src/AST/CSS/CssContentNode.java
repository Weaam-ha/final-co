package AST.CSS;

import AST.Node;
import java.util.ArrayList;
import java.util.List;

public class CssContentNode extends Node {

    private final List<Node> tokens = new ArrayList<>();

    public CssContentNode(int line, int column) {
        super("CssContentNode", line, column);
    }

    public List<Node> getTokens() {
        return tokens;
    }

    @Override
    public String toString() {
        return super.toString() + ", tokens=" + tokens.size();
    }
}

