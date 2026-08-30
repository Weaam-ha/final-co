package ast_py;


public class BinaryExprNode extends ExprNode {

    private ExprNode left;
    private String operator;
    private ExprNode right;

    public BinaryExprNode(ExprNode left,
                          String operator,
                          ExprNode right,
                          int line,
                          int column) {
        super(line, column);
        this.left = left;
        this.operator = operator;
        this.right = right;

        addChild(left);
        addChild(right);
    }

    public ExprNode getLeft() {
        return left;
    }

    public String getOperator() {
        return operator;
    }

    public ExprNode getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "BinaryExpr(" + operator + ")";
    }
}
