package AST;

import java.util.ArrayList;
import java.util.List;

public class DocumentNode extends Node {

    private final boolean hasDoctype;
    private final List<Node> children = new ArrayList<>();

    public DocumentNode(int line, int column, boolean hasDoctype) {
        super("DocumentNode", line, column);
        this.hasDoctype = hasDoctype;
    }

    public boolean hasDoctype() {
        return hasDoctype;
    }

    public List<Node> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return super.toString() + ", hasDoctype=" + hasDoctype + ", children=" + children.size();
    }
}
