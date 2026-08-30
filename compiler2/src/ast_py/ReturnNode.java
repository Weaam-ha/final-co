package ast_py;

import java.util.List;

public class ReturnNode extends StmtNode {

    public ReturnNode(List<ExprNode> values, int line, int column) {
        super(line, column);
        for (ExprNode e : values) {
            addChild(e);
        }
    }
}