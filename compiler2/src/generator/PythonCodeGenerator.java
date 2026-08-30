package generator;

import ast_py.*;

import java.util.List;
import java.util.Map;

public class PythonCodeGenerator {

    private final StringBuilder code = new StringBuilder();
    private int indentLevel = 0;
    private static final String INDENT = "    "; // 4 spaces

    public void generate(AST_Node root) {
        if (root == null) return;
        visit(root);
        indentLevel = 0;
    }

    // ============================================================
    // PASS: التوليد
    // ============================================================
    private void visit(AST_Node node) {
        if (node == null) return;

        if (node instanceof ProgramNode) {
            ProgramNode prog = (ProgramNode) node;
            List<AST_Node> children = prog.getChildren();

            // 1) Imports أولاً — لازم يكونوا قبل أي شي ثاني
            if (children != null) {
                for (AST_Node child : children) {
                    if (child instanceof ImportStmtNode) {
                        indentLevel = 0;
                        visit(child);
                    }
                }
            }

            // 2) VarAssign ثانياً — تعريف المتغيرات (مثل app و products)
            if (children != null) {
                for (AST_Node child : children) {
                    if (child instanceof VarAssignNode) {
                        indentLevel = 0;
                        visit(child);
                        code.append("\n");
                    }
                }
            }

            // 3) باقي العناصر (decorators, func defs, if __main__, ...)
            if (children != null) {
                for (AST_Node child : children) {
                    if (!(child instanceof ImportStmtNode) && !(child instanceof VarAssignNode)) {
                        indentLevel = 0;
                        visit(child);
                        code.append("\n\n");
                    }
                }
            }

        } else if (node instanceof ImportStmtNode) {
            emitImport((ImportStmtNode) node);
        } else if (node instanceof VarAssignNode) {
            emitVarAssign((VarAssignNode) node);
        } else if (node instanceof AugAssignNode) {
            emitAugAssign((AugAssignNode) node);
        } else if (node instanceof GlobalStmtNode) {
            emitGlobal((GlobalStmtNode) node);
        } else if (node instanceof DecoratorFuncNode) {
            emitDecoratorFunc((DecoratorFuncNode) node);
        } else if (node instanceof FuncDefNode) {
            emitFuncDef((FuncDefNode) node);
        } else if (node instanceof ForStmtNode) {
            emitForStmt((ForStmtNode) node);
        } else if (node instanceof IfStmtNode) {
            emitIfStmt((IfStmtNode) node);
        } else if (node instanceof ReturnNode) {
            emitReturn((ReturnNode) node);
        } else if (node instanceof PassNode) {
            emitIndent();
            code.append("pass\n");
        } else if (node instanceof ExprStmtNode) {
            emitExprStmt((ExprStmtNode) node);
        } else if (node instanceof BlockNode) {
            indentLevel++;
            List<AST_Node> children = node.getChildren();
            if (children != null) {
                for (AST_Node child : children) {
                    visit(child);
                    if (child instanceof ReturnNode) break;
                }
            }
            indentLevel--;
        }
    }

    // ============================================================
    // IMPORT — يطبع كل الأسماء كما هي بدون فلترة
    // ============================================================
    private void emitImport(ImportStmtNode node) {
        List<String> names = node.names;
        if (names == null || names.isEmpty()) return;
        code.append("from ").append(node.module).append(" import ");
        for (int i = 0; i < names.size(); i++) {
            code.append(names.get(i));
            if (i < names.size() - 1) code.append(", ");
        }
        code.append("\n");
    }

    // ============================================================
    // VARIABLE ASSIGNMENT
    // ============================================================
    private void emitVarAssign(VarAssignNode node) {
        emitIndent();
        code.append(node.getIdentifier()).append(" = ");
        emitExpression(node.getValue());
        code.append("\n");
    }

    // ============================================================
    // AUGMENTED ASSIGNMENT  (x += 1, x -= 1, ...)
    // ============================================================
    private void emitAugAssign(AugAssignNode node) {
        emitIndent();
        code.append(node.getIdentifier()).append(" ").append(node.getOperator()).append(" ");
        emitExpression(node.getValue());
        code.append("\n");
    }

    // ============================================================
    // GLOBAL STATEMENT  —  "global products"
    // ============================================================
    private void emitGlobal(GlobalStmtNode node) {
        emitIndent();
        code.append("global");
        if (node.names != null) {
            for (String name : node.names) {
                code.append(" ").append(name);
            }
        }
        code.append("\n");
    }

