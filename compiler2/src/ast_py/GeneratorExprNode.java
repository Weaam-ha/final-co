package ast_py;

public class GeneratorExprNode extends ExprNode {
    public ExprNode expr;
    public String variable;
    public String iterable;
    public ExprNode condition;

   public GeneratorExprNode(ExprNode expr, String variable, String iterable, ExprNode condition, int line, int column) {
       super(line, column);
       this.expr = expr;
       this.variable = variable;
       this.iterable = iterable;
       this.condition = condition;

       addChild(expr);
       addChild(condition);
   }

}
