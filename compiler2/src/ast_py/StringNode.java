package ast_py;

public class StringNode extends ExprNode {
    public String value;

    public StringNode(String value, int line, int column) {
        super(line, column);
        this.value = value;
    }
}