    // ============================================================
    // FUNCTION DEFINITION
    // ============================================================
    private void emitFuncDef(FuncDefNode node) {
        emitIndent();
        code.append("def ").append(node.name).append("(");

        List<String> params = node.params;
        if (params != null) {
            for (int i = 0; i < params.size(); i++) {
                code.append(params.get(i));
                if (i < params.size() - 1) code.append(", ");
            }
        }
        code.append("):\n");

        indentLevel++;
        BlockNode block = getBlock(node);
        if (block != null) {
            for (AST_Node child : block.getChildren()) {
                visit(child);
                if (child instanceof ReturnNode) break;
            }
        }
        indentLevel--;
    }

    // ============================================================
    // DECORATOR FUNCTION
    // ============================================================
    private void emitDecoratorFunc(DecoratorFuncNode node) {
        indentLevel = 0;
        emitIndent();
        code.append("@app.route(");

        if (node.decoratorArgs != null && node.decoratorArgs.arguments != null) {
            List<ArgumentNode> args = node.decoratorArgs.arguments;
            for (int i = 0; i < args.size(); i++) {
                ArgumentNode arg = args.get(i);
                if (arg.name != null && !arg.name.isEmpty()) {
                    code.append(arg.name).append("=");
                }
                emitExpression(arg.value);
                if (i < args.size() - 1) code.append(", ");
            }
        }
        code.append(")\n");

        indentLevel = 0;
        emitFuncDef(node.function);
        code.append("\n\n");
    }

    // ============================================================
    // FOR STATEMENT
    // ============================================================
    private void emitForStmt(ForStmtNode node) {
        emitIndent();
        code.append("for ").append(node.variable).append(" in ");

        Object iterable = node.iterable;
        if (iterable instanceof ExprNode) {
            emitExpression((ExprNode) iterable);
        } else if (iterable != null) {
            code.append(iterable.toString());
        } else {
            code.append("None");
        }

        code.append(":\n");

        indentLevel++;
        visit(node.block);
        indentLevel--;
    }

    // ============================================================
    // IF STATEMENT
    // ============================================================
    private void emitIfStmt(IfStmtNode node) {
        emitIndent();
        code.append("if ");
        emitExpression(node.getCondition());
        code.append(":\n");

        indentLevel++;
        visit(node.getThenBlock());
        indentLevel--;

        if (node.getElseBlock() != null) {
            emitIndent();
            code.append("else:\n");
            indentLevel++;
            visit(node.getElseBlock());
            indentLevel--;
        }
    }

    // ============================================================
    // RETURN STATEMENT
    // ============================================================
    private void emitReturn(ReturnNode node) {
        emitIndent();
        code.append("return");

        List<AST_Node> children = node.getChildren();
        if (children != null && !children.isEmpty()) {
            code.append(" ");
            for (int i = 0; i < children.size(); i++) {
                emitExpression((ExprNode) children.get(i));
                if (i < children.size() - 1) code.append(", ");
            }
        }
        code.append("\n");
    }

    // ============================================================
    // EXPRESSION STATEMENT (break, continue, pass, function calls, ...)
    // ============================================================
    private void emitExprStmt(ExprStmtNode node) {
        emitIndent();

        if (node.expr instanceof IdentifierNode) {
            IdentifierNode id = (IdentifierNode) node.expr;
            String name = String.join(".", id.parts);

            // break, continue, pass
            if (name.equals("break") || name.equals("continue") || name.equals("pass")) {
                code.append(name).append("\n");
                return;
            }
        }

        emitExpression(node.expr);
        code.append("\n");
    }

    // ============================================================
    // EXPRESSIONS
    // ============================================================
    private void emitExpression(ExprNode expr) {
        if (expr == null) return;

        if (expr instanceof StringNode) {
            code.append(((StringNode) expr).value);
        } else if (expr instanceof NumberNode) {
            double val = ((NumberNode) expr).value;
            if (val == Math.floor(val) && !Double.isInfinite(val)) {
                code.append((int) val);
            } else {
                code.append(val);
            }
        } else if (expr instanceof BooleanNode) {
            code.append(((BooleanNode) expr).value ? "True" : "False");
        } else if (expr instanceof NoneNode) {
            code.append("None");
        } else if (expr instanceof IdentifierNode) {
            code.append(String.join(".", ((IdentifierNode) expr).parts));
        } else if (expr instanceof BinaryExprNode) {
            emitBinaryExpr((BinaryExprNode) expr);
        } else if (expr instanceof UnaryExprNode) {
            emitUnaryExpr((UnaryExprNode) expr);
        } else if (expr instanceof FuncCallNode) {
            emitFuncCall((FuncCallNode) expr);
        } else if (expr instanceof ListNode) {
            emitList((ListNode) expr);
        } else if (expr instanceof DictNode) {
            emitDict((DictNode) expr);
        } else if (expr instanceof SetNode) {
            emitSet((SetNode) expr);
        } else if (expr instanceof TupleNode) {
            emitTuple((TupleNode) expr);
        } else if (expr instanceof IndexExprNode) {
            emitIndexExpr((IndexExprNode) expr);
        } else if (expr instanceof SliceExprNode) {
            emitSliceExpr((SliceExprNode) expr);
        } else if (expr instanceof GeneratorExprNode) {
            emitGeneratorExpr((GeneratorExprNode) expr);
        }
    }

