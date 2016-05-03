package com.gmail.ichglauben.textfilewriter.core.utils.concretes;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathValidator {

	public PathValidator() {
		super();
	}

	/**
	 * @param String
	 *            file_path
	 */
	public static boolean pathExists(String file_path) {
		Path path = null;
		if (null != file_path) {
			if (null != (path = Paths.get(file_path))) {
				boolean exists = (path.toFile().exists() && path.toFile().isFile());
				path = null;
				return exists;
			}
		}
		return false;
	}

	/**
	 * @param Path
	 *            file_path
	 */
	public static boolean pathExists(Path file_path) {
		Path path = null;
		if (null != file_path) {
			if (null != (path = Paths.get(file_path.toFile().getAbsolutePath().toString()))) {
				boolean exists = (path.toFile().exists() && path.toFile().isFile());
				path = null;
				return exists;
			}
		}
		return false;
	}

	/**
	 * @param File
	 *            file
	 */
	public static boolean pathExists(File file) {
		if (null != file) {
			return (file.exists() && file.isFile());
		}
		return false;
	}

	public String toString() {
		return "Path/File Existence Validator";
	}

}
