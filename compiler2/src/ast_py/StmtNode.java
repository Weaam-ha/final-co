package ast_py;


public abstract class StmtNode extends AST_Node {

    public StmtNode(int line, int column) {
        super(line, column);
    }


    public boolean isStatement() {
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
