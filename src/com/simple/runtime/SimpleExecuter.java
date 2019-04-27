package com.simple.runtime;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Scanner;
import java.util.Stack;

import com.simple.common.SimpleConstants;

public class SimpleExecuter {
	
	static int countForScope = 1;
	static boolean isForLoop = false;
	static boolean isWhileLoop = false;
	

	static ArrayList<String> listofCode = new ArrayList<String>();
	
	static int indexForIteration = 0;

	static Stack<Boolean> stackForBooleans = new Stack<Boolean>();
	
	static HashMap<String,Integer> variables = new HashMap<String,Integer>();
	
	static Stack<Integer> nestedStack = new Stack<Integer>();
	
	static HashMap<String,Boolean> boolVariables = new HashMap<String,Boolean>();
	
	static Stack<Integer> scope = new Stack<Integer>();
	
	static Stack<Integer> stackForIntegers = new Stack<Integer>();
	
	static Stack<Boolean> LoopStatusStack = new Stack<Boolean>();
	
	static Stack<Integer> stackTrace = new Stack<Integer>();
	
	
	
	public static void main(String[] args) {
		String filename = "resources/SamplePrograms/while-loop.simpleint";
		/*if (args.length > 0){
	    		filename = args[0];
	    	} else {
			System.out.println("input filename can't be empty");
			return;
		}*/
			
		if (!filename.contains(".simpleint")) {
//			System.out.println("Enter a valid .simple file");
			return;
		}
		
		try {
			for (String line : Files.readAllLines(Paths.get(filename))) {
				listofCode.add(line);
			}
		} catch (IOException e) {
//			System.out.println("File not found...Please specify valid input file");
			e.printStackTrace();
		}
		
		for (indexForIteration=0; indexForIteration<listofCode.size(); indexForIteration++) {
			
			execute();
		}
	}
	
	public static void MoveForward(String label) {
		boolean ifElse = label.contains(SimpleConstants.ELSE.trim())? true : false;
		int id = 0;
		if (ifElse) {
			String[] temp = label.split("_");
			id = Integer.parseInt(temp[1]);
		}
		for (int i = indexForIteration; i < listofCode.size(); i++) {
			String code = listofCode.get(i);
			if (code.trim().equals(label.trim()) || (ifElse && code.trim().contains(SimpleConstants.END_IF.trim() + "_" + id))) {
				indexForIteration = i;
				if (code.trim().contains(SimpleConstants.END_IF.trim() + "_" + id)) {
					nestedStack.pop();
				}
				break;
			}
		}		
	}
	
	public static void MoveToFunction(String label) {
		for (int i = 0; i < listofCode.size(); i++) {
			String code = listofCode.get(i);
			if (code.contains(label.trim())) {
				indexForIteration = i;
				break;
			} 
		}
	}
	
	public static void MoveBackward(String label) {
		for (int i = indexForIteration; i >= 0; i--) {
			String code = listofCode.get(i);
			if (code.equals(label.trim())) {
				indexForIteration = i-1;
				break;
			} 
		}
	}
	
