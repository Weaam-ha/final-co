package ast_py;

public class DecoratorFuncNode extends StmtNode {
    public FuncDefNode function;
    public ArgListNode decoratorArgs;

    public DecoratorFuncNode(FuncDefNode function, ArgListNode decoratorArgs, int line, int column) {
        super(line, column);
        this.function = function;
        this.decoratorArgs = decoratorArgs;

        addChild(function);
        addChild(decoratorArgs);
    }
}