    private void emitBinaryExpr(BinaryExprNode node) {
        emitExpression(node.getLeft());
        code.append(" ").append(node.getOperator()).append(" ");
        emitExpression(node.getRight());
    }

    private void emitUnaryExpr(UnaryExprNode node) {
        code.append(node.getOperator());
        if (node.getOperator().equals("not")) code.append(" ");
        emitExpression(node.getExpr());
    }

    private void emitFuncCall(FuncCallNode node) {
        code.append(String.join(".", node.functionName.parts)).append("(");

        if (node.arguments != null && node.arguments.arguments != null) {
            List<ArgumentNode> args = node.arguments.arguments;
            for (int i = 0; i < args.size(); i++) {
                ArgumentNode arg = args.get(i);
                if (arg.name != null && !arg.name.isEmpty()) {
                    code.append(arg.name).append("=");
                }
                emitExpression(arg.value);
                if (i < args.size() - 1) code.append(", ");
            }
        }
        code.append(")");
    }

    private void emitList(ListNode node) {
        code.append("[");
        List<ExprNode> elements = node.elements;
        if (elements != null) {
            for (int i = 0; i < elements.size(); i++) {
                emitExpression(elements.get(i));
                if (i < elements.size() - 1) code.append(", ");
            }
        }
        code.append("]");
    }

    private void emitDict(DictNode node) {
        code.append("{");
        Map<ExprNode, ExprNode> items = node.items;
        if (items != null && !items.isEmpty()) {
            int i = 0;
            for (Map.Entry<ExprNode, ExprNode> entry : items.entrySet()) {
                emitExpression(entry.getKey());
                code.append(": ");
                emitExpression(entry.getValue());
                if (i < items.size() - 1) code.append(", ");
                i++;
            }
        }
        code.append("}");
    }

    private void emitSet(SetNode node) {
        code.append("{");
        List<ExprNode> elements = node.elements;
        if (elements != null) {
            for (int i = 0; i < elements.size(); i++) {
                emitExpression(elements.get(i));
                if (i < elements.size() - 1) code.append(", ");
            }
        }
        code.append("}");
    }

    private void emitTuple(TupleNode node) {
        code.append("(");
        List<ExprNode> elements = node.elements;
        if (elements != null) {
            for (int i = 0; i < elements.size(); i++) {
                emitExpression(elements.get(i));
                if (i < elements.size() - 1) code.append(", ");
            }
        }
        code.append(")");
    }

    private void emitIndexExpr(IndexExprNode node) {
        emitExpression(node.getTarget());
        code.append("[");
        emitExpression(node.getIndex());
        code.append("]");
    }

    private void emitSliceExpr(SliceExprNode node) {
        emitExpression(node.getTarget());
        code.append("[");
        if (node.getStart() != null) emitExpression(node.getStart());
        code.append(":");
        if (node.getEnd() != null) emitExpression(node.getEnd());
        code.append("]");
    }

    private void emitGeneratorExpr(GeneratorExprNode node) {
        code.append("(");
        emitExpression(node.expr);
        code.append(" for ").append(node.variable).append(" in ");

        Object iterable = node.iterable;
        if (iterable instanceof ExprNode) {
            emitExpression((ExprNode) iterable);
        } else if (iterable != null) {
            code.append(iterable.toString());
        } else {
            code.append("None");
        }

        if (node.condition != null) {
            code.append(" if ");
            emitExpression(node.condition);
        }

        code.append(")");
    }

    // ============================================================
    // HELPERS
    // ============================================================
    private void emitIndent() {
        for (int i = 0; i < indentLevel; i++) {
            code.append(INDENT);
        }
    }

    private BlockNode getBlock(FuncDefNode node) {
        for (AST_Node child : node.getChildren()) {
            if (child instanceof BlockNode) {
                return (BlockNode) child;
            }
        }
        return null;
    }

    public String getGeneratedCode() {
        return code.toString();
    }
}