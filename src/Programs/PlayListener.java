// Generated from Play.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PlayParser}.
 */
public interface PlayListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PlayParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(PlayParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlayParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(PlayParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlayParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PlayParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlayParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PlayParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlayParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(PlayParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlayParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(PlayParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlayParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(PlayParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlayParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(PlayParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlayParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void enterIf_stat(PlayParser.If_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlayParser#if_stat}.
	 * @param ctx the parse tree
	 */
	void exitIf_stat(PlayParser.If_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlayParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void enterCondition_block(PlayParser.Condition_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlayParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void exitCondition_block(PlayParser.Condition_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlayParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void enterStat_block(PlayParser.Stat_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlayParser#stat_block}.
	 * @param ctx the parse tree
	 */
	void exitStat_block(PlayParser.Stat_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlayParser#while_stat}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stat(PlayParser.While_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlayParser#while_stat}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stat(PlayParser.While_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlayParser#display}.
	 * @param ctx the parse tree
	 */
	void enterDisplay(PlayParser.DisplayContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlayParser#display}.
	 * @param ctx the parse tree
	 */
	void exitDisplay(PlayParser.DisplayContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlayParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(PlayParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlayParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(PlayParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlayParser#function_def}.
	 * @param ctx the parse tree
	 */
	void enterFunction_def(PlayParser.Function_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlayParser#function_def}.
	 * @param ctx the parse tree
	 */
	void exitFunction_def(PlayParser.Function_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlayParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(PlayParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlayParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(PlayParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlayParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(PlayParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlayParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(PlayParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlayParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(PlayParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlayParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(PlayParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PlayParser#return_stat}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stat(PlayParser.Return_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link PlayParser#return_stat}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stat(PlayParser.Return_statContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(PlayParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(PlayParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpr(PlayParser.UnaryMinusExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpr(PlayParser.UnaryMinusExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpr(PlayParser.FunctionCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpr(PlayParser.FunctionCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicationExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpr(PlayParser.MultiplicationExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicationExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpr(PlayParser.MultiplicationExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(PlayParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(PlayParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(PlayParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(PlayParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(PlayParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(PlayParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(PlayParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(PlayParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(PlayParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(PlayParser.EqualityExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(PlayParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(PlayParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link PlayParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(PlayParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link PlayParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(PlayParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberAtom}
	 * labeled alternative in {@link PlayParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNumberAtom(PlayParser.NumberAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberAtom}
	 * labeled alternative in {@link PlayParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNumberAtom(PlayParser.NumberAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link PlayParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterBooleanAtom(PlayParser.BooleanAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link PlayParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitBooleanAtom(PlayParser.BooleanAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link PlayParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterIdAtom(PlayParser.IdAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link PlayParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitIdAtom(PlayParser.IdAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link PlayParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterStringAtom(PlayParser.StringAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link PlayParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitStringAtom(PlayParser.StringAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullAtom}
	 * labeled alternative in {@link PlayParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterNullAtom(PlayParser.NullAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullAtom}
	 * labeled alternative in {@link PlayParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitNullAtom(PlayParser.NullAtomContext ctx);
}