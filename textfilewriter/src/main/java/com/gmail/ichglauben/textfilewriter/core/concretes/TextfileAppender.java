package com.gmail.ichglauben.textfilewriter.core.concretes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.gmail.ichglauben.pathvalidator.core.concretes.PathValidator;
import com.gmail.ichglauben.textfilewriter.core.utils.concretes.GlobalConstants;

public class TextfileAppender {

	public TextfileAppender() {
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
	public static void appendWriteText(String newFile, List<String> data) throws IOException {
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

	public String toString() {
		return "Text File Appender";
	}

}
