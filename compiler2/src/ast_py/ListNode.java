package ast_py;

import java.util.List;

public class ListNode extends ExprNode {
    public List<ExprNode> elements;


   public ListNode(List<ExprNode> elements, int line, int column) {
       super(line, column);
       this.elements = elements;
       addChildren(elements);
   }

}
