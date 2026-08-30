package printer;

import ast_py.AST_Node;

import java.util.List;

public class ASTPrinterr {

    public static void print(AST_Node node) {
        print(node, "", true);
    }

    private static void print(AST_Node node, String indent, boolean isLast) {
        if (node == null) return;

        System.out.print(indent);
        System.out.print("- ");

        System.out.println(
                node.getClass().getSimpleName() +
                        " [line=" + node.getLine() +
                        ", col=" + node.getColumn() + "]"
        );

        indent += "    ";

        List<AST_Node> children = node.getChildren();
        for (int i = 0; i < children.size(); i++) {
            print(children.get(i), indent, i == children.size() - 1);
        }
    }
}

