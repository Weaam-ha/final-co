package ast_py;

import java.util.List;

public class ProgramNode extends AST_Node {

    public ProgramNode(List<StmtNode> statements, int line, int column) {
        super(line, column);
        for (StmtNode s : statements) {
            addChild(s);
        }
    }
}
