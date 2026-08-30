package ast_py;

public class FuncCallNode extends ExprNode {
    public IdentifierNode functionName;
    public ArgListNode arguments;

    public FuncCallNode(IdentifierNode functionName, ArgListNode arguments, int line, int column) {
        super(line, column);
        this.functionName = functionName;
        this.arguments = arguments;

        addChild(functionName);
        addChild(arguments);
    }
}

