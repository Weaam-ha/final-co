package ast_py;

import java.util.List;

public class ArgListNode extends AST_Node {
    public List<ArgumentNode> arguments;

    public ArgListNode(List<ArgumentNode> arguments, int line, int column) {
        super(line, column);
        this.arguments = arguments;

        addChildren(arguments);
    }
}

