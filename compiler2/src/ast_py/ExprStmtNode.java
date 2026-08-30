package ast_py;


public class ExprStmtNode extends StmtNode {
    public ExprNode expr;

    public ExprStmtNode(ExprNode expr, int line, int column) {
        super(line, column);
        this.expr = expr;

        addChild(expr);
    }
}

