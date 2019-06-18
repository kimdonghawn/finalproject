package edu.handong.analysis;

import java.util.*;
import java.io.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;


public class FinalAnalyzer {
	static String Input;
	static String Output;
	static boolean help;
	
	public void run(String[] args){
		Options option = createOptions();
		if (parseOptions(option, args)) {
			if (help) {
				printHelp(option);
				return;
			}
			
		}
		
		File dir = new File(Input); 

		File[] fileList = dir.listFiles(); 



		
		
		
		
		
		
			}
	public static boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);

			FinalAnalyzer.Input = cmd.getOptionValue("i");
			//print cli input
			FinalAnalyzer.Output = cmd.getOptionValue("o");
			//print cli output
			FinalAnalyzer.help = cmd.hasOption("h");

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}

	private Options createOptions() {
		Options options = new Options();

		options.addOption(Option.builder("i").longOpt("input")
				.desc("Set an input file path. zip file or directory.")
				.hasArg()
				.argName("Input path")
				.required()
				.build());
		
		options.addOption(Option.builder("o").longOpt("output")
				.desc("Set an input file path. csv file.")
				.hasArg()
				.argName("Output path")
				.required()
				.build());

		// using OptionBuilder
		options.addOption(Option.builder("h").longOpt("help")
		        .desc("Help")
		        .build());
		
		return options;
	}
	
	public static void printHelp(Options options) {
		// generate help statement 
		HelpFormatter formatter = new HelpFormatter();
		String header = "ExCli";
		String footer = "";
		formatter.printHelp("CLI", header, options, footer, true);
	
		
	}
}


