package com.yash.mbs.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonUtil {

	public void writeJsonObjectToFile(String screensJson, String filepath) {
		File file = new File(filepath);
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			fw.write(screensJson);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public String readJsonObjectFromFile(String filepath) {
		File file = new File(filepath);
		String content = null;
		String contentToDisplay = null;
		BufferedReader bufferreader = null;

		try {
			bufferreader = new BufferedReader(new FileReader(file));
			while ((content = bufferreader.readLine()) != null) {
				contentToDisplay = content;
				content = bufferreader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferreader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return contentToDisplay;
	}
}
