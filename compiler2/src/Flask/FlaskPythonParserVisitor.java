// Generated from C:/Users/elaf3/Downloads/38833FF26BA1D.UnigramPreview_g9c9v27vpyspw!App/compiler003/compiler2/src/Flask/FlaskPythonParser.g4 by ANTLR 4.13.2
package Flask;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FlaskPythonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FlaskPythonParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(FlaskPythonParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(FlaskPythonParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#globalStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalStmt(FlaskPythonParser.GlobalStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#augAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAugAssign(FlaskPythonParser.AugAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#augOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAugOp(FlaskPythonParser.AugOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#importStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStmt(FlaskPythonParser.ImportStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#importList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportList(FlaskPythonParser.ImportListContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#varAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssign(FlaskPythonParser.VarAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#decoratorFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecoratorFunc(FlaskPythonParser.DecoratorFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(FlaskPythonParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(FlaskPythonParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(FlaskPythonParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(FlaskPythonParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(FlaskPythonParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(FlaskPythonParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#returnValues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnValues(FlaskPythonParser.ReturnValuesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code starExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStarExpr(FlaskPythonParser.StarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pipeExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipeExpr(FlaskPythonParser.PipeExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code slashExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlashExpr(FlaskPythonParser.SlashExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModExpr(FlaskPythonParser.ModExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code gtExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGtExpr(FlaskPythonParser.GtExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueExpr(FlaskPythonParser.TrueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpr(FlaskPythonParser.NumberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minusExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusExpr(FlaskPythonParser.MinusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lteqExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLteqExpr(FlaskPythonParser.LteqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code generatorExprAlt}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneratorExprAlt(FlaskPythonParser.GeneratorExprAltContext ctx);
	/**
	 * Visit a parse tree produced by the {@code neqExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeqExpr(FlaskPythonParser.NeqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpr(FlaskPythonParser.StringExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ampExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAmpExpr(FlaskPythonParser.AmpExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isNotExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsNotExpr(FlaskPythonParser.IsNotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ltExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtExpr(FlaskPythonParser.LtExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dictExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictExpr(FlaskPythonParser.DictExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseExpr(FlaskPythonParser.FalseExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpr(FlaskPythonParser.ListExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsExpr(FlaskPythonParser.IsExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpr(FlaskPythonParser.InExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexOrSliceExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOrSliceExpr(FlaskPythonParser.IndexOrSliceExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(FlaskPythonParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusExpr(FlaskPythonParser.PlusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code gteqExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGteqExpr(FlaskPythonParser.GteqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCallGenerator}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallGenerator(FlaskPythonParser.FuncCallGeneratorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpr(FlaskPythonParser.EqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(FlaskPythonParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notInExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotInExpr(FlaskPythonParser.NotInExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code caretExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaretExpr(FlaskPythonParser.CaretExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleStarExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleStarExpr(FlaskPythonParser.DoubleStarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noneExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoneExpr(FlaskPythonParser.NoneExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleSlashExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleSlashExpr(FlaskPythonParser.DoubleSlashExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCall}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(FlaskPythonParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tupleExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleExpr(FlaskPythonParser.TupleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(FlaskPythonParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(FlaskPythonParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexOnly}
	 * labeled alternative in {@link FlaskPythonParser#sliceOrIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOnly(FlaskPythonParser.IndexOnlyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sliceOnly}
	 * labeled alternative in {@link FlaskPythonParser#sliceOrIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSliceOnly(FlaskPythonParser.SliceOnlyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sliceWithStep}
	 * labeled alternative in {@link FlaskPythonParser#sliceOrIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSliceWithStep(FlaskPythonParser.SliceWithStepContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#dottedID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDottedID(FlaskPythonParser.DottedIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(FlaskPythonParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(FlaskPythonParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#tupleLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTupleLiteral(FlaskPythonParser.TupleLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#generatorExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneratorExpr(FlaskPythonParser.GeneratorExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#listLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListLiteral(FlaskPythonParser.ListLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#dictLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictLiteral(FlaskPythonParser.DictLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#dictItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictItem(FlaskPythonParser.DictItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskPythonParser#exprStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(FlaskPythonParser.ExprStmtContext ctx);
}