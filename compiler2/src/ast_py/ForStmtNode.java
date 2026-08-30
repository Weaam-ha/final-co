package ast_py;

public class ForStmtNode extends StmtNode {
    public String variable;
    public ExprNode iterable;
    public BlockNode block;

    public ForStmtNode(String variable, ExprNode iterable, BlockNode block, int line, int column) {
        super(line, column);
        this.variable = variable;
        this.iterable = iterable;
        this.block = block;

        addChild(iterable);
        addChild(block);
    }
}