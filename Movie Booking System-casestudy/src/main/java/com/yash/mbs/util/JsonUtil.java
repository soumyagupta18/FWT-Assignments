package com.yash.mbs.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yash.mbs.domain.Screen;

public class JsonUtil {
	
	private static String json;


	public void writeJsonObjectToFile(String screensJson, String filepath) {
		File file = new File(filepath);
		System.out.println(file+"file in writeObjectToFile");
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
	public static List<Screen> ConvertjsonToObject(String data) {
		Gson gson = new Gson();
		Type type = new TypeToken<List<Screen>>() {
		}.getType();
		json = gson.toJson(data, type);
		List<Screen> fromJson = gson.fromJson(json, type);
		for (Screen screen : fromJson) {
			System.out.println(screen);
		}
		return fromJson;
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
