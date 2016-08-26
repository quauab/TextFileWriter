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

		TextfileOverwriter.overWriteText("overwritten.txt", list);
		TextfileOverwriter.overWriteText("overwritten", list);

		List<String> read = readFile(ud + "warning.txt");

		for (int i = 0; i < list.size(); i++) {
			assertTrue("Lists don't match", list.get(i).equals(read.get(i)));
		}
	}
	
	@Test
	public void testOverwriteWithoutExtension() throws IOException {
		List<String> list = new ArrayList<String>();
		list.add("more new data");
		list.add("being written");
		TextfileOverwriter.overWriteText("overwritten", list);		
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
