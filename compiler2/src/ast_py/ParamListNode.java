package ast_py;

import java.util.List;

public class ParamListNode extends AST_Node {

    private List<String> params;

    public ParamListNode(List<String> params, int line, int column) {
        super(line, column);
        this.params = params;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "ParamListNode{" +
                "params=" + params +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
