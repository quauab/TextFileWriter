package com.gmail.ichglauben.textfilewriter;

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
import com.gmail.ichglauben.textfilewriter.core.concretes.TextfileAppender;
import com.gmail.ichglauben.textfilewriter.core.utils.concretes.GlobalConstants;

public class TextfileAppenderTests {
	ClassLoader loader = getClass().getClassLoader();
	String ud = GlobalConstants.USRDIR;
	String uh = GlobalConstants.USRHOME;
	File file = new File(loader.getResource("text_file.txt").getFile());

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
		
		printFile(ud + "appended.txt");
		println("");
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
		
		printFile(ud + "log1.log");
		println("");
	}

	@Test
	public void testAppendToExistingFile() throws IOException {
		List<String> data = new ArrayList<String>();
		data.add("I've been in labor for the last 10 minutes");
		data.add("I'm carla's sister, Annette Rosaponi");
		data.add("Hi Annette, I'm Sam. I see you had met coach");
		
		TextfileAppender.append(file.getAbsolutePath(), data);
		printFile(file.getAbsolutePath());
		println("");
	}
	
	@Test
	public void testAppendSpecifyExtension() throws IOException {
		List<String> data = new ArrayList<String>();
		data.add("The Alphabet");
		data.add("Quality over Quantity");
		data.add("Don't wait up for us");
		
		TextfileAppender.append(ud + "appended_file",data,".jam");
		printFile(ud + "appended_file.jam");
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
