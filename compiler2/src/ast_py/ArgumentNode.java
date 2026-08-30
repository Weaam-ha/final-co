package ast_py;

public class ArgumentNode extends AST_Node {
    public String name;
    public ExprNode value;

    public ArgumentNode(String name, ExprNode value, int line, int column) {
        super(line, column);
        this.name = name;
        this.value = value;

        addChild(value);
    }
}

