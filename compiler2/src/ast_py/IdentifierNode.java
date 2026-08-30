package ast_py;

import java.util.List;

public class IdentifierNode extends ExprNode {
    public List<String> parts;

    public IdentifierNode(List<String> parts, int line, int column) {
        super(line, column);
        this.parts = parts;
    }
}
