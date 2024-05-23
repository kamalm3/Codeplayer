// Generated from Play.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PlayParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PlayVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PlayParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(PlayParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlayParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PlayParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlayParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(PlayParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlayParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(PlayParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlayParser#if_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stat(PlayParser.If_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlayParser#condition_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_block(PlayParser.Condition_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlayParser#stat_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_block(PlayParser.Stat_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlayParser#while_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stat(PlayParser.While_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlayParser#display}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisplay(PlayParser.DisplayContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlayParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(PlayParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlayParser#function_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_def(PlayParser.Function_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlayParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(PlayParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlayParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(PlayParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlayParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(PlayParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PlayParser#return_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_stat(PlayParser.Return_statContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(PlayParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryMinusExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinusExpr(PlayParser.UnaryMinusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpr(PlayParser.FunctionCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicationExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpr(PlayParser.MultiplicationExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(PlayParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(PlayParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additiveExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(PlayParser.AdditiveExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(PlayParser.RelationalExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(PlayParser.EqualityExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link PlayParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(PlayParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link PlayParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(PlayParser.ParExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberAtom}
	 * labeled alternative in {@link PlayParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberAtom(PlayParser.NumberAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanAtom}
	 * labeled alternative in {@link PlayParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAtom(PlayParser.BooleanAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idAtom}
	 * labeled alternative in {@link PlayParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAtom(PlayParser.IdAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringAtom}
	 * labeled alternative in {@link PlayParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(PlayParser.StringAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullAtom}
	 * labeled alternative in {@link PlayParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullAtom(PlayParser.NullAtomContext ctx);
}