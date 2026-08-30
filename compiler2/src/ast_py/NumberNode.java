package ast_py;

public class NumberNode extends ExprNode {
    public double value;

    public NumberNode(double value, int line, int column) {
        super(line, column);
        this.value = value;
    }
}
