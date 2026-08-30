package AST.Jinja;

import AST.Node;
import java.util.List;

public class JinjaIfBlockNode extends Node {

    private final JinjaIfHeaderNode header;
    private final List<Node> ifBody;
    private final List<JinjaElifBlockNode> elifBlocks;
    private final JinjaElseBlockNode elseBlock;

    public JinjaIfBlockNode(int line, int column,
                            JinjaIfHeaderNode header,
                            List<Node> ifBody,
                            List<JinjaElifBlockNode> elifBlocks,
                            JinjaElseBlockNode elseBlock) {
        super("JinjaIfBlockNode", line, column);
        this.header = header;
        this.ifBody = ifBody;
        this.elifBlocks = elifBlocks;
        this.elseBlock = elseBlock;
    }

    public JinjaIfHeaderNode getHeader() {
        return header;
    }

    public List<Node> getIfBody() {
        return ifBody;
    }

    public List<JinjaElifBlockNode> getElifBlocks() {
        return elifBlocks;
    }

    public JinjaElseBlockNode getElseBlock() {
        return elseBlock;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", ifBodySize=" + (ifBody != null ? ifBody.size() : 0)
                + ", elifCount=" + (elifBlocks != null ? elifBlocks.size() : 0)
                + ", hasElse=" + (elseBlock != null);
    }
}
