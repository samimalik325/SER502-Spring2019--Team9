// Generated from src/com/simple/compiler/simple.g4 by ANTLR 4.7.1

package com.simple.compiler;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link simpleParser}.
 */
public interface simpleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link simpleParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(simpleParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(simpleParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#statement_list}.
	 * @param ctx the parse tree
	 */
	void enterStatement_list(simpleParser.Statement_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#statement_list}.
	 * @param ctx the parse tree
	 */
	void exitStatement_list(simpleParser.Statement_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(simpleParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(simpleParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#declaration_list}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration_list(simpleParser.Declaration_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#declaration_list}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration_list(simpleParser.Declaration_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(simpleParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(simpleParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#assignment_statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_statement(simpleParser.Assignment_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#assignment_statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_statement(simpleParser.Assignment_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(simpleParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(simpleParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void enterElse_statement(simpleParser.Else_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void exitElse_statement(simpleParser.Else_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(simpleParser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(simpleParser.While_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement(simpleParser.For_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement(simpleParser.For_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#print_statement}.
	 * @param ctx the parse tree
	 */
	void enterPrint_statement(simpleParser.Print_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#print_statement}.
	 * @param ctx the parse tree
	 */
	void exitPrint_statement(simpleParser.Print_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#function_statement}.
	 * @param ctx the parse tree
	 */
	void enterFunction_statement(simpleParser.Function_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#function_statement}.
	 * @param ctx the parse tree
	 */
	void exitFunction_statement(simpleParser.Function_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn_statement(simpleParser.Return_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn_statement(simpleParser.Return_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#function_call_statement}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call_statement(simpleParser.Function_call_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#function_call_statement}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call_statement(simpleParser.Function_call_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void enterConditional_expression(simpleParser.Conditional_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void exitConditional_expression(simpleParser.Conditional_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#bool_expression}.
	 * @param ctx the parse tree
	 */
	void enterBool_expression(simpleParser.Bool_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#bool_expression}.
	 * @param ctx the parse tree
	 */
	void exitBool_expression(simpleParser.Bool_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(simpleParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(simpleParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(simpleParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(simpleParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link simpleParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(simpleParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link simpleParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(simpleParser.FactorContext ctx);
}