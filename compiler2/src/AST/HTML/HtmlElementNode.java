package AST.HTML;

import AST.Node;
import java.util.ArrayList;
import java.util.List;

public class HtmlElementNode extends Node {

    public enum ElementKind {
        SELF_CLOSING,
        VOID,
        NORMAL
    }

    private final String tagName;
    private final ElementKind kind;
    private final List<HtmlAttributeNode> attributes = new ArrayList<>();
    private final List<Node> children = new ArrayList<>();

    public HtmlElementNode(int line, int column, String tagName, ElementKind kind) {
        super("HtmlElementNode", line, column);
        this.tagName = tagName;
        this.kind = kind;
    }

    public String getTagName() {
        return tagName;
    }

    public ElementKind getKind() {
        return kind;
    }

    public List<HtmlAttributeNode> getAttributes() {
        return attributes;
    }

    public List<Node> getChildren() {
        return children;
    }
    // في HtmlElementNode.java أضف
    private boolean hasClosingTag = true;

    public void setHasClosingTag(boolean val) { this.hasClosingTag = val; }
    public boolean hasClosingTag() { return hasClosingTag; }
    @Override
    public String toString() {
        return super.toString()
                + ", tagName=" + tagName
                + ", kind=" + kind
                + ", attributes=" + attributes.size()
                + ", children=" + children.size();
    }
}
