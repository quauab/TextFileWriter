package com.gmail.ichglauben.textfilewriter.core.utils.concretes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextFileValidator {

	public TextFileValidator() {
		super();
	}

	public static boolean valid(File file) {
		if (null != file && file.exists() && file.isFile()) {
			try {
				String type = Files.probeContentType(file.toPath());
				if (null != type) {
					if (type.equals("text/plain") && validTextFileExtension(file)) {
						return true;
					}
				}
			} catch (IOException x) {
				return false;
			}
		}
		return false;
	}

	public static boolean valid(Path file) {
		if (null != file && file.toFile().exists() && file.toFile().isFile()) {
			try {
				String type = Files.probeContentType(file);
				if (null != type) {
					if (type.equals("text/plain") && validTextFileExtension(file)) {
						return true;
					}
				}
			} catch (IOException x) {
				return false;
			}
		}
		return false;
	}

	public static boolean valid(String file) {
		if (null != file) {
			if (Paths.get(file).toFile().exists() && Paths.get(file).toFile().isFile()) {
				try {
					String type = Files.probeContentType(Paths.get(file));
					if (null != type) {
						if (type.equals("text/plain") && validTextFileExtension(file)) {
							return true;
						}
					}
				} catch (IOException x) {
					return false;
				}
			}
		}
		return false;
	}

	private static boolean validTextFileExtension(Path file) {
		return file.getFileName().toString().endsWith(".txt");
	}

	private static boolean validTextFileExtension(File file) {
		return file.toPath().getFileName().toString().endsWith(".txt");
	}

	private static boolean validTextFileExtension(String file) {
		return Paths.get(file).getFileName().toString().endsWith(".txt");
	}

	public String toString() {
		return "Text File Reader";
	}

}
