package ast_py;

public class WhileStmtNode extends StmtNode {
    public ExprNode condition;
    public BlockNode block;

    public WhileStmtNode(ExprNode condition, BlockNode block, int line, int column) {
        super(line, column);
        this.condition = condition;
        this.block = block;

        addChild(condition);
        addChild(block);
    }
}