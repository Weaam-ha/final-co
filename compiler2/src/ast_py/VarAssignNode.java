package ast_py;


public class VarAssignNode extends StmtNode {

    private String identifier;
    private ExprNode value;

    public VarAssignNode(String identifier, ExprNode value,
                         int line, int column) {
        super(line, column);
        this.identifier = identifier;
        this.value = value;

        addChild(value);
    }

    public String getIdentifier() {
        return identifier;
    }

    public ExprNode getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "VarAssign(" + identifier + ")";
    }
}
