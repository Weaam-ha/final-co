package Visitor_Flask;

import SymboleTable.SymbolTable;
import ast_py.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import Flask.FlaskPythonParser;
import Flask.FlaskPythonParserBaseVisitor;
import java.util.*;

public class AstBuilder extends FlaskPythonParserBaseVisitor<AST_Node> {

    private final SymbolTable symtab;

    public AstBuilder(SymbolTable symtab) {
        this.symtab = symtab;
    }

    public SymbolTable getSymbolTable() {
        return symtab;
    }

    private int line(Token t) {
        return t.getLine();
    }

    private int column(Token t) {
        return t.getCharPositionInLine();
    }

    @Override
    public AST_Node visitProgram(FlaskPythonParser.ProgramContext ctx) {
        List<StmtNode> stmts = new ArrayList<>();
        for (FlaskPythonParser.StmtContext s : ctx.stmt()) {
            AST_Node node = visit(s);
            if (node instanceof StmtNode) {
                stmts.add((StmtNode) node);
            }
        }
        return new ProgramNode(stmts, 0, 0);
    }

    @Override
    public AST_Node visitAugAssign(FlaskPythonParser.AugAssignContext ctx) {
        String varName = ctx.ID().getText();
        String operator = ctx.augOp().getText();
        ExprNode value = (ExprNode) visit(ctx.expr());

        return new AugAssignNode(
                varName, operator, value,
                line(ctx.ID().getSymbol()),
                column(ctx.ID().getSymbol())
        );
    }

    @Override
    public AST_Node visitIndexOrSliceExpr(FlaskPythonParser.IndexOrSliceExprContext ctx) {
        ExprNode target = (ExprNode) visit(ctx.expr());
        FlaskPythonParser.SliceOrIndexContext sliceCtx = ctx.sliceOrIndex();

        if (sliceCtx instanceof FlaskPythonParser.IndexOnlyContext indexCtx) {
            ExprNode index = (ExprNode) visit(indexCtx.expr());
            return new IndexExprNode(target, index, line(ctx.start), column(ctx.start));
        }
        else if (sliceCtx instanceof FlaskPythonParser.SliceOnlyContext sliceOnlyCtx) {
            ExprNode start = sliceOnlyCtx.expr(0) != null ? (ExprNode) visit(sliceOnlyCtx.expr(0)) : null;
            ExprNode end = sliceOnlyCtx.expr().size() > 1 ? (ExprNode) visit(sliceOnlyCtx.expr(1)) : null;
            return new SliceExprNode(target, start, end, line(ctx.start), column(ctx.start));
        }
        else if (sliceCtx instanceof FlaskPythonParser.SliceWithStepContext sliceStepCtx) {
            ExprNode start = sliceStepCtx.expr(0) != null ? (ExprNode) visit(sliceStepCtx.expr(0)) : null;
            ExprNode end = sliceStepCtx.expr().size() > 1 ? (ExprNode) visit(sliceStepCtx.expr(1)) : null;
            return new SliceExprNode(target, start, end, line(ctx.start), column(ctx.start));
        }

        return target;
    }

    @Override
    public AST_Node visitTupleExpr(FlaskPythonParser.TupleExprContext ctx) {
        List<ExprNode> elems = new ArrayList<>();
        if (ctx.tupleLiteral().expr() != null) {
            for (FlaskPythonParser.ExprContext e : ctx.tupleLiteral().expr()) {
                elems.add((ExprNode) visit(e));
            }
        }
        return new TupleNode(elems, line(ctx.start), column(ctx.start));
    }

