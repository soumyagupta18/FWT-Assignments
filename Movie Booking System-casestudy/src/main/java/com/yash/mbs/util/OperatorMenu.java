package com.yash.mbs.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.yash.mbs.exception.FileContentEmptyException;
import com.yash.mbs.exception.FileNameEmptyException;
import com.yash.mbs.exception.FileNotPresentException;

public class OperatorMenu {

	public void displayOperatorMenu(String filePath) {
		filePathIsNull(filePath);
		filePathIsEmpty(filePath);
		readFile(filePath);

	}

	private void readFile(String filePath) {
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
			System.out.println(contents.toString());

		} catch (FileNotFoundException fileNotFoundException) {
			throw new FileNotPresentException("File not found !");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	private void fileContentIsEmpty(BufferedReader bufferedReader) throws IOException {
		String text = null;
		if ((text = bufferedReader.readLine()) == null) {
			throw new FileContentEmptyException("File Contents Are Empty");

		}
	}

	private void filePathIsEmpty(String filePath) {
		if (filePath == "") {
			throw new FileNameEmptyException("File Name can't be empty.");
		}
	}

	private void filePathIsNull(String filePath) {
		if (filePath == null) {
			throw new FileNotPresentException("File cannot be null");
		}
	}

}
