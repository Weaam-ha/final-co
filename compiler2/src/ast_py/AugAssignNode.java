package ast_py;

public class AugAssignNode extends StmtNode {
    private String identifier;
    private String operator;
    private ExprNode value;

    public AugAssignNode(String identifier, String operator, ExprNode value,
                         int line, int column) {
        super(line, column);
        this.identifier = identifier;
        this.operator = operator;
        this.value = value;
        addChild(value);
    }

    public String getIdentifier() { return identifier; }
    public String getOperator() { return operator; }
    public ExprNode getValue() { return value; }

    @Override
    public String toString() {
        return "AugAssign(" + identifier + " " + operator + ")";
    }
}