    @Override
    public AST_Node visitSlashExpr(FlaskPythonParser.SlashExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                "/",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start), column(ctx.start));
    }

    @Override
    public AST_Node visitDoubleSlashExpr(FlaskPythonParser.DoubleSlashExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                "//",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start), column(ctx.start));
    }

    @Override
    public AST_Node visitModExpr(FlaskPythonParser.ModExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                "%",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start), column(ctx.start));
    }

    @Override
    public AST_Node visitDoubleStarExpr(FlaskPythonParser.DoubleStarExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                "**",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start), column(ctx.start));
    }

    @Override
    public AST_Node visitPipeExpr(FlaskPythonParser.PipeExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                "|",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start), column(ctx.start));
    }

    @Override
    public AST_Node visitAmpExpr(FlaskPythonParser.AmpExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                "&",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start), column(ctx.start));
    }

    @Override
    public AST_Node visitCaretExpr(FlaskPythonParser.CaretExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                "^",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start), column(ctx.start));
    }

    @Override
    public AST_Node visitOrExpr(FlaskPythonParser.OrExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                "or",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start), column(ctx.start));
    }

    @Override
    public AST_Node visitAndExpr(FlaskPythonParser.AndExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                "and",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start), column(ctx.start));
    }

    @Override
    public AST_Node visitNotInExpr(FlaskPythonParser.NotInExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                "not in",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start), column(ctx.start));
    }

    @Override
    public AST_Node visitStmt(FlaskPythonParser.StmtContext ctx) {

        if (ctx.RETURN() != null) {
            List<ExprNode> values = new ArrayList<>();
            if (ctx.returnValues() != null) {
                for (FlaskPythonParser.ExprContext e : ctx.returnValues().expr()) {
                    AST_Node exprNode = visit(e);
                    if (exprNode instanceof ExprNode) {
                        values.add((ExprNode) exprNode);
                    }
                }
            }
            return new ReturnNode(values,
                    line(ctx.RETURN().getSymbol()),
                    column(ctx.RETURN().getSymbol()));
        }

        if (ctx.PASS() != null) {
            return new PassNode(
                    line(ctx.PASS().getSymbol()),
                    column(ctx.PASS().getSymbol()));
        }

        if (ctx.exprStmt() != null)
            return visit(ctx.exprStmt());

        if (ctx.varAssign() != null)
            return visit(ctx.varAssign());

        if (ctx.importStmt() != null)
            return visit(ctx.importStmt());

        if (ctx.decoratorFunc() != null)
            return visit(ctx.decoratorFunc());

        if (ctx.globalStmt() != null)
            return visit(ctx.globalStmt());

        if (ctx.ifStmt() != null)
            return visit(ctx.ifStmt());

        if (ctx.forStmt() != null)
            return visit(ctx.forStmt());

        if (ctx.whileStmt() != null)
            return visit(ctx.whileStmt());

        if (ctx.augAssign() != null)
            return visit(ctx.augAssign());

        return super.visitStmt(ctx);
    }

    @Override
    public AST_Node visitGlobalStmt(FlaskPythonParser.GlobalStmtContext ctx) {
        List<String> names = new ArrayList<>();
        for (TerminalNode id : ctx.ID()) {
            names.add(id.getText());
        }

        for (String n : names) {
            symtab.insert(n, "global", "Python");
        }

        return new GlobalStmtNode(
                names,
                line(ctx.GLOBAL().getSymbol()),
                column(ctx.GLOBAL().getSymbol())
        );
    }

    @Override
    public AST_Node visitImportStmt(FlaskPythonParser.ImportStmtContext ctx) {
        String module = ctx.ID().getText();

        List<String> names = new ArrayList<>();
        if (ctx.importList() != null) {
            for (TerminalNode id : ctx.importList().ID()) {
                names.add(id.getText());
            }
        }

        ImportStmtNode node = new ImportStmtNode(
                module,
                names,
                line(ctx.FROM().getSymbol()),
                column(ctx.FROM().getSymbol())
        );

        symtab.insert(module, "module", "Flask");
        for (String n : names) {
            symtab.insert(n, "imported", "Flask");
        }

        return node;
    }

    @Override
    public AST_Node visitVarAssign(FlaskPythonParser.VarAssignContext ctx) {
        AST_Node valueNode = visit(ctx.expr());
        VarAssignNode node = new VarAssignNode(
                ctx.ID().getText(),
                (ExprNode) valueNode,
                line(ctx.ID().getSymbol()),
                column(ctx.ID().getSymbol())
        );

        symtab.insert(node.getIdentifier(), "variable", "Python");

        return node;
    }

    @Override
    public AST_Node visitExprStmt(FlaskPythonParser.ExprStmtContext ctx) {
        AST_Node exprNode = visit(ctx.expr());
        return new ExprStmtNode(
                (ExprNode) exprNode,
                line(ctx.start),
                column(ctx.start)
        );
    }

    // ============================================================
    // if / else no longer create scopes — real Python does not scope
    // these. Variables assigned inside remain in the enclosing scope
    // (whichever function scope, or global, was already active).
    // ============================================================
    @Override
    public AST_Node visitIfStmt(FlaskPythonParser.IfStmtContext ctx) {

        ExprNode condition;

        if (ctx.expr() != null) {
            AST_Node visited = visit(ctx.expr());
            condition = visited instanceof ExprNode
                    ? (ExprNode) visited
                    : new BooleanNode(true, line(ctx.IF().getSymbol()), column(ctx.IF().getSymbol()));
        } else {
            condition = new BooleanNode(true, line(ctx.IF().getSymbol()), column(ctx.IF().getSymbol()));
        }

        BlockNode thenBlock = (BlockNode) visit(ctx.block(0));

        BlockNode elseBlock = null;
        if (ctx.ELSE() != null && ctx.block().size() > 1) {
            elseBlock = (BlockNode) visit(ctx.block(1));
        }

        return new IfStmtNode(
                condition,
                thenBlock,
                elseBlock,
                line(ctx.IF().getSymbol()),
                column(ctx.IF().getSymbol())
        );
    }

    // ============================================================
    // for no longer creates a scope — the loop variable leaks into
    // the enclosing scope, matching real Python.
    // ============================================================
    @Override
    public AST_Node visitForStmt(FlaskPythonParser.ForStmtContext ctx) {
        String variable = ctx.ID().getText();
        ExprNode iterable = (ExprNode) visit(ctx.expr());

        symtab.insert(variable, "variable", "Python");

        BlockNode block = (BlockNode) visit(ctx.block());

        return new ForStmtNode(
                variable,
                iterable,
                block,
                line(ctx.FOR().getSymbol()),
                column(ctx.FOR().getSymbol())
        );
    }

    // ============================================================
    // while no longer creates a scope, for the same reason.
    // ============================================================
    @Override
    public AST_Node visitWhileStmt(FlaskPythonParser.WhileStmtContext ctx) {
        ExprNode condition = (ExprNode) visit(ctx.expr());

        BlockNode block = (BlockNode) visit(ctx.block());

        return new WhileStmtNode(
                condition,
                block,
                line(ctx.WHILE().getSymbol()),
                column(ctx.WHILE().getSymbol())
        );
    }

    @Override
    public AST_Node visitBlock(FlaskPythonParser.BlockContext ctx) {
        List<StmtNode> stmts = new ArrayList<>();
        for (FlaskPythonParser.StmtContext s : ctx.stmt()) {
            AST_Node visited = visit(s);
            if (visited instanceof StmtNode) {
                stmts.add((StmtNode) visited);
            }
        }
        return new BlockNode(stmts, line(ctx.start), column(ctx.start));
    }

    @Override
    public AST_Node visitDecoratorFunc(FlaskPythonParser.DecoratorFuncContext ctx) {
        ArgListNode args = ctx.argList() != null
                ? (ArgListNode) visit(ctx.argList())
                : null;

        FuncDefNode func = (FuncDefNode) visit(ctx.funcDef());

        return new DecoratorFuncNode(
                func,
                args,
                line(ctx.start),
                column(ctx.start)
        );
    }

    @Override
    public AST_Node visitFuncDef(FlaskPythonParser.FuncDefContext ctx) {

        String funcName = ctx.ID().getText();

        List<String> params = new ArrayList<>();
        if (ctx.paramList() != null) {
            for (TerminalNode id : ctx.paramList().ID()) {
                params.add(id.getText());
            }
        }

        int funcLine = line(ctx.DEF().getSymbol());
        int funcCol = column(ctx.DEF().getSymbol());

        while (!symtab.currentScope().equals("global")) {
            symtab.exitScope();
        }

        symtab.insert(funcName, "function", "Python");

        symtab.enterScope("function:" + funcName);

        for (String p : params) {
            symtab.insert(p, "parameter", "Python");
        }

        BlockNode block = (BlockNode) visit(ctx.block());

        symtab.exitScope();

        return new FuncDefNode(funcName, params, block, funcLine, funcCol);
    }

    @Override
    public AST_Node visitParamList(FlaskPythonParser.ParamListContext ctx) {
        List<String> params = new ArrayList<>();
        for (TerminalNode id : ctx.ID()) {
            params.add(id.getText());
        }
        return new ParamListNode(params, line(ctx.start), column(ctx.start));
    }

    @Override
    public AST_Node visitNotExpr(FlaskPythonParser.NotExprContext ctx) {
        return new UnaryExprNode(
                "not",
                (ExprNode) visit(ctx.expr()),
                line(ctx.start),
                column(ctx.start)
        );
    }

    @Override
    public AST_Node visitPlusExpr(FlaskPythonParser.PlusExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                "+",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start),
                column(ctx.start)
        );
    }

    @Override
    public AST_Node visitEqExpr(FlaskPythonParser.EqExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                "==",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start),
                column(ctx.start)
        );
    }

    @Override
    public AST_Node visitInExpr(FlaskPythonParser.InExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                "in",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start),
                column(ctx.start)
        );
    }

    @Override
    public AST_Node visitNeqExpr(FlaskPythonParser.NeqExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                "!=",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start),
                column(ctx.start)
        );
    }

    @Override
    public AST_Node visitIsExpr(FlaskPythonParser.IsExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                "is",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start),
                column(ctx.start)
        );
    }

    @Override
    public AST_Node visitIsNotExpr(FlaskPythonParser.IsNotExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                "is not",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start),
                column(ctx.start)
        );
    }

    @Override
    public AST_Node visitFuncCall(FlaskPythonParser.FuncCallContext ctx) {
        FuncCallNode node = new FuncCallNode(
                (IdentifierNode) visit(ctx.dottedID()),
                ctx.argList() != null ? (ArgListNode) visit(ctx.argList()) : null,
                line(ctx.start),
                column(ctx.start)
        );

        String funcName = ctx.dottedID().getText();
        if (funcName.equals("render_template") && ctx.argList() != null) {
            for (FlaskPythonParser.ArgumentContext arg : ctx.argList().argument()) {
                if (arg.ID() != null) {
                    symtab.insert(arg.ID().getText(), "template-variable", "Flask");
                }
            }
        }

        return node;
    }

    @Override
    public AST_Node visitFuncCallGenerator(FlaskPythonParser.FuncCallGeneratorContext ctx) {
        ExprNode projection = (ExprNode) visit(ctx.expr(0));

        String variable = ctx.ID().getText();

        ExprNode iterableNode = (ExprNode) visit(ctx.expr(1));
        String iterable;
        if (iterableNode instanceof IdentifierNode) {
            iterable = String.join(".", ((IdentifierNode) iterableNode).parts);
        } else {
            iterable = ctx.expr(1).getText();
        }

        ExprNode condition = ctx.expr().size() > 2
                ? (ExprNode) visit(ctx.expr(2))
                : null;

        symtab.insert(variable, "variable", "Python");

        GeneratorExprNode generator = new GeneratorExprNode(
                projection, variable, iterable, condition,
                line(ctx.start), column(ctx.start)
        );

        IdentifierNode functionName = (IdentifierNode) visit(ctx.dottedID());

        ArgumentNode soleArg = new ArgumentNode(null, generator, line(ctx.start), column(ctx.start));
        List<ArgumentNode> argList = new ArrayList<>();
        argList.add(soleArg);

        return new FuncCallNode(
                functionName,
                new ArgListNode(argList, line(ctx.start), column(ctx.start)),
                line(ctx.start),
                column(ctx.start)
        );
    }

    @Override
    public AST_Node visitListExpr(FlaskPythonParser.ListExprContext ctx) {
        List<ExprNode> elems = new ArrayList<>();
        if (ctx.listLiteral().expr() != null) {
            for (FlaskPythonParser.ExprContext e : ctx.listLiteral().expr()) {
                elems.add((ExprNode) visit(e));
            }
        }
        return new ListNode(elems, line(ctx.start), column(ctx.start));
    }

    @Override
    public AST_Node visitLtExpr(FlaskPythonParser.LtExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                "<",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start),
                column(ctx.start)
        );
    }

    @Override
    public AST_Node visitGtExpr(FlaskPythonParser.GtExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                ">",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start),
                column(ctx.start)
        );
    }

    @Override
    public AST_Node visitLteqExpr(FlaskPythonParser.LteqExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                "<=",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start),
                column(ctx.start)
        );
    }

    @Override
    public AST_Node visitGteqExpr(FlaskPythonParser.GteqExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                ">=",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start),
                column(ctx.start)
        );
    }

    @Override
    public AST_Node visitMinusExpr(FlaskPythonParser.MinusExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                "-",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start),
                column(ctx.start)
        );
    }

    @Override
    public AST_Node visitStarExpr(FlaskPythonParser.StarExprContext ctx) {
        return new BinaryExprNode(
                (ExprNode) visit(ctx.expr(0)),
                "*",
                (ExprNode) visit(ctx.expr(1)),
                line(ctx.start),
                column(ctx.start)
        );
    }

    @Override
    public AST_Node visitDictExpr(FlaskPythonParser.DictExprContext ctx) {
        Map<ExprNode, ExprNode> items = new LinkedHashMap<>();
        if (ctx.dictLiteral().dictItem() != null) {
            for (FlaskPythonParser.DictItemContext item : ctx.dictLiteral().dictItem()) {
                ExprNode key = item.STRING() != null
                        ? new StringNode(item.STRING().getText(), line(item.start), column(item.start))
                        : new IdentifierNode(
                        Collections.singletonList(item.ID().getText()),
                        line(item.start),
                        column(item.start)
                );
                ExprNode value = (ExprNode) visit(item.expr());
                items.put(key, value);
            }
        }
        return new DictNode(items, line(ctx.start), column(ctx.start));
    }

    @Override
    public AST_Node visitGeneratorExprAlt(FlaskPythonParser.GeneratorExprAltContext ctx) {
        FlaskPythonParser.GeneratorExprContext g = ctx.generatorExpr();

        ExprNode expr = (ExprNode) visit(g.expr(0));

        String variable = g.ID().getText();

        ExprNode iterableNode = (ExprNode) visit(g.expr(1));
        String iterable;
        if (iterableNode instanceof IdentifierNode) {
            iterable = String.join(".", ((IdentifierNode) iterableNode).parts);
        } else {
            iterable = g.expr(1).getText();
        }

        ExprNode condition = g.expr().size() > 2
                ? (ExprNode) visit(g.expr(2))
                : null;

        symtab.insert(variable, "variable", "Python");

        return new GeneratorExprNode(
                expr,
                variable,
                iterable,
                condition,
                line(ctx.start),
                column(ctx.start)
        );
    }

    @Override
    public AST_Node visitDottedID(FlaskPythonParser.DottedIDContext ctx) {
        List<String> parts = new ArrayList<>();
        for (TerminalNode id : ctx.ID()) {
            parts.add(id.getText());
        }
        return new IdentifierNode(parts, line(ctx.start), column(ctx.start));
    }

    @Override
    public AST_Node visitIdExpr(FlaskPythonParser.IdExprContext ctx) {
        return visit(ctx.dottedID());
    }

    @Override
    public AST_Node visitArgument(FlaskPythonParser.ArgumentContext ctx) {
        if (ctx.ID() != null) {
            return new ArgumentNode(
                    ctx.ID().getText(),
                    (ExprNode) visit(ctx.expr()),
                    line(ctx.start),
                    column(ctx.start)
            );
        }
        return new ArgumentNode(
                null,
                (ExprNode) visit(ctx.expr()),
                line(ctx.start),
                column(ctx.start)
        );
    }

    @Override
    public AST_Node visitArgList(FlaskPythonParser.ArgListContext ctx) {
        List<ArgumentNode> args = new ArrayList<>();
        for (FlaskPythonParser.ArgumentContext a : ctx.argument()) {
            args.add((ArgumentNode) visit(a));
        }
        return new ArgListNode(args, line(ctx.start), column(ctx.start));
    }

    @Override
    public AST_Node visitStringExpr(FlaskPythonParser.StringExprContext ctx) {
        return new StringNode(
                ctx.STRING().getText(),
                line(ctx.start),
                column(ctx.start)
        );
    }

    @Override
    public AST_Node visitNumberExpr(FlaskPythonParser.NumberExprContext ctx) {
        return new NumberNode(
                Double.parseDouble(ctx.NUMBER().getText()),
                line(ctx.start),
                column(ctx.start)
        );
    }

    @Override
    public AST_Node visitTrueExpr(FlaskPythonParser.TrueExprContext ctx) {
        return new BooleanNode(
                true,
                line(ctx.start),
                column(ctx.start)
        );
    }

    @Override
    public AST_Node visitFalseExpr(FlaskPythonParser.FalseExprContext ctx) {
        return new BooleanNode(
                false,
                line(ctx.start),
                column(ctx.start)
        );
    }

    @Override
    public AST_Node visitNoneExpr(FlaskPythonParser.NoneExprContext ctx) {
        return new NoneNode(
                line(ctx.start),
                column(ctx.start)
        );
    }
}