package com.gmail.ichglauben.textfilewriter;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gmail.ichglauben.textfilewriter.core.utils.abstracts.CustomClass;

public class App extends CustomClass {
	public static void main(String[] args) throws IOException {
		String test = "test.txt", test2 = "more-test";
		Pattern patt = Pattern.compile("(\\.\\w+)");
		Matcher matc = patt.matcher(test);
		
		if (matc.find()) {
			print(matc.group(0));
		}
	}

	static void start() {
		print("\t\t\t\tProgram Started");
	}

	static void end() {
		print("\t\t\t\tProgram Stopped");
	}
}
