package com.simple.compiler;

import java.util.ArrayList;
import java.util.Stack;

//import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
//import org.antlr.v4.runtime.tree.TerminalNode;


import com.simple.common.SimpleConstants;

public class SimpleIntermediateCodeGenarator extends simpleBaseListener  {
	
	private static SimpleIntermediateCodeGenarator INSTANCE = null;
	private static ArrayList<String> iCode;

	
	public static SimpleIntermediateCodeGenarator getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SimpleIntermediateCodeGenarator();
			iCode = new ArrayList<String>();
		}
		
		return INSTANCE;
	}
	
	

	@Override public void enterProgram(simpleParser.ProgramContext ctx) { }

	@Override public void exitProgram(simpleParser.ProgramContext ctx) { }

	@Override public void enterStatement_list(simpleParser.Statement_listContext ctx) { }

	@Override public void exitStatement_list(simpleParser.Statement_listContext ctx) { }

	@Override public void enterStatement(simpleParser.StatementContext ctx) { }

	@Override public void exitStatement(simpleParser.StatementContext ctx) { }

	@Override public void enterDeclaration_list(simpleParser.Declaration_listContext ctx) { }

	@Override public void exitDeclaration_list(simpleParser.Declaration_listContext ctx) { }

	@Override public void enterDeclaration(simpleParser.DeclarationContext ctx) { }

	@Override public void exitDeclaration(simpleParser.DeclarationContext ctx) { }

	@Override public void enterAssignment_statement(simpleParser.Assignment_statementContext ctx) { }

	@Override public void exitAssignment_statement(simpleParser.Assignment_statementContext ctx) { }

	@Override public void enterIf_statement(simpleParser.If_statementContext ctx) { }

	@Override public void exitIf_statement(simpleParser.If_statementContext ctx) { }

	@Override public void enterElse_statement(simpleParser.Else_statementContext ctx) { }

	@Override public void exitElse_statement(simpleParser.Else_statementContext ctx) { }

	@Override public void enterWhile_statement(simpleParser.While_statementContext ctx) { }

	@Override public void exitWhile_statement(simpleParser.While_statementContext ctx) { }

	@Override public void enterFor_statement(simpleParser.For_statementContext ctx) { }

	@Override public void exitFor_statement(simpleParser.For_statementContext ctx) { }

	@Override public void enterPrint_statement(simpleParser.Print_statementContext ctx) { }

	@Override public void exitPrint_statement(simpleParser.Print_statementContext ctx) { }

	@Override public void enterFunction_statement(simpleParser.Function_statementContext ctx) { }

	@Override public void exitFunction_statement(simpleParser.Function_statementContext ctx) { }

	@Override public void enterReturn_statement(simpleParser.Return_statementContext ctx) { }

	@Override public void exitReturn_statement(simpleParser.Return_statementContext ctx) { }

	@Override public void enterFunction_call_statement(simpleParser.Function_call_statementContext ctx) { }

	@Override public void exitFunction_call_statement(simpleParser.Function_call_statementContext ctx) { }

	@Override public void enterConditional_expression(simpleParser.Conditional_expressionContext ctx) { }

	@Override public void exitConditional_expression(simpleParser.Conditional_expressionContext ctx) { }

	@Override public void enterBool_expression(simpleParser.Bool_expressionContext ctx) { }

	@Override public void exitBool_expression(simpleParser.Bool_expressionContext ctx) { }

	@Override public void enterExpression(simpleParser.ExpressionContext ctx) { }

	@Override public void exitExpression(simpleParser.ExpressionContext ctx) { }

	@Override public void enterTerm(simpleParser.TermContext ctx) { }

	@Override public void exitTerm(simpleParser.TermContext ctx) { }

	@Override public void enterFactor(simpleParser.FactorContext ctx) { }

	@Override public void exitFactor(simpleParser.FactorContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }

	@Override public void exitEveryRule(ParserRuleContext ctx) { }

	@Override public void visitTerminal(TerminalNode node) { }

	@Override public void visitErrorNode(ErrorNode node) { }
	
	
}
	
