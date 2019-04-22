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
	
	public static void main(String[] args) {
//		String filename = "";
//		if (args.length > 0){
//	    		filename = args[0];
//	    	} else {
//			System.out.println("input filename can't be empty");
//			return;
//		}
//			
//		if (!filename.contains(".simple")) {
//			System.out.println("Enter a valid .simple file");
//			return;
//		}
		
		try {
			for (String line : Files.readAllLines(Paths.get("./resources/SamplePrograms/test.simpleint")) {
				listofCode.add(line);
			}
		} catch (IOException e) {
			System.out.println("File not found...Please specify valid input file");
			e.printStackTrace();
		}
		

	}
	
	
	
}
