package ast_py;

import java.util.List;


public class BlockNode extends AST_Node {

    private List<StmtNode> statements;

    public BlockNode(List<StmtNode> statements,
                     int line, int column) {
        super(line, column);
        this.statements = statements;

        for (StmtNode s : statements) {
            addChild(s);
        }
    }

    public List<StmtNode> getStatements() {
        return statements;
    }

    @Override
    public String toString() {
        return "Block";
    }
}