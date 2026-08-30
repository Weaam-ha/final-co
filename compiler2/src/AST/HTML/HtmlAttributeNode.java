package AST.HTML;

import AST.Node;
import java.util.ArrayList;
import java.util.List;

public class HtmlAttributeNode extends Node {

    private final String name;
    private final List<Node> values = new ArrayList<>();

    public HtmlAttributeNode(int line, int column, String name) {
        super("HtmlAttributeNode", line, column);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Node> getValues() {
        return values;
    }

    public boolean isBooleanAttribute() {
        return values.isEmpty();
    }

    @Override
    public String toString() {
        return super.toString()
                + ", name=" + name
                + ", values=" + values.size()
                + ", boolean=" + isBooleanAttribute();
    }
}

