package AST.HTML;

import AST.Node;
import AST.CSS.CssContentNode;

public class StyleBlockNode extends Node {

    private final CssContentNode cssContent;

    public StyleBlockNode(int line, int column, CssContentNode cssContent) {
        super("StyleBlockNode", line, column);
        this.cssContent = cssContent;
    }

    public CssContentNode getCssContent() {
        return cssContent;
    }

    @Override
    public String toString() {
        return super.toString() + ", cssContent=" + (cssContent != null);
    }
}



