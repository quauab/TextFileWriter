package com.gmail.ichglauben.textfilewriter;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.gmail.ichglauben.pathvalidator.core.concretes.PathValidator;
import com.gmail.ichglauben.textfilewriter.core.concretes.TextfileOverwriter;
import com.gmail.ichglauben.textfilewriter.core.utils.concretes.GlobalConstants;
import com.gmail.ichglauben.textfilewriter.core.utils.concretes.TextFileValidator;

public class TextfileOverwriterTests {
	String ud = GlobalConstants.USRDIR;
	String uh = GlobalConstants.USRHOME;

	@Test
	public void testOverwriteTextFile() throws IOException {
		List<String> list = new ArrayList<String>();
		list.add("new data");
		list.add("being written");

		TextfileOverwriter.overwrite("overwritten1.txt", list);
		TextfileOverwriter.overwrite("overwritten1", list);

		List<String> read = readFile(ud + "overwritten1.txt");

		for (int i = 0; i < list.size(); i++) {
			assertTrue("Lists don't match", list.get(i).equals(read.get(i)));
		}
		
		printFile(ud + "overwritten1.txt");
		println("");
	}
	
	@Test
	public void testOverwriteWithoutExtension() throws IOException {
		List<String> list = new ArrayList<String>();
		list.add("Adding nonsensical text");
		list.add("here is more text on a new line");
		TextfileOverwriter.overwrite("overwritten2", list);		
		printFile(ud + "overwritten2.txt");
		println("");
	}

	@Test
	public void testOverwriteSpecifyExtension() throws IOException {
		List<String> list = new ArrayList<String>();
		list.add("Writing text to a file");
		list.add("who's extension is \".dot\"");
		TextfileOverwriter.overwrite("overwritten", list, ".dot");	
		printFile(ud + "overwritten.dot");
		println("");
	}
	
	List<String> readFile(String file_path) {
		List<String> list = null;
		FileInputStream fis = null;
		DataInputStream dis = null;
		BufferedReader br = null;

		if (null != file_path) {
			if (PathValidator.pathExists(file_path)) {
				list = new ArrayList<String>();
				try {
					fis = new FileInputStream(Paths.get(file_path).toAbsolutePath().toString());
					dis = new DataInputStream(fis);
					br = new BufferedReader(new InputStreamReader(dis));
					String strLine;

					while ((strLine = br.readLine()) != null) {
						list.add(strLine);
					}

					return list;
				} catch (IOException ioe) {
					System.err.println("Error reading file");
				} finally {
					try {
						dis.close();
						dis = null;
						fis.close();
						fis = null;
						br.close();
						br = null;
					} catch (IOException ioe) {
					}
				}
			}
		}
		return null;
	}

	void printFile(String file_path) {
		if (null != file_path) {
			if (PathValidator.pathExists(file_path)) {
				try {
					FileInputStream fstream = new FileInputStream(Paths.get(file_path).toAbsolutePath().toString());
					DataInputStream in = new DataInputStream(fstream);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					String strLine;

					while ((strLine = br.readLine()) != null) {
						println(strLine);
					}
					in.close();
				} catch (IOException ioe) {
					System.err.println("Error reading file");
				}
			}
		}
	}

	void print(Object o) {
		System.out.print(String.valueOf(o));
	}

	void println(Object o) {
		System.out.println(String.valueOf(o));
	}
}
