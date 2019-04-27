package com.simple.compiler;

import java.util.ArrayList;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
//import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
//import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.simple.common.SimpleConstants;

public class SimpleIntermediateCodeGenarator extends simpleBaseListener  {
	
	private static SimpleIntermediateCodeGenarator INSTANCE = null;
	private static Stack<String> funcStack = new Stack<String>();
	private static ArrayList<String> iCode;
//	
	private static Stack<Integer> nestedStack = new Stack<Integer>(); 

	private static int countNestedValue = 1;
	
	public static SimpleIntermediateCodeGenarator getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SimpleIntermediateCodeGenarator();
			iCode = new ArrayList<String>();
		}
		
		return INSTANCE;
	}
	
	@Override public void enterProgram(simpleParser.ProgramContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitProgram(simpleParser.ProgramContext ctx) { }

	@Override public void enterStatement_list(simpleParser.Statement_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStatement_list(simpleParser.Statement_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStatement(simpleParser.StatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStatement(simpleParser.StatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDeclaration_list(simpleParser.Declaration_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDeclaration_list(simpleParser.Declaration_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDeclaration(simpleParser.DeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDeclaration(simpleParser.DeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterVar_declaration(simpleParser.Var_declarationContext ctx) {
		
		if (funcStack.isEmpty()) {
			iCode.add(SimpleConstants.DECLAREINT + ctx.IDENTIFIER().getText());
	} else {
		
		String accumulator = funcStack.pop();
		funcStack.push(accumulator);
		iCode.add(SimpleConstants.DECLAREINT + accumulator + ctx.IDENTIFIER().getText());
	}
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVar_declaration(simpleParser.Var_declarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterInt_declaration(simpleParser.Int_declarationContext ctx) {
		
//		System.out.println(ctx.IDENTIFIER().getText());
		
		if (funcStack.isEmpty()) {
			iCode.add(SimpleConstants.DECLAREINT + ctx.IDENTIFIER().getText());
	} else {
		
		String accumulator = funcStack.pop();
		funcStack.push(accumulator);
		iCode.add(SimpleConstants.DECLAREINT + accumulator + ctx.IDENTIFIER().getText());
	}
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInt_declaration(simpleParser.Int_declarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBool_declaration(simpleParser.Bool_declarationContext ctx) {
		
//		System.out.println(ctx.IDENTIFIER().getText());
		
		if (funcStack.isEmpty()) {
			iCode.add(SimpleConstants.DECLAREBOOL + ctx.IDENTIFIER().getText());
	} else {
		
		String accumulator = funcStack.pop();
		funcStack.push(accumulator);
		iCode.add(SimpleConstants.DECLAREBOOL + accumulator + ctx.IDENTIFIER().getText());
	}
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBool_declaration(simpleParser.Bool_declarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAssignment_statement(simpleParser.Assignment_statementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAssignment_statement(simpleParser.Assignment_statementContext ctx) {
		
		if (funcStack.isEmpty()) {
			iCode.add(SimpleConstants.ASSIGN + ctx.IDENTIFIER().getText());
		} else {
			String accumulator = funcStack.pop();
			funcStack.push(accumulator);
			iCode.add(SimpleConstants.ASSIGN + accumulator + ctx.IDENTIFIER().getText());
		}
		
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIf_statement(simpleParser.If_statementContext ctx) {
		
		
		iCode.add(SimpleConstants.IF.trim() +"_" + countNestedValue);
		nestedStack.push(countNestedValue);
		countNestedValue++;
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIf_statement(simpleParser.If_statementContext ctx) {
		
		iCode.add(SimpleConstants.END_IF.trim() + "_" + nestedStack.pop());
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterElse_statement(simpleParser.Else_statementContext ctx) { 
		
		int accumulator = nestedStack.pop();
		nestedStack.push(accumulator);
		iCode.add(SimpleConstants.ELSE.trim() + "_" + accumulator);
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitElse_statement(simpleParser.Else_statementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterWhile_statement(simpleParser.While_statementContext ctx) {
		
		iCode.add(SimpleConstants.WHILELOOP.trim() + "_" + nestedStack.push(countNestedValue));
		countNestedValue++;
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitWhile_statement(simpleParser.While_statementContext ctx) { 
		
		iCode.add(SimpleConstants.END_WHILELOOP.trim() + "_" + nestedStack.pop());
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFor_statement(simpleParser.For_statementContext ctx) { 
		
		iCode.add(SimpleConstants.FORLOOP.trim() + "_" + nestedStack.push(countNestedValue));
		countNestedValue++;
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFor_statement(simpleParser.For_statementContext ctx) { 
		
		iCode.add(SimpleConstants.END_FORLOOP.trim() + "_" + nestedStack.pop());
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPrint_statement(simpleParser.Print_statementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPrint_statement(simpleParser.Print_statementContext ctx) {
		
		if (ctx.expression() != null) {
			iCode.add(SimpleConstants.PRINT);
		} 
		
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFunction_statement(simpleParser.Function_statementContext ctx) {
		
		if (ctx.IDENTIFIER() != null) {
			funcStack.push("#"+ctx.IDENTIFIER(0).getText());
			iCode.add(SimpleConstants.FUNCTION_DECLARE.trim() + "_" + ctx.IDENTIFIER(0).getText());
			String func = "";
			func = SimpleConstants.FUNCTION_PARAM.trim();
			for (int i = 1; i < ctx.IDENTIFIER().size(); i++) {
				func = func + " #" +ctx.IDENTIFIER(0).getText() + ctx.IDENTIFIER(i).getText();
			}
			
			iCode.add(func);
		}
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFunction_statement(simpleParser.Function_statementContext ctx) { 
		
		if (ctx.IDENTIFIER(0) != null) {
			iCode.add(SimpleConstants.FUNCTION_END.trim() + "_" + ctx.IDENTIFIER(0).getText());
			funcStack.pop();
		}
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterReturn_statement(simpleParser.Return_statementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitReturn_statement(simpleParser.Return_statementContext ctx) {
		
		iCode.add(SimpleConstants.FUNCTION_RETURN);
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFunction_call_statement(simpleParser.Function_call_statementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFunction_call_statement(simpleParser.Function_call_statementContext ctx) { 
		
		iCode.add(SimpleConstants.FUNCTION_CALL.trim() + "_" + ctx.IDENTIFIER().getText());
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterConditional_expression(simpleParser.Conditional_expressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitConditional_expression(simpleParser.Conditional_expressionContext ctx) { 
		
		if (ctx.getText().contains("==")) {
			iCode.add(SimpleConstants.EQUAL);
		} else if (ctx.getText().contains("<=")) {
			iCode.add(SimpleConstants.LESS_EQUAL);
		} else if (ctx.getText().contains(">=")) {
			iCode.add(SimpleConstants.GREAT_EQUAL);
		} else if (ctx.getText().contains("!=")) {
			iCode.add(SimpleConstants.NOT_EQUAL);
		} else if (ctx.getText().contains("<")) {
			iCode.add(SimpleConstants.LESS_THAN);
		} else if (ctx.getText().contains(">")) {
			iCode.add(SimpleConstants.GREATER_THAN);
		}
		else if (ctx.getText().contains("? ")) {
			iCode.add("? ");
		}
	
		iCode.add(SimpleConstants.CONDITION_END);
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBool_expression(simpleParser.Bool_expressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBool_expression(simpleParser.Bool_expressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpression(simpleParser.ExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpression(simpleParser.ExpressionContext ctx) {
		
		if (ctx.getText().contains("+")) {
			iCode.add(SimpleConstants.ADDITION);
		} else if (ctx.getText().contains("-")) {
			iCode.add(SimpleConstants.SUBTRACTION);
		} 
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTerm(simpleParser.TermContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTerm(simpleParser.TermContext ctx) {
		
		if (ctx.getText().contains("*")) {
			iCode.add(SimpleConstants.MULTIPLY);
	} else if (ctx.getText().contains("/")) {
		iCode.add(SimpleConstants.DIVISION);
	} else if (ctx.getText().contains("%")) {
		iCode.add(SimpleConstants.REMINDER);
		
	}
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFactor(simpleParser.FactorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFactor(simpleParser.FactorContext ctx) {
		
		if (ctx.NUMBER() != null) {
			iCode.add(SimpleConstants.PUSH + ctx.NUMBER().getText());
		} else if (ctx.IDENTIFIER() != null ) {
			if (funcStack.isEmpty()) {
				iCode.add(SimpleConstants.LOAD + ctx.IDENTIFIER().getText());
			} else {
				String accumulator = funcStack.pop();
				funcStack.push(accumulator);
				iCode.add(SimpleConstants.LOAD + accumulator + ctx.IDENTIFIER().getText());
			}
		}
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBool_factor(simpleParser.Bool_factorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBool_factor(simpleParser.Bool_factorContext ctx) {
		
		if (ctx.BOOLEAN() != null)
		{
			iCode.add(SimpleConstants.PUSH + ctx.BOOLEAN().getText());
		} else if (ctx.IDENTIFIER() != null ) {
			if (funcStack.isEmpty()) {
				iCode.add(SimpleConstants.LOAD + ctx.IDENTIFIER().getText());
			} else {
				String accumulator = funcStack.pop();
				funcStack.push(accumulator);
				iCode.add(SimpleConstants.LOAD + accumulator + ctx.IDENTIFIER().getText());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) {
		
	
	}
	
	public ArrayList<String> getiCode() {
		return iCode;
	}
	
	
}
	
