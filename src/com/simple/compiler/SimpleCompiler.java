package com.simple.compiler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * 
 * @author Team 9
 *
 * This class compiles(Calls lexical analyzer, parser and intermediate code generation) the Simple file
 */
public class SimpleCompiler {
	
	static simpleParser parser = null;
	public static void main(String[] args) {
		
		String filename = "resources/SamplePrograms/while-loop.simple";
		System.out.print(args.length );
		/*if (args.length > 0){
		
    			filename = "ArithmaticOperations.simple";
		} else {
			System.out.println("input filename can't be empty");
			return;
		}*/
		
		if (!filename.contains(".simple")) {
			System.out.println("Enter a valid .simple file");
			return;
		}
		
		CharStream charStream = null;
		try {
			charStream = CharStreams.fromFileName(filename);
		} catch (IOException e) {
			System.out.println("ex");
			e.printStackTrace();
		}
		
		
		simpleLexer lexer = new simpleLexer(charStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		parser = new simpleParser(tokenStream);
		ParseTreeWalker.DEFAULT.walk(SimpleIntermediateCodeGenarator.getInstance(), parser.program());
		ArrayList<String> intermediateCode =  SimpleIntermediateCodeGenarator.getInstance().getiCode();
		writeIntermediateFile(filename, intermediateCode);

	}
	
	public static simpleParser getParserInstance() {
		return parser;
	}
	
	public static void writeIntermediateFile(String fileName, ArrayList<String> intermediateCode) {
		try {
			PrintWriter writer = new PrintWriter(fileName + "int", "UTF-8");
			for (String i:intermediateCode){
				writer.println(i);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	

}
