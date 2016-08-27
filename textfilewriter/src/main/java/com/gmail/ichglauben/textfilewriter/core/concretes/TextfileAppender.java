package com.gmail.ichglauben.textfilewriter.core.concretes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gmail.ichglauben.textfilewriter.core.utils.concretes.GlobalConstants;

public class TextfileAppender {
	ClassLoader loader = getClass().getClassLoader();
	File textFile = new File(loader.getResource("text_file.txt").getFile());

	private TextfileAppender() {
		super();
	}

	/**
	 * /** Writes a new or appends to an existing text file.
	 * 
	 * @param newFile
	 *            String file name with or without extension
	 * @param data
	 *            String List the data to be written to the file
	 */
	public static void append(String newFile, List<String> data) throws IOException {
		if (null != newFile && newFile.length() > 0) {
			if (!newFile.endsWith(".txt"))
				newFile += ".txt";
			File file = new File(newFile);
			FileWriter writer = new FileWriter(file, true);
			BufferedWriter buffer = new BufferedWriter(writer);
			for (String str : data) {
				buffer.write(str + GlobalConstants.LINESEPARATOR);
			}
			buffer.close();
		}
	}

	/**
	 * /** Writes a new or appends to an existing text file.
	 * 
	 * @param newFile
	 *            String file name with or without extension
	 * @param data
	 *            String List the data to be written to the file
	 * @param extension
	 *            String specify the new file's extension
	 */
	public static void append(String newFile, List<String> data, String extension) throws IOException {
		if (null != newFile && newFile.length() > 0) {
			if (newFile.lastIndexOf(".") != -1)
				newFile = newFile.substring(0, newFile.lastIndexOf("."));

			Pattern pattern = Pattern.compile("(\\.\\w+)");
			Matcher matcher = pattern.matcher(extension);

			if (matcher.find())
				newFile += matcher.group(0);

			File file = new File(newFile);
			FileWriter writer = new FileWriter(file, true);
			BufferedWriter buffer = new BufferedWriter(writer);
			for (String str : data) {
				buffer.write(str + GlobalConstants.LINESEPARATOR);
			}
			buffer.close();
		}
	}

	public String toString() {
		return "Text File Appender";
	}

}
