package ast_py;


public class UnaryExprNode extends ExprNode {

    private String operator;
    private ExprNode expr;

    public UnaryExprNode(String operator,
                         ExprNode expr,
                         int line,
                         int column) {
        super(line, column);
        this.operator = operator;
        this.expr = expr;

        // Build AST structure
        addChild(expr);
    }

    public String getOperator() {
        return operator;
    }

    public ExprNode getExpr() {
        return expr;
    }

    @Override
    public String toString() {
        return "UnaryExpr(" + operator + ")";
    }
}
