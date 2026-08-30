package ast_py;

import java.util.List;

/**
 * Represents a Python `global x, y, ...` statement.
 *
 * `names` is kept as a plain List<String> (not just AST children) because
 * Scope Analysis (Phase 5) will need to look up "is this identifier
 * declared global in the current function?" directly by name — that's
 * a scope-table lookup, not a tree walk.
 */
public class GlobalStmtNode extends StmtNode {

    public List<String> names;

    public GlobalStmtNode(List<String> names, int line, int column) {
        super(line, column);
        this.names = names;

        if (names != null) {
            for (String n : names) {
                addChild(new IdentifierNode(List.of(n), line, column));
            }
        }
    }

    @Override
    public String toString() {
        return "GlobalStmt(" + String.join(", ", names) + ")";
    }
}