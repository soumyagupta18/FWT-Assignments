package com.yash.mbs.util;

import org.junit.Test;

import com.yash.mbs.exception.FileContentEmptyException;
import com.yash.mbs.exception.FileNameEmptyException;
import com.yash.mbs.exception.FileNotPresentException;

public class FileUtilTest {

	FileUtil operatorMenu = new FileUtil();

	@Test(expected = FileNotPresentException.class)
	public void should_ThrowFileNotPresentException_when_ExpectedFileNotFound() {
		String filePath = null;
		operatorMenu.displayOperatorMenu(filePath);
	}

	@Test(expected = FileNameEmptyException.class)
	public void should_ReturnFileIsEmptyException_when_GivenFileIsEmpty() throws Exception {
		String file = "";
		operatorMenu.displayOperatorMenu(file);
	}

	@Test
	public void should_ReturnExpectedFile_when_ExpectedFilePathGiven() {
		String filePath = "src/main/resources/operatorMenu.txt";
		operatorMenu.displayOperatorMenu(filePath);
	}

	@Test(expected = FileContentEmptyException.class)
	public void should_ReturnFileContentEmptyException_when_ExpectedFileContentIsEmpty() {
		String filePath = "src/test/resources/TestFile.txt";
		operatorMenu.displayOperatorMenu(filePath);

	}

}
