package ast_py;


public abstract class ExprNode extends AST_Node {

    public ExprNode(int line, int column) {
        super(line, column);
    }


   public boolean isExpression() {
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}





