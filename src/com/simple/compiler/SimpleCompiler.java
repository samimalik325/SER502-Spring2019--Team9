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
		
//		String filename = "";
//		System.out.print(args.length );
//		if (args.length > 0){
//		
//    			filename = args[0];
//		} else {
//			System.out.println("input filename can't be empty");
//			return;
//		}
//		
//		if (!filename.contains(".simple")) {
//			System.out.println("Enter a valid .simple file");
//			return;
//		}
		
		CharStream charStream = null;
		try {
			charStream = CharStreams.fromFileName("./resources/SamplePrograms/test.simple");
		} catch (IOException e) {
			System.out.println("ex");
			e.printStackTrace();
		}
		
		
		simpleLexer lexer = new simpleLexer(charStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		parser = new simpleParser(tokenStream);
		ParseTreeWalker.DEFAULT.walk(SimpleIntermediateCodeGenarator.getInstance(), parser.program());

	}
	
	public static simpleParser getParserInstance() {
		return parser;
	}
	

}