	static public void execute(){
		
		
//		System.out.println("In Execute File");
//		
		String codeList = listofCode.get(indexForIteration);
		String[] split = codeList.split(" ");
		
		int tempNest = 0;
		if (codeList.contains(SimpleConstants.IF.trim()) || codeList.contains(SimpleConstants.ELSE.trim())
				|| codeList.contains(SimpleConstants.END_IF.trim()) || codeList.contains(SimpleConstants.FORLOOP.trim())
				|| codeList.contains(SimpleConstants.END_FORLOOP.trim()) || codeList.contains(SimpleConstants.WHILELOOP.trim())
				|| codeList.contains(SimpleConstants.END_WHILELOOP.trim())) {
			split = codeList.split("_");
			tempNest = Integer.parseInt(split[1]);
			if (codeList.contains(SimpleConstants.IF.trim()) ||codeList.contains(SimpleConstants.FORLOOP.trim())
					||codeList.contains(SimpleConstants.WHILELOOP.trim())) {
				nestedStack.push(tempNest);
			}
		} else if (codeList.contains(SimpleConstants.FUNCTION_CALL.trim())
				|| codeList.contains(SimpleConstants.FUNCTION_DECLARE.trim()) || codeList.contains(SimpleConstants.FUNCTION_END.trim())) {
			split = codeList.split("_");
		}
		int accumulator = 0;
		
		
		switch(split[0] + " ") {
		
		case SimpleConstants.DECLAREINT:
			if (scope.isEmpty()) {
				if (!variables.containsKey(split[1])) {
					variables.put(split[1], 0);
				} else {
					throwException("Exception variable " + split[1] + " already declared");
				}
				
			} else {
				if (!variables.containsKey(getScope() + split[1])) {
					variables.put(getScope() + split[1], 0);
				} else {
					throwException("Exception variable " + split[1] + " already declared in this scope");
				}					
			}
			break;
		case SimpleConstants.DECLAREBOOL:
			if (scope.isEmpty()) {
				if (!boolVariables.containsKey(split[1])) {
					boolVariables.put(split[1], false);
				} else {
					throwException("Exception variable " + split[1] + " already declared");
				}
				
			} else {
				if (!boolVariables.containsKey(getScope() + split[1])) {
					boolVariables.put(getScope() + split[1], false);
				} else {
					throwException("Exception variable " + split[1] + " already declared");
				}				
			}
			break;
		case SimpleConstants.ASSIGN :
			if (scope.isEmpty()) {
				if (variables.containsKey(split[1])) {
					//System.out.println("1.E");
					variables.put(split[1], stackForIntegers.pop());
				}
				else if (boolVariables.containsKey(split[1])) {
					//System.out.println("2.E");
					boolVariables.put(split[1], stackForBooleans.pop());
				} else{
					variables.put(split[1], stackForIntegers.pop());
				}
			} else {
				if (variables.containsKey(getScope() + split[1])) {
					//System.out.println("3.NE");
					variables.put(getScope() + split[1], stackForIntegers.pop());
				}
				else if (boolVariables.containsKey(getScope() + split[1])) {
					//System.out.println("4.NE");
					boolVariables.put(getScope() + split[1], stackForBooleans.pop());
				} else{
					variables.put(getScope() + split[1], stackForIntegers.pop());
				}
			}
			break;

		

		case SimpleConstants.LOAD:
			//System.out.println(scope.peek());
			if (scope.isEmpty()) {
				if (boolVariables.containsKey(split[1])) {
					if (Boolean.toString(boolVariables.get(split[1])).equals("true")) {
						stackForBooleans.push(true);
						//System.out.println("1");
					}
					if (Boolean.toString(boolVariables.get(split[1])).equals("false")) {
						stackForBooleans.push(false);
						//System.out.println("2");
					}
				} else if (variables.containsKey(split[1])) {
					//System.out.println("3");
					stackForIntegers.push(variables.get(split[1]));
					//System.out.println(variables.get(split[1]));
						
				}
				else {
					throwException("Undeclared variable " + split[1] + " is used.");
				}
			} else {
				if (boolVariables.containsKey(getScope() +split[1])) {
					if (Boolean.toString(boolVariables.get(getScope() + split[1])).equals("true")) {
						stackForBooleans.push(true);
						//System.out.println("4");
					}
					if (Boolean.toString(boolVariables.get(getScope() + split[1])).equals("false")) {
						stackForBooleans.push(false);
						//System.out.println("5");
					}
				}else if (variables.containsKey(getScope() + split[1])) {
					//System.out.println("6");
					
					stackForIntegers.push(variables.get(getScope() + split[1]));
				} else {
					throwException("Undeclared variable" + getScope() + split[1] + " is used.");
				}
			}
			break;

		case SimpleConstants.PUSH:
			if  (split[1].equals("true") || split[1].equals("false")) {
				//System.out.println(split[1]);
				stackForBooleans.push(Boolean.parseBoolean(split[1]));
				//System.out.println(Boolean.parseBoolean(split[1]));
			} else
				stackForIntegers.push(Integer.parseInt(split[1]));
			
			break;

		case SimpleConstants.PRINT:
			System.out.println(stackForIntegers.pop());
			break;
			
		case SimpleConstants.ADDITION :
			accumulator = stackForIntegers.pop() + stackForIntegers.pop();
			stackForIntegers.push(accumulator);
			//System.out.println(accumulator);
			break;
		case SimpleConstants.SUBTRACTION:
			accumulator = stackForIntegers.pop();
			accumulator = stackForIntegers.pop() - accumulator;
			stackForIntegers.push(accumulator);
			break;
		case SimpleConstants.MULTIPLY:
			stackForIntegers.push((stackForIntegers.pop() * stackForIntegers.pop()));
			break;
		case SimpleConstants.DIVISION:
			accumulator = stackForIntegers.pop();
			if (accumulator != 0) {
				accumulator = stackForIntegers.pop()/accumulator;
				stackForIntegers.push(accumulator);
			} else {
				throwException("Exception can't divide number by 0");
			}				
			break;
		case SimpleConstants.REMINDER:
			accumulator = stackForIntegers.pop();
			accumulator = stackForIntegers.pop() % accumulator;
			stackForIntegers.push(accumulator);
			break;
		case SimpleConstants.EQUAL:
			if ((stackForIntegers.pop() == stackForIntegers.pop())) {
				stackForBooleans.push(true);
			} else {
				stackForBooleans.push(false);
			}
			break;
		case SimpleConstants.GREAT_EQUAL:
			accumulator = stackForIntegers.pop();
			if (stackForIntegers.pop() >= accumulator) {
				stackForBooleans.push(true);
			} else {
				stackForBooleans.push(false);
			}
			break;
		case SimpleConstants.GREATER_THAN:
			accumulator = stackForIntegers.pop();
			if (stackForIntegers.pop() > accumulator) {
				stackForBooleans.push(true);
			} else {
				stackForBooleans.push(false);
			}
			break;
		case SimpleConstants.LESS_EQUAL:
			accumulator = stackForIntegers.pop();
			if (stackForIntegers.pop() <= accumulator) {
				stackForBooleans.push(true);
			} else {
				stackForBooleans.push(false);
			}
			break;
		case SimpleConstants.LESS_THAN:
			accumulator = stackForIntegers.pop();
			if (stackForIntegers.pop() < accumulator) {
				stackForBooleans.push(true);
			} else {
				stackForBooleans.push(false);
			}
			break;
		case SimpleConstants.NOT_EQUAL:
			if (stackForIntegers.pop() != stackForIntegers.pop()) {
				stackForBooleans.push(true);
			} else {
				stackForBooleans.push(false);
			}
			break;
			
		case SimpleConstants.CONDITION_END:
			if (LoopStatusStack.pop()) {
				if (!stackForBooleans.pop()) {
					if(isForLoop)
					{
						MoveForward(SimpleConstants.END_FORLOOP.trim() + "_" + nestedStack.pop());
					}
					else if (isWhileLoop)
					{
						
						MoveForward(SimpleConstants.END_WHILELOOP.trim() + "_" + nestedStack.pop());
						
					}
				}
			} else {
				if (!stackForBooleans.pop()) {
					accumulator = nestedStack.pop();
					nestedStack.push(accumulator);
					MoveForward(SimpleConstants.ELSE.trim() + "_" + accumulator);
				}	
			}
			break;
			
		case SimpleConstants.IF:
			LoopStatusStack.push(false);
			break;
		case "true ":
			stackForBooleans.push(true);
			break;
		case "false ":
			stackForBooleans.push(false);
			break;
		
		case SimpleConstants.END_IF:
			nestedStack.pop();
			break;
			
		case SimpleConstants.ELSE:
			MoveForward(SimpleConstants.END_IF.trim() + "_" + tempNest); 
			break;
		
			
		case SimpleConstants.FORLOOP:
			isForLoop = true;
			LoopStatusStack.push(true);
			break;
		case SimpleConstants.END_FORLOOP:
			MoveBackward(SimpleConstants.FORLOOP.trim() + "_" + nestedStack.pop());
			break;
			
		case SimpleConstants.WHILELOOP:
			isWhileLoop = true;
			LoopStatusStack.push(true);
			break;
			
		
		case SimpleConstants.END_WHILELOOP:
			MoveBackward(SimpleConstants.WHILELOOP.trim() + "_" + nestedStack.pop());
			break;
		
		case SimpleConstants.FUNCTION_CALL :
			stackTrace.push(indexForIteration);
			MoveToFunction(SimpleConstants.FUNCTION_DECLARE.trim() + "_" + split[1]);
			break;
		case SimpleConstants.FUNCTION_END :
			scope.pop();
			indexForIteration = stackTrace.pop();
			break;
		case SimpleConstants.FUNCTION_DECLARE :
			MoveForward(SimpleConstants.FUNCTION_END.trim() + "_" + split[1]);
			break;
		case SimpleConstants.FUNCTION_PARAM :
			//System.out.println("Inside function param...");
			scope.push(countForScope);
			//System.out.println(scope.peek());
			/*if (scope.isEmpty())
				System.out.println("Empty");
			else 
				System.out.println("Not Empty: " + getScope());*/
			countForScope++;
			for (int i = split.length-1; i > 0; i--) {
				//System.out.println(getScope() + split[i] + "--" + stackForIntegers.peek());
				variables.put(getScope() + split[i], stackForIntegers.pop());	
			}
			break;
		case SimpleConstants.FUNCTION_RETURN:
			scope.pop();
			indexForIteration = stackTrace.pop();
			break;

		}
		
	}
	
	
	
	public static int getScope() {
		int temp = scope.peek();
		return temp;
	}
	
	static public void throwException(String ex) {
		System.out.println("\n" + ex);
		indexForIteration = listofCode.size();
	}
	
	
}
