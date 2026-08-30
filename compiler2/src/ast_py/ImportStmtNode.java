package ast_py;

import java.util.List;

public class ImportStmtNode extends StmtNode {
    public String module;
    public List<String> names;

    public ImportStmtNode(String module, List<String> names, int line, int column) {
        super(line, column);
        this.module = module;
        this.names = names;

        addChild(new StringNode(module, line, column));

        if (names != null) {
            for (String n : names) {
                addChild(new StringNode(n, line, column));
            }
        }
    }

    @Override
    public String toString() {
        return "ImportStmt(" + module + ")";
    }
}

