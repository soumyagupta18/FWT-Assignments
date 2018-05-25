package com.yash.mbs.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.yash.mbs.exception.FileContentEmptyException;
import com.yash.mbs.exception.FileNameEmptyException;
import com.yash.mbs.exception.FileNotPresentException;

public class FileUtil {

	public void displayOperatorMenu(String filePath) {
		filePathIsNull(filePath);
		filePathIsEmpty(filePath);
		readFile(filePath);

	}

	public File createFile(String fileName) {
		File file = new File("src/main/resources/" + fileName);
		try {

			if (!file.exists())
				file.createNewFile();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		return file;

	}

	public void writeFile(String JsonString, String filepath) throws IOException {
		File file = new File(filepath);
		if (file.exists()) {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsolutePath(), true));
			bufferedWriter.write(JsonString);
			bufferedWriter.newLine();
			bufferedWriter.close();
			System.out.println("wrote in file");
		}

	}

	public void readFile(String filePath) {
		try {

			FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer contents = new StringBuffer();
			String text = null;
			fileContentIsEmpty(bufferedReader);

			while ((text = bufferedReader.readLine()) != null) {
				contents.append(text).append(System.getProperty("line.separator"));

			}
			bufferedReader.close();

		} catch (FileNotFoundException fileNotFoundException) {
			throw new FileNotPresentException("File not found !");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	public void fileContentIsEmpty(BufferedReader bufferedReader) throws IOException {
		String text = null;
		if ((text = bufferedReader.readLine()) == null) {
			throw new FileContentEmptyException("File Contents Are Empty");

		}
	}

	public void filePathIsEmpty(String filePath) {
		if (filePath == "") {
			throw new FileNameEmptyException("File Name can't be empty.");
		}
	}

	public void filePathIsNull(String filePath) {
		if (filePath == null) {
			throw new FileNotPresentException("File cannot be null");
		}
	}

}
