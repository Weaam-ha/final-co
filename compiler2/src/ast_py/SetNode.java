package ast_py;

import java.util.List;

public class SetNode extends ExprNode {
    public List<ExprNode> elements;

    public SetNode(List<ExprNode> elements, int line, int column) {
        super(line, column);
        this.elements = elements;
        addChildren(elements);
    }

    @Override
    public String toString() {
        return "Set";
    }
}