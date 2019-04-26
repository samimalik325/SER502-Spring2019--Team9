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
	
	
	public static void main(String[] args) {
		String filename = "resources/SamplePrograms/function.simpleint";
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
		
		
		System.out.println("In Execute File");
		
	}
	
	
	
}
