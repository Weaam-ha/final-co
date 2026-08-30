package ast_py;

import java.util.List;

public class FuncDefNode extends StmtNode {

    public String name;
    public List<String> params;

    public FuncDefNode(String name, List<String> params, BlockNode block, int line, int column) {
        super(line, column);
        this.name = name;
        this.params = params;

        addChild(block);
    }
}
