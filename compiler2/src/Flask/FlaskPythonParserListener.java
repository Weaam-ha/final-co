// Generated from C:/Users/elaf3/Downloads/38833FF26BA1D.UnigramPreview_g9c9v27vpyspw!App/compiler003/compiler2/src/Flask/FlaskPythonParser.g4 by ANTLR 4.13.2
package Flask;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FlaskPythonParser}.
 */
public interface FlaskPythonParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(FlaskPythonParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(FlaskPythonParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(FlaskPythonParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(FlaskPythonParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#globalStmt}.
	 * @param ctx the parse tree
	 */
	void enterGlobalStmt(FlaskPythonParser.GlobalStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#globalStmt}.
	 * @param ctx the parse tree
	 */
	void exitGlobalStmt(FlaskPythonParser.GlobalStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#augAssign}.
	 * @param ctx the parse tree
	 */
	void enterAugAssign(FlaskPythonParser.AugAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#augAssign}.
	 * @param ctx the parse tree
	 */
	void exitAugAssign(FlaskPythonParser.AugAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#augOp}.
	 * @param ctx the parse tree
	 */
	void enterAugOp(FlaskPythonParser.AugOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#augOp}.
	 * @param ctx the parse tree
	 */
	void exitAugOp(FlaskPythonParser.AugOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#importStmt}.
	 * @param ctx the parse tree
	 */
	void enterImportStmt(FlaskPythonParser.ImportStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#importStmt}.
	 * @param ctx the parse tree
	 */
	void exitImportStmt(FlaskPythonParser.ImportStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#importList}.
	 * @param ctx the parse tree
	 */
	void enterImportList(FlaskPythonParser.ImportListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#importList}.
	 * @param ctx the parse tree
	 */
	void exitImportList(FlaskPythonParser.ImportListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#varAssign}.
	 * @param ctx the parse tree
	 */
	void enterVarAssign(FlaskPythonParser.VarAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#varAssign}.
	 * @param ctx the parse tree
	 */
	void exitVarAssign(FlaskPythonParser.VarAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#decoratorFunc}.
	 * @param ctx the parse tree
	 */
	void enterDecoratorFunc(FlaskPythonParser.DecoratorFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#decoratorFunc}.
	 * @param ctx the parse tree
	 */
	void exitDecoratorFunc(FlaskPythonParser.DecoratorFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(FlaskPythonParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(FlaskPythonParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(FlaskPythonParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(FlaskPythonParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(FlaskPythonParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(FlaskPythonParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(FlaskPythonParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(FlaskPythonParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(FlaskPythonParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(FlaskPythonParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(FlaskPythonParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(FlaskPythonParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#returnValues}.
	 * @param ctx the parse tree
	 */
	void enterReturnValues(FlaskPythonParser.ReturnValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#returnValues}.
	 * @param ctx the parse tree
	 */
	void exitReturnValues(FlaskPythonParser.ReturnValuesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code starExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStarExpr(FlaskPythonParser.StarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code starExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStarExpr(FlaskPythonParser.StarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pipeExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPipeExpr(FlaskPythonParser.PipeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pipeExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPipeExpr(FlaskPythonParser.PipeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code slashExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSlashExpr(FlaskPythonParser.SlashExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code slashExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSlashExpr(FlaskPythonParser.SlashExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterModExpr(FlaskPythonParser.ModExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitModExpr(FlaskPythonParser.ModExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gtExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGtExpr(FlaskPythonParser.GtExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gtExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGtExpr(FlaskPythonParser.GtExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTrueExpr(FlaskPythonParser.TrueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTrueExpr(FlaskPythonParser.TrueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(FlaskPythonParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(FlaskPythonParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code minusExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMinusExpr(FlaskPythonParser.MinusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minusExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMinusExpr(FlaskPythonParser.MinusExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lteqExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLteqExpr(FlaskPythonParser.LteqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lteqExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLteqExpr(FlaskPythonParser.LteqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code generatorExprAlt}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGeneratorExprAlt(FlaskPythonParser.GeneratorExprAltContext ctx);
	/**
	 * Exit a parse tree produced by the {@code generatorExprAlt}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGeneratorExprAlt(FlaskPythonParser.GeneratorExprAltContext ctx);
	/**
	 * Enter a parse tree produced by the {@code neqExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNeqExpr(FlaskPythonParser.NeqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code neqExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNeqExpr(FlaskPythonParser.NeqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(FlaskPythonParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(FlaskPythonParser.StringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ampExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAmpExpr(FlaskPythonParser.AmpExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ampExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAmpExpr(FlaskPythonParser.AmpExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isNotExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIsNotExpr(FlaskPythonParser.IsNotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isNotExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIsNotExpr(FlaskPythonParser.IsNotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLtExpr(FlaskPythonParser.LtExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLtExpr(FlaskPythonParser.LtExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dictExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDictExpr(FlaskPythonParser.DictExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dictExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDictExpr(FlaskPythonParser.DictExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFalseExpr(FlaskPythonParser.FalseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFalseExpr(FlaskPythonParser.FalseExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterListExpr(FlaskPythonParser.ListExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitListExpr(FlaskPythonParser.ListExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIsExpr(FlaskPythonParser.IsExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIsExpr(FlaskPythonParser.IsExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInExpr(FlaskPythonParser.InExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInExpr(FlaskPythonParser.InExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code indexOrSliceExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIndexOrSliceExpr(FlaskPythonParser.IndexOrSliceExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indexOrSliceExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIndexOrSliceExpr(FlaskPythonParser.IndexOrSliceExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(FlaskPythonParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(FlaskPythonParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPlusExpr(FlaskPythonParser.PlusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPlusExpr(FlaskPythonParser.PlusExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code gteqExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGteqExpr(FlaskPythonParser.GteqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code gteqExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGteqExpr(FlaskPythonParser.GteqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallGenerator}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallGenerator(FlaskPythonParser.FuncCallGeneratorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallGenerator}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallGenerator(FlaskPythonParser.FuncCallGeneratorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqExpr(FlaskPythonParser.EqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqExpr(FlaskPythonParser.EqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(FlaskPythonParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(FlaskPythonParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notInExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotInExpr(FlaskPythonParser.NotInExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notInExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotInExpr(FlaskPythonParser.NotInExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code caretExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCaretExpr(FlaskPythonParser.CaretExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code caretExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCaretExpr(FlaskPythonParser.CaretExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleStarExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDoubleStarExpr(FlaskPythonParser.DoubleStarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleStarExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDoubleStarExpr(FlaskPythonParser.DoubleStarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noneExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNoneExpr(FlaskPythonParser.NoneExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noneExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNoneExpr(FlaskPythonParser.NoneExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleSlashExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDoubleSlashExpr(FlaskPythonParser.DoubleSlashExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleSlashExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDoubleSlashExpr(FlaskPythonParser.DoubleSlashExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCall}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(FlaskPythonParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCall}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(FlaskPythonParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tupleExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTupleExpr(FlaskPythonParser.TupleExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tupleExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTupleExpr(FlaskPythonParser.TupleExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(FlaskPythonParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(FlaskPythonParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(FlaskPythonParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link FlaskPythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(FlaskPythonParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code indexOnly}
	 * labeled alternative in {@link FlaskPythonParser#sliceOrIndex}.
	 * @param ctx the parse tree
	 */
	void enterIndexOnly(FlaskPythonParser.IndexOnlyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indexOnly}
	 * labeled alternative in {@link FlaskPythonParser#sliceOrIndex}.
	 * @param ctx the parse tree
	 */
	void exitIndexOnly(FlaskPythonParser.IndexOnlyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sliceOnly}
	 * labeled alternative in {@link FlaskPythonParser#sliceOrIndex}.
	 * @param ctx the parse tree
	 */
	void enterSliceOnly(FlaskPythonParser.SliceOnlyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sliceOnly}
	 * labeled alternative in {@link FlaskPythonParser#sliceOrIndex}.
	 * @param ctx the parse tree
	 */
	void exitSliceOnly(FlaskPythonParser.SliceOnlyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sliceWithStep}
	 * labeled alternative in {@link FlaskPythonParser#sliceOrIndex}.
	 * @param ctx the parse tree
	 */
	void enterSliceWithStep(FlaskPythonParser.SliceWithStepContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sliceWithStep}
	 * labeled alternative in {@link FlaskPythonParser#sliceOrIndex}.
	 * @param ctx the parse tree
	 */
	void exitSliceWithStep(FlaskPythonParser.SliceWithStepContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#dottedID}.
	 * @param ctx the parse tree
	 */
	void enterDottedID(FlaskPythonParser.DottedIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#dottedID}.
	 * @param ctx the parse tree
	 */
	void exitDottedID(FlaskPythonParser.DottedIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(FlaskPythonParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(FlaskPythonParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(FlaskPythonParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(FlaskPythonParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#tupleLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTupleLiteral(FlaskPythonParser.TupleLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#tupleLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTupleLiteral(FlaskPythonParser.TupleLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#generatorExpr}.
	 * @param ctx the parse tree
	 */
	void enterGeneratorExpr(FlaskPythonParser.GeneratorExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#generatorExpr}.
	 * @param ctx the parse tree
	 */
	void exitGeneratorExpr(FlaskPythonParser.GeneratorExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void enterListLiteral(FlaskPythonParser.ListLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void exitListLiteral(FlaskPythonParser.ListLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#dictLiteral}.
	 * @param ctx the parse tree
	 */
	void enterDictLiteral(FlaskPythonParser.DictLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#dictLiteral}.
	 * @param ctx the parse tree
	 */
	void exitDictLiteral(FlaskPythonParser.DictLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#dictItem}.
	 * @param ctx the parse tree
	 */
	void enterDictItem(FlaskPythonParser.DictItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#dictItem}.
	 * @param ctx the parse tree
	 */
	void exitDictItem(FlaskPythonParser.DictItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskPythonParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(FlaskPythonParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskPythonParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(FlaskPythonParser.ExprStmtContext ctx);
}