package com.gmail.ichglauben.textfilewriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.gmail.ichglauben.textfilewriter.core.concretes.TextfileAppender;
import com.gmail.ichglauben.textfilewriter.core.concretes.TextfileOverwriter;
import com.gmail.ichglauben.textfilewriter.core.utils.abstracts.CustomClass;

public class App extends CustomClass {
	public static void main(String[] args) throws IOException {
		String test = "test.txt";
		if (test.endsWith("txt")) {
			print("yup");
		} else {
			print("nope");
		}
	}

	static void start() {
		print("\t\t\t\tProgram Started");
	}

	static void end() {
		print("\t\t\t\tProgram Stopped");
	}
}
