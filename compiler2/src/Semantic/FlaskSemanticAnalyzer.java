package Semantic;

import SymboleTable.SymbolTable;
import SymboleTable.SymbolTable.Symbol;
import ast_py.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlaskSemanticAnalyzer {

    private final AST_Node root;
    private final SymbolTable symbolTable;
    private final List<SemanticError> errors = new ArrayList<>();
    private final Map<String, String> variableTypes = new HashMap<>();

    private static final String TYPE_MISMATCH = "Type Mismatch";
    private static final String TYPE_ERROR = "Type Error";
    private static final String UNDEFINED_VARIABLE = "Undefined Variable";
    private static final String SCOPE_ERROR = "Scope Error";
    private static final String UNSUPPORTED_OPERAND = "unsupported operand type(s) for ";
    private static final String NOT_SUPPORTED_BETWEEN = "' not supported between instances of '";

    public FlaskSemanticAnalyzer(AST_Node root, SymbolTable symbolTable) {
        this.root = root;
        this.symbolTable = symbolTable;
    }

    public void analyze() {
        errors.clear();
        variableTypes.clear();
        visit(root);
    }

    private void visit(AST_Node node) {
        if (node == null) return;

        if (node instanceof VarAssignNode assign) {
            for (AST_Node child : node.getChildren()) {
                visit(child);
            }
            String type = getExpressionType(assign.getValue());
            variableTypes.put(assign.getIdentifier(), type);
            return;
        }

        if (node instanceof AugAssignNode aug) {
            for (AST_Node child : node.getChildren()) {
                visit(child);
            }
            checkAugAssignTypeMismatch(aug);
            return;
        }

        if (node instanceof BinaryExprNode binary) {
            checkTypeMismatch(binary);
        }

        if (node instanceof IndexExprNode index) {
            checkIndexError(index);
        }

        if (node instanceof ForStmtNode forStmt) {
            checkForLoopTypeError(forStmt);
            visit(forStmt.iterable);
            visit(forStmt.block);
            return;
        }

        if (node instanceof FuncDefNode funcDef) {
            symbolTable.enterScope("function:" + funcDef.name);
            for (AST_Node child : node.getChildren()) {
                visit(child);
            }
            symbolTable.exitScope();
            return;
        }

        if (node instanceof FuncCallNode funcCall) {
            checkNotCallableError(funcCall);
            checkBuiltinFuncTypeError(funcCall);
        }

        if (node instanceof IdentifierNode id) {
            checkUndefinedVariable(id);
        }

        for (AST_Node child : node.getChildren()) {
            visit(child);
        }
    }

    private void checkUndefinedVariable(IdentifierNode node) {
        String varName = node.parts.get(0);

        if (isPythonBuiltIn(varName)) return;
        if (isKeyword(varName)) return;
        if (isBuiltinFunction(varName)) return;

        if (symbolTable.lookup(varName) != null) return;

        Symbol elsewhere = symbolTable.lookupAnywhere(varName);
        if (elsewhere != null) {
            addError(SCOPE_ERROR,
                    "name '" + varName + "' is not accessible from this scope "
                            + "(defined in scope '" + elsewhere.getScope() + "')",
                    node.getLine());
            return;
        }

        addError(UNDEFINED_VARIABLE,
                "name '" + varName + "' is not defined",
                node.getLine());
    }

    private boolean isPythonBuiltIn(String name) {
        return name.equals("__name__") || name.equals("__file__") ||
                name.equals("__doc__") || name.equals("__package__") ||
                name.equals("__loader__") || name.equals("__spec__") ||
                name.equals("__annotations__") || name.equals("__builtins__") ||
                name.equals("__import__") || name.equals("True") ||
                name.equals("False") || name.equals("None") ||
                name.equals("NotImplemented") || name.equals("Ellipsis") ||
                name.equals("__debug__");
    }

    private boolean isKeyword(String name) {
        return name.equals("break") || name.equals("continue") ||
                name.equals("pass") || name.equals("return") ||
                name.equals("global") || name.equals("nonlocal") ||
                name.equals("assert") || name.equals("del") ||
                name.equals("yield") || name.equals("raise") ||
                name.equals("try") || name.equals("except") ||
                name.equals("finally") || name.equals("with") ||
                name.equals("as") || name.equals("lambda") ||
                name.equals("class") || name.equals("def") ||
                name.equals("if") || name.equals("elif") ||
                name.equals("else") || name.equals("for") ||
                name.equals("while") || name.equals("import") ||
                name.equals("from") || name.equals("and") ||
                name.equals("or") || name.equals("not") ||
                name.equals("in") || name.equals("is");
    }

    private void checkForLoopTypeError(ForStmtNode node) {
        String iterableType = getExpressionType(node.iterable);

        if (!isIterableType(iterableType)) {
            addError(TYPE_ERROR,
                    "'" + iterableType.toLowerCase() + "' object is not iterable",
                    node.getLine());
        }
    }

    private boolean isIterableType(String type) {
        return type.equals("LIST") || type.equals("DICT") ||
                type.equals("STRING") || type.equals("TUPLE") ||
                type.equals("SET") || type.equals("UNKNOWN") ||
                type.equals("GENERATOR");
    }

    private void checkIndexError(IndexExprNode node) {
        String targetType = getExpressionType(node.getTarget());

        if (targetType.equals("NUMBER") || targetType.equals("FLOAT") ||
                targetType.equals("BOOLEAN") || targetType.equals("NONE") ||
                targetType.equals("FUNCTION") || targetType.equals("MODULE") ||
                targetType.equals("SET") || targetType.equals("GENERATOR")) {
            addError(TYPE_ERROR,
                    "'" + targetType.toLowerCase() + "' object is not subscriptable",
                    node.getLine());
        }
    }

    private void checkNotCallableError(FuncCallNode node) {
        if (node.functionName == null || node.functionName.parts.isEmpty()) return;

        String funcName = String.join(".", node.functionName.parts);

        if (isBuiltinFunction(funcName)) return;

        Symbol sym = symbolTable.lookup(funcName);
        if (sym != null && sym.getType().equalsIgnoreCase("function")) return;

        if (node.functionName.parts.size() > 1) return;

        String varType = variableTypes.get(funcName);
        if (varType != null && isNonCallableType(varType)) {
            addError(TYPE_ERROR,
                    "'" + varType.toLowerCase() + "' object is not callable",
                    node.getLine());
        }
    }

    private boolean isBuiltinFunction(String name) {
        return name.equals("len") || name.equals("sum") || name.equals("max") ||
                name.equals("min") || name.equals("abs") || name.equals("round") ||
                name.equals("int") || name.equals("float") || name.equals("str") ||
                name.equals("bool") || name.equals("list") || name.equals("dict") ||
                name.equals("set") || name.equals("tuple") || name.equals("type") ||
                name.equals("print") || name.equals("range") || name.equals("sorted") ||
                name.equals("reversed") || name.equals("enumerate") || name.equals("zip") ||
                name.equals("map") || name.equals("filter") || name.equals("input") ||
                name.equals("open") || name.equals("isinstance") || name.equals("issubclass") ||
                name.equals("hasattr") || name.equals("getattr") || name.equals("setattr") ||
                name.equals("delattr") || name.equals("callable") || name.equals("repr") ||
                name.equals("hash") || name.equals("id") || name.equals("dir") ||
                name.equals("vars") || name.equals("locals") || name.equals("globals") ||
                name.equals("eval") || name.equals("exec") || name.equals("compile") ||
                name.equals("ord") || name.equals("chr") || name.equals("hex") ||
                name.equals("oct") || name.equals("bin") || name.equals("format") ||
                name.equals("next") || name.equals("iter") || name.equals("super") ||
                name.equals("property") || name.equals("classmethod") ||
                name.equals("staticmethod") || name.equals("object") ||
                name.equals("render_template") || name.equals("redirect") ||
                name.equals("url_for") || name.equals("Flask") ||
                name.equals("request");
    }

    private boolean isNonCallableType(String type) {
        return type.equals("NUMBER") || type.equals("FLOAT") || type.equals("INT") ||
                type.equals("STRING") || type.equals("NONE") || type.equals("BOOLEAN") ||
                type.equals("LIST") || type.equals("DICT") || type.equals("SET") ||
                type.equals("TUPLE");
    }

    private void checkBuiltinFuncTypeError(FuncCallNode node) {
        if (node.functionName == null || node.functionName.parts.isEmpty()) return;
        if (node.arguments == null || node.arguments.arguments.isEmpty()) return;

        String funcName = String.join(".", node.functionName.parts);
        ExprNode firstArg = node.arguments.arguments.get(0).value;
        String argType = getExpressionType(firstArg);

        if (argType.equals("UNKNOWN")) return;

        if (funcName.equals("len") || funcName.equals("sum") ||
                funcName.equals("max") || funcName.equals("min") ||
                funcName.equals("sorted") || funcName.equals("reversed")) {
            if (!isIterableType(argType)) {
                addError(TYPE_ERROR,
                        "object of type '" + argType.toLowerCase() + "' has no " + funcName + "()",
                        node.getLine());
            }
        }

        if (funcName.equals("int") || funcName.equals("float")) {
            if (argType.equals("LIST") || argType.equals("DICT") ||
                    argType.equals("SET") || argType.equals("NONE") ||
                    argType.equals("BOOLEAN")) {
                addError(TYPE_ERROR,
                        funcName + "() argument must be a string or a number, not '" +
                                argType.toLowerCase() + "'",
                        node.getLine());
            }
        }

        if (funcName.equals("list") || funcName.equals("tuple") || funcName.equals("set")) {
            if (argType.equals("NUMBER") || argType.equals("FLOAT") ||
                    argType.equals("NONE") || argType.equals("BOOLEAN")) {
                addError(TYPE_ERROR,
                        "'" + argType.toLowerCase() + "' object is not iterable",
                        node.getLine());
            }
        }

        if (funcName.equals("dict")) {
            if (argType.equals("NUMBER") || argType.equals("STRING") ||
                    argType.equals("NONE") || argType.equals("BOOLEAN")) {
                addError(TYPE_ERROR,
                        "dict() argument must be a sequence of key-value pairs, not '" +
                                argType.toLowerCase() + "'",
                        node.getLine());
            }
        }

        if (funcName.equals("abs") || funcName.equals("round")) {
            if (!isNumericType(argType)) {
                addError(TYPE_ERROR,
                        "bad operand type for " + funcName + "(): '" + argType.toLowerCase() + "'",
                        node.getLine());
            }
        }
    }

    private void checkTypeMismatch(BinaryExprNode node) {
        checkTypeMismatchCore(
                getExpressionType(node.getLeft()),
                node.getOperator(),
                getExpressionType(node.getRight()),
                node.getLine()
        );
    }

    private void checkAugAssignTypeMismatch(AugAssignNode node) {
        String baseOp = baseOperatorFor(node.getOperator());
        if (baseOp == null) return; // defensive: unrecognized operator text, nothing to check

        String leftType = resolveIdentifierType(node.getIdentifier());
        String rightType = getExpressionType(node.getValue());

        checkTypeMismatchCore(leftType, baseOp, rightType, node.getLine());
    }

    private String baseOperatorFor(String augOp) {
        return switch (augOp) {
            case "+=" -> "+";
            case "-=" -> "-";
            case "*=" -> "*";
            case "/=" -> "/";
            case "%=" -> "%";
            case "//=" -> "//";
            case "**=" -> "**";
            default -> null;
        };
    }

    private String resolveIdentifierType(String varName) {
        if (variableTypes.containsKey(varName)) {
            return variableTypes.get(varName);
        }
        Symbol sym = symbolTable.lookup(varName);
        return sym != null ? inferTypeFromSymbol(sym) : "UNKNOWN";
    }

    private void checkTypeMismatchCore(String leftType, String operator, String rightType, int line) {
        if (leftType.equals("UNKNOWN") && rightType.equals("UNKNOWN")) return;

        if (operator.equals("+")) {
            if (leftType.equals("STRING") && rightType.equals("STRING")) return;
            if (isNumericType(leftType) && isNumericType(rightType)) return;
            if (leftType.equals("LIST") && rightType.equals("LIST")) return;

            if (leftType.equals("STRING") && isNumericType(rightType)) {
                addError(TYPE_MISMATCH, UNSUPPORTED_OPERAND + "+: 'str' and '" + rightType.toLowerCase() + "'", line);
                return;
            }
            if (isNumericType(leftType) && rightType.equals("STRING")) {
                addError(TYPE_MISMATCH, UNSUPPORTED_OPERAND + "+: '" + leftType.toLowerCase() + "' and 'str'", line);
                return;
            }
            if ((leftType.equals("LIST") && rightType.equals("STRING")) ||
                    (leftType.equals("STRING") && rightType.equals("LIST"))) {
                addError(TYPE_MISMATCH, UNSUPPORTED_OPERAND + "+: '" + leftType.toLowerCase() + "' and '" + rightType.toLowerCase() + "'", line);
                return;
            }
            if ((leftType.equals("LIST") && rightType.equals("DICT")) ||
                    (leftType.equals("DICT") && rightType.equals("LIST"))) {
                addError(TYPE_MISMATCH, UNSUPPORTED_OPERAND + "+: '" + leftType.toLowerCase() + "' and '" + rightType.toLowerCase() + "'", line);
                return;
            }
            if (leftType.equals("DICT") && rightType.equals("DICT")) {
                addError(TYPE_MISMATCH, UNSUPPORTED_OPERAND + "+: 'dict' and 'dict'", line);
                return;
            }
            if (leftType.equals("NONE") || rightType.equals("NONE")) {
                addError(TYPE_MISMATCH, UNSUPPORTED_OPERAND + "+: 'NoneType' and '" + (leftType.equals("NONE") ? rightType.toLowerCase() : leftType.toLowerCase()) + "'", line);
                return;
            }
            if ((leftType.equals("BOOLEAN") && rightType.equals("STRING")) ||
                    (leftType.equals("STRING") && rightType.equals("BOOLEAN"))) {
                addError(TYPE_MISMATCH, UNSUPPORTED_OPERAND + "+: '" + leftType.toLowerCase() + "' and '" + rightType.toLowerCase() + "'", line);
                return;
            }
            if ((leftType.equals("DICT") && rightType.equals("STRING")) ||
                    (leftType.equals("STRING") && rightType.equals("DICT"))) {
                addError(TYPE_MISMATCH, UNSUPPORTED_OPERAND + "+: '" + leftType.toLowerCase() + "' and '" + rightType.toLowerCase() + "'", line);
                return;
            }
        }

        if (operator.equals("-")) {
            if (isNumericType(leftType) && isNumericType(rightType)) return;

            if (leftType.equals("STRING") || rightType.equals("STRING") ||
                    leftType.equals("LIST") || rightType.equals("LIST") ||
                    leftType.equals("NONE") || rightType.equals("NONE") ||
                    leftType.equals("DICT") || rightType.equals("DICT") ||
                    leftType.equals("BOOLEAN") || rightType.equals("BOOLEAN")) {
                addError(TYPE_MISMATCH, UNSUPPORTED_OPERAND + "-: '" + leftType.toLowerCase() + "' and '" + rightType.toLowerCase() + "'", line);
            }
        }

        if (operator.equals("*")) {
            if (isNumericType(leftType) && isNumericType(rightType)) return;
            if (leftType.equals("STRING") && isIntegerType(rightType)) return;
            if (isIntegerType(leftType) && rightType.equals("STRING")) return;
            if (leftType.equals("LIST") && isIntegerType(rightType)) return;
            if (isIntegerType(leftType) && rightType.equals("LIST")) return;

            if (leftType.equals("STRING") && rightType.equals("STRING")) {
                addError(TYPE_MISMATCH, UNSUPPORTED_OPERAND + "*: 'str' and 'str'", line);
                return;
            }
            if ((leftType.equals("STRING") && rightType.equals("FLOAT")) ||
                    (leftType.equals("FLOAT") && rightType.equals("STRING"))) {
                addError(TYPE_MISMATCH, UNSUPPORTED_OPERAND + "*: '" + leftType.toLowerCase() + "' and '" + rightType.toLowerCase() + "'", line);
                return;
            }
            if ((leftType.equals("LIST") && rightType.equals("STRING")) ||
                    (leftType.equals("STRING") && rightType.equals("LIST"))) {
                addError(TYPE_MISMATCH, UNSUPPORTED_OPERAND + "*: '" + leftType.toLowerCase() + "' and '" + rightType.toLowerCase() + "'", line);
                return;
            }
            if (leftType.equals("LIST") && rightType.equals("LIST")) {
                addError(TYPE_MISMATCH, UNSUPPORTED_OPERAND + "*: 'list' and 'list'", line);
                return;
            }
            if (leftType.equals("NONE") || rightType.equals("NONE")) {
                addError(TYPE_MISMATCH, UNSUPPORTED_OPERAND + "*: 'NoneType' and '" + (leftType.equals("NONE") ? rightType.toLowerCase() : leftType.toLowerCase()) + "'", line);
                return;
            }
            if (leftType.equals("DICT") || rightType.equals("DICT")) {
                addError(TYPE_MISMATCH, UNSUPPORTED_OPERAND + "*: '" + leftType.toLowerCase() + "' and '" + rightType.toLowerCase() + "'", line);
                return;
            }
            if ((leftType.equals("BOOLEAN") && rightType.equals("STRING")) ||
                    (leftType.equals("STRING") && rightType.equals("BOOLEAN"))) {
                addError(TYPE_MISMATCH, UNSUPPORTED_OPERAND + "*: '" + leftType.toLowerCase() + "' and '" + rightType.toLowerCase() + "'", line);
                return;
            }
        }

        if (operator.equals("/")) {
            if (isNumericType(leftType) && isNumericType(rightType)) return;

            if (leftType.equals("STRING") || rightType.equals("STRING") ||
                    leftType.equals("LIST") || rightType.equals("LIST") ||
                    leftType.equals("NONE") || rightType.equals("NONE") ||
                    leftType.equals("DICT") || rightType.equals("DICT") ||
                    leftType.equals("BOOLEAN") || rightType.equals("BOOLEAN")) {
                addError(TYPE_MISMATCH, UNSUPPORTED_OPERAND + "/: '" + leftType.toLowerCase() + "' and '" + rightType.toLowerCase() + "'", line);
            }
        }

        if (operator.equals("//")) {
            if (isNumericType(leftType) && isNumericType(rightType)) return;

            if (leftType.equals("STRING") || rightType.equals("STRING")) {
                addError(TYPE_MISMATCH, UNSUPPORTED_OPERAND + "//: '" + leftType.toLowerCase() + "' and '" + rightType.toLowerCase() + "'", line);
            }
        }

        if (operator.equals("%")) {
            if (isNumericType(leftType) && isNumericType(rightType)) return;
            if (leftType.equals("STRING")) return;

            if (leftType.equals("STRING") || rightType.equals("STRING")) {
                addError(TYPE_MISMATCH, UNSUPPORTED_OPERAND + "%: '" + leftType.toLowerCase() + "' and '" + rightType.toLowerCase() + "'", line);
            }
        }

        if (operator.equals("**")) {
            if (isNumericType(leftType) && isNumericType(rightType)) return;

            if (leftType.equals("STRING") || rightType.equals("STRING")) {
                addError(TYPE_MISMATCH, UNSUPPORTED_OPERAND + "**: '" + leftType.toLowerCase() + "' and '" + rightType.toLowerCase() + "'", line);
            }
        }

        if (operator.equals("<") || operator.equals(">") ||
                operator.equals("<=") || operator.equals(">=")) {

            if (isNumericType(leftType) && isNumericType(rightType)) return;
            if (leftType.equals("STRING") && rightType.equals("STRING")) return;
            if (leftType.equals("LIST") && rightType.equals("LIST")) return;

            if (leftType.equals("STRING") && isNumericType(rightType)) {
                addError(TYPE_MISMATCH, "'" + operator + NOT_SUPPORTED_BETWEEN + "str' and '" + rightType.toLowerCase() + "'", line);
                return;
            }
            if (isNumericType(leftType) && rightType.equals("STRING")) {
                addError(TYPE_MISMATCH, "'" + operator + NOT_SUPPORTED_BETWEEN + leftType.toLowerCase() + "' and 'str'", line);
                return;
            }
            if (leftType.equals("LIST") && isNumericType(rightType)) {
                addError(TYPE_MISMATCH, "'" + operator + NOT_SUPPORTED_BETWEEN + "list' and '" + rightType.toLowerCase() + "'", line);
                return;
            }
            if (isNumericType(leftType) && rightType.equals("LIST")) {
                addError(TYPE_MISMATCH, "'" + operator + NOT_SUPPORTED_BETWEEN + leftType.toLowerCase() + "' and 'list'", line);
                return;
            }
            if (leftType.equals("DICT") || rightType.equals("DICT")) {
                addError(TYPE_MISMATCH, "'" + operator + NOT_SUPPORTED_BETWEEN + leftType.toLowerCase() + "' and '" + rightType.toLowerCase() + "'", line);
                return;
            }
            if (leftType.equals("LIST") && rightType.equals("DICT")) {
                addError(TYPE_MISMATCH, "'" + operator + NOT_SUPPORTED_BETWEEN + "list' and 'dict'", line);
                return;
            }
            if (leftType.equals("DICT") && rightType.equals("LIST")) {
                addError(TYPE_MISMATCH, "'" + operator + NOT_SUPPORTED_BETWEEN + "dict' and 'list'", line);
                return;
            }
            if (leftType.equals("NONE") || rightType.equals("NONE")) {
                addError(TYPE_MISMATCH, "'" + operator + NOT_SUPPORTED_BETWEEN + "NoneType' and '" + (leftType.equals("NONE") ? rightType.toLowerCase() : leftType.toLowerCase()) + "'", line);
                return;
            }
            if ((leftType.equals("BOOLEAN") && rightType.equals("STRING")) ||
                    (leftType.equals("STRING") && rightType.equals("BOOLEAN"))) {
                addError(TYPE_MISMATCH, "'" + operator + NOT_SUPPORTED_BETWEEN + leftType.toLowerCase() + "' and '" + rightType.toLowerCase() + "'", line);
            }
        }
    }

    private String getExpressionType(ExprNode expr) {
        if (expr instanceof StringNode) return "STRING";
        if (expr instanceof NumberNode num) {
            return num.value == Math.floor(num.value) && !Double.isInfinite(num.value) ? "NUMBER" : "FLOAT";
        }
        if (expr instanceof BooleanNode) return "BOOLEAN";
        if (expr instanceof NoneNode) return "NONE";
        if (expr instanceof ListNode) return "LIST";
        if (expr instanceof DictNode) return "DICT";
        if (expr instanceof SetNode) return "SET";
        if (expr instanceof TupleNode) return "TUPLE";
        if (expr instanceof GeneratorExprNode) return "GENERATOR";

        if (expr instanceof IdentifierNode id) {
            return resolveIdentifierType(id.parts.get(0));
        }

        if (expr instanceof BinaryExprNode bin) {
            String leftType = getExpressionType(bin.getLeft());
            String rightType = getExpressionType(bin.getRight());
            String op = bin.getOperator();

            if (op.equals("+")) {
                if (leftType.equals("STRING") || rightType.equals("STRING")) return "STRING";
                if (isNumericType(leftType) && isNumericType(rightType)) return "NUMBER";
            }
            if (op.equals("-") || op.equals("*") || op.equals("/") ||
                    op.equals("//") || op.equals("%") || op.equals("**")) {
                if (isNumericType(leftType) && isNumericType(rightType)) return "NUMBER";
            }
            if (op.equals("==") || op.equals("!=") || op.equals("<") ||
                    op.equals(">") || op.equals("<=") || op.equals(">=") ||
                    op.equals("in") || op.equals("is") || op.equals("is not")) {
                return "BOOLEAN";
            }
        }

        if (expr instanceof UnaryExprNode unary) {
            if (unary.getOperator().equals("not")) return "BOOLEAN";
            return getExpressionType(unary.getExpr());
        }

        if (expr instanceof FuncCallNode funcCall) {
            String funcName = String.join(".", funcCall.functionName.parts);
            return switch (funcName) {
                case "max", "min", "sum", "len", "abs", "int", "float", "round" -> "NUMBER";
                case "str" -> "STRING";
                case "bool" -> "BOOLEAN";
                case "list" -> "LIST";
                case "dict" -> "DICT";
                case "set" -> "SET";
                case "tuple" -> "TUPLE";
                case "request.form.get" -> "STRING";
                default -> "UNKNOWN";
            };
        }

        if (expr instanceof IndexExprNode index) {
            String targetType = getExpressionType(index.getTarget());
            if (targetType.equals("STRING")) return "STRING";
            if (targetType.equals("LIST") || targetType.equals("DICT") || targetType.equals("TUPLE")) return "UNKNOWN";
        }

        return "UNKNOWN";
    }

    private String inferTypeFromSymbol(Symbol sym) {
        String type = sym.getType().toLowerCase();
        return switch (type) {
            case "module" -> "MODULE";
            case "function" -> "FUNCTION";
            case "template-variable", "parameter" -> "UNKNOWN";
            default -> "UNKNOWN";
        };
    }

    private boolean isNumericType(String type) {
        return type.equals("NUMBER") || type.equals("INT") ||
                type.equals("FLOAT") || type.equals("INTEGER");
    }

    private boolean isIntegerType(String type) {
        return type.equals("NUMBER") || type.equals("INT") || type.equals("INTEGER");
    }

    private void addError(String name, String details, int line) {
        for (SemanticError e : errors) {
            if (e.getName().equals(name) && e.getLine() == line &&
                    e.getDetails().equals(details)) {
                return;
            }
        }
        errors.add(new SemanticError(name, details, line));
    }

    public List<SemanticError> getErrors() {
        return errors;
    }

    public void printErrors() {
        if (errors.isEmpty()) {
            System.out.println("\u001b[32m✓ No Semantic Errors found in Flask code.\u001b[0m");
            return;
        }

        System.out.println("\u001b[31mSemantic Errors in Flask:\u001b[0m");
        System.out.println("+------------------------+---------+------------------------------------------------------------+");
        System.out.println("| Error Name             | Line    | Details                                                    |");
        System.out.println("+------------------------+---------+------------------------------------------------------------+");

        for (SemanticError e : errors) {
            System.out.printf("| %-22s | %-7d | %-58s |\n",
                    e.getName(), e.getLine(), e.getDetails());
        }

        System.out.println("+------------------------+---------+------------------------------------------------------------+");
    }
}