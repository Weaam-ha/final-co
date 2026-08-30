package ast_py;

public class SliceExprNode extends ExprNode {
    private ExprNode target;
    private ExprNode start;  // may be null
    private ExprNode end;    // may be null

    public SliceExprNode(ExprNode target, ExprNode start, ExprNode end,
                         int line, int column) {
        super(line, column);
        this.target = target;
        this.start = start;
        this.end = end;
        addChild(target);
        if (start != null) addChild(start);
        if (end != null) addChild(end);
    }

    public ExprNode getTarget() { return target; }
    public ExprNode getStart() { return start; }
    public ExprNode getEnd() { return end; }

    @Override
    public String toString() {
        return "SliceExpr";
    }
}