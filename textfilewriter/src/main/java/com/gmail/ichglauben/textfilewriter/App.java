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
		String[] txt = { "Green eggs and ham? Oh-kay, I'll bite ... what about green eggs and ham?",
				"One two three four-five six seven eight nine-ten eleven twelve",
				"Briefly describe the process(es) taking place in running the application." }, txt2 = {
						"Brigga-Bragga Fire cracker siss boom bomb - Bugs Bunny, Bugs Bunny - rah-rah-rah!",
						"Heterosexual people are also known as breeders, because we choose to have children or not",
						"... And can I ask you a thing or two?"
		};
		String dir = "D:\\_\\Dropbox\\Private\\reference\\", f1 = dir + "test_file_1", f2 = dir + "_local_places";
		
//		testFileOverwriter(txt, f1);
		
		testFileAppender(txt2, f1);
	}

	private static void testFileAppender(String[] txt2, String f1) throws IOException {
		start();
		print("\t\tAppending to the newly created text file: " + f1);
		TextfileAppender.append(new File(f1), txt2);
		end();
	}

	private static void testFileOverwriter(String[] txt, String f1) throws IOException {
		Path path = Paths.get(f1);
		start();
		print("\t\tNon-existing file: " + f1);
		print("\tNow I will create the non-existing file and add content." + f1);
		TextfileOverwriter.overwrite(new File(f1), txt);
		end();
	}
	
	static void start() {
		print("\t\t\t\tProgram Started");
	}
	
	static void end() {
		print("\t\t\t\tProgram Stopped");
	}
}
