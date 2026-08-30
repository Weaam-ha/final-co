package ast_py;

import java.util.ArrayList;
import java.util.List;

public class IndexExprNode extends ExprNode {

    private ExprNode target;
    private ExprNode index;

    public IndexExprNode(ExprNode target, ExprNode index, int line, int column) {
        super(line, column);
        this.target = target;
        this.index = index;
    }

    public ExprNode getTarget() {
        return target;
    }

    public void setTarget(ExprNode target) {
        this.target = target;
    }

    public ExprNode getIndex() {
        return index;
    }

    public void setIndex(ExprNode index) {
        this.index = index;
    }

    @Override
    public List<AST_Node> getChildren() {
        List<AST_Node> children = new ArrayList<>();
        if (target != null) children.add(target);
        if (index != null) children.add(index);
        return children;
    }

    @Override
    public String toString() {
        return "IndexExprNode{" +
                "target=" + target +
                ", index=" + index +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}