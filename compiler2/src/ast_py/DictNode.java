package ast_py;

import java.util.Map;

public class DictNode extends ExprNode {
    public Map<ExprNode, ExprNode> items;

    public DictNode(Map<ExprNode, ExprNode> items, int line, int column) {
        super(line, column);
        this.items = items;

        for (var entry : items.entrySet()) {
            addChild(entry.getKey());
            addChild(entry.getValue());
        }
    }
}

