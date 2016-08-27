package com.gmail.ichglauben.textfilewriter;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.gmail.ichglauben.pathvalidator.core.concretes.PathValidator;
import com.gmail.ichglauben.textfilewriter.core.concretes.TextfileAppender;
import com.gmail.ichglauben.textfilewriter.core.concretes.TextfileOverwriter;
import com.gmail.ichglauben.textfilewriter.core.utils.concretes.GlobalConstants;

public class TextfileAppenderTests {
	String ud = GlobalConstants.USRDIR;
	String uh = GlobalConstants.USRHOME;

	@Test
	public void testAppendTextFile() throws IOException {
		List<String> list = new ArrayList<String>();
		list.add("new data");
		list.add("being written");

		TextfileAppender.append(ud + "appended", list);
	
		list.clear();
		list.add("adding even more data");
		list.add("to the text file");
		
		TextfileAppender.append(ud + "appended.txt", list);

		list.clear();
		list.add("....and even more nonsensical data");
		
		TextfileAppender.append(ud + "appended.txt", list);
		
		for (String s:readFile(ud + "appended.txt")) {
			println(s);
		}
	}
	
	@Test
	public void testAppendWithExtension() throws IOException {
		String ext = ".log";
		String file = ud + "log1.jam";
		List<String> data = new ArrayList<String>();
		data.add("Log File 1");
		data.add("Added test text");
		data.add("So the text may not make sends");
		data.add("As its only test data, remember?");
		
		TextfileAppender.append(file,data,ext);
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
