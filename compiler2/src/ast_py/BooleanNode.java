package ast_py;

public class BooleanNode extends ExprNode {
    public boolean value;

    public BooleanNode(boolean value, int line, int column) {
        super(line, column);
        this.value = value;
    }
}
