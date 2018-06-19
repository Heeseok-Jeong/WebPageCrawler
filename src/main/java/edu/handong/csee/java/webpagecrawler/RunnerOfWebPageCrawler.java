package edu.handong.csee.java.webpagecrawler;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;


public class RunnerOfWebPageCrawler {
	String url;
	String savePath;
	String html;
	boolean help;
	
	public static void main(String[] args) {
		RunnerOfWebPageCrawler runner = new RunnerOfWebPageCrawler();
		runner.doJob(args);
	}
	
	private void doJob(String[] args) {
		//APACHE COMMONS CLI
		Options options = createOptions();
		if(parseOptions(options, args)){
			if (help){
				printHelp(options);
				return;
			}
			// path is required (necessary) data so no need to have a branch.
			System.out.println("You provided \"" + url + "\" as the value of the option u");

			// path is required (necessary) data so no need to have a branch.
			System.out.println("You provided \"" + savePath + "\" as the value of the option d");
		}
		HTMLConverter htmlCvt = new HTMLConverter();
		HTMLFileWriter htmlWrt = new HTMLFileWriter(savePath);
		htmlCvt.setUrl(url);
		htmlCvt.mergeReadLine();
		htmlWrt.setHtml(htmlCvt.getContentsOfFile());
		htmlWrt.writeHtml();
		System.out.println(htmlCvt.getContentsOfFile());
//		ArrayList<String> contentsOfFile = new ArrayList<String>();	
	}
	
	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();

		try {

			CommandLine cmd = parser.parse(options, args);

			url = cmd.getOptionValue("u");
			savePath = cmd.getOptionValue("d");
			help = cmd.hasOption("h");

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}
	
	// Definition Stage
		private Options createOptions() {
			Options options = new Options();

			// add options by using OptionBuilder
			options.addOption(Option.builder("u").longOpt("url")
					.desc("Set a url to read")
					.hasArg()
					.argName("URL")
					.required()
					.build());

			// add options by using OptionBuilder
			options.addOption(Option.builder("d").longOpt("directory")
					.desc("Set a directory path that output file are saved")
					.hasArg()
					.argName("Directory Path")
					.required()
					.build());

			// add options by using OptionBuilder
			options.addOption(Option.builder("h").longOpt("help")
					.desc("Help")
					.build());

			return options;
		}

		private void printHelp(Options options) {
			// automatically generate the help statement
			HelpFormatter formatter = new HelpFormatter();
			String header = "Saving html file program";
			String footer ="\nPlease report issues at dldydldy@naver.com";
			formatter.printHelp("WebPageCrawler", header, options, footer, true);
		}

}
