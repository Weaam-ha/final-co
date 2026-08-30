package ast_py;


public class IfStmtNode extends StmtNode {

    private ExprNode condition;
    private BlockNode thenBlock;
    private BlockNode elseBlock; // may be null

    public IfStmtNode(ExprNode condition,
                      BlockNode thenBlock,
                      BlockNode elseBlock,
                      int line,
                      int column) {
        super(line, column);
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elseBlock = elseBlock;

        // Build AST structure
        addChild(condition);
        addChild(thenBlock);
        addChild(elseBlock); // safe: ignored if null
    }

    public ExprNode getCondition() {
        return condition;
    }

    public BlockNode getThenBlock() {
        return thenBlock;
    }

    public BlockNode getElseBlock() {
        return elseBlock;
    }

    @Override
    public String toString() {
        return "IfStmt";
    }
}



