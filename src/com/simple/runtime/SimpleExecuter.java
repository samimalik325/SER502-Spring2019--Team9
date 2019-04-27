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
	

	static ArrayList<String> listofCode = new ArrayList<String>();
	
	static int indexForIteration = 0;

	static Stack<Boolean> stackForBooleans = new Stack<Boolean>();
	
	static HashMap<String,Integer> variables = new HashMap<String,Integer>();
	
	static Stack<Integer> nestedStack = new Stack<Integer>();
	
	static HashMap<String,Boolean> boolVariables = new HashMap<String,Boolean>();
	
	static Stack<Integer> scope = new Stack<Integer>();
	
	static Stack<Integer> stackForIntegers = new Stack<Integer>();
	
	
	
	public static void main(String[] args) {
		String filename = "resources/SamplePrograms/test.simpleint";
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
	
	static public void execute(){
		
		
//		System.out.println("In Execute File");
//		
		String codeList = listofCode.get(indexForIteration);
		String[] split = codeList.split(" ");
		
		
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
