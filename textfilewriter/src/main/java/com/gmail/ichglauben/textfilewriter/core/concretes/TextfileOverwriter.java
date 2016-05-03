package com.gmail.ichglauben.textfilewriter.core.concretes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.gmail.ichglauben.textfilewriter.core.utils.concretes.GlobalConstants;
import com.gmail.ichglauben.textfilewriter.core.utils.concretes.PathValidator;

public class TextfileOverwriter {

	public TextfileOverwriter() {
		super();
	}

	/**
	 * Static method that will over-write the contents of the file. If the file
	 * does not exist, this method will create it in the program's directory.
	 * 
	 * @param file
	 *            - the file onto which the data will be written
	 * @param data
	 *            - the data to write
	 * @throws java.io.IOException
	 *             - Throws IOException
	 */
	public static void overwrite(File file, List<String> data) throws IOException {
		if (null != file) {
			if (!PathValidator.pathExists(file))
				file = new File(GlobalConstants.USRDIR + file.toPath().getFileName() + ".txt");

			FileWriter writer = new FileWriter(file);
			BufferedWriter buffer = new BufferedWriter(writer);

			// for (String str : data) {
			// buffer.write(str + GlobalConstants.LINESEPARATOR);
			// }

			int i = 0;
			for (String str : data) {
				i++;
				if (i < data.size()) {
					buffer.write(str + GlobalConstants.LINESEPARATOR);
				} else {
					buffer.write(str);
				}
			}

			// String results;
			// switch (data.size()) {
			// case 1:
			// results = " line";
			// break;
			//
			// default:
			// results = " total lines";
			// break;
			// }
			// buffer.append(data.size() + results);

			buffer.close();
		}
	}

	public static void overwrite(File file, String[] data) throws IOException {
		if (null != file) {
			if (!PathValidator.pathExists(file))
				file = new File(GlobalConstants.USRDIR + file.toPath().getFileName() + ".txt");

			FileWriter writer = new FileWriter(file);
			BufferedWriter buffer = new BufferedWriter(writer);
			int i = 0;
			for (String str : data) {
				i++;
				if (i < data.length) {
					buffer.write(str + GlobalConstants.LINESEPARATOR);
				} else {
					buffer.write(str);
				}
			}

			// String results;
			// switch (data.length) {
			// case 1:
			// results = " line";
			// break;
			//
			// default:
			// results = " total lines";
			// break;
			// }
			// buffer.append(data.length + results);

			buffer.close();
		}
	}

	public String toString() {
		return "Text File Over-writer";
	}

}
