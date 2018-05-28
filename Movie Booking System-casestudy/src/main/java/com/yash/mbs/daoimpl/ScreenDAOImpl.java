package com.yash.mbs.daoimpl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yash.mbs.dao.ScreenDAO;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.util.JsonUtil;

public class ScreenDAOImpl implements ScreenDAO {
	
	private static final Logger logger = Logger.getLogger(ScreenDAOImpl.class);
	private List<Screen> screens = new ArrayList<Screen>();
	private JsonUtil jsonUtil = new JsonUtil();
	private String filepath = "src/main/resources/ScreenJson.json";

	public ScreenDAOImpl() {
		logger.info("ScreenDAOImpl constructor Initilaizing");
	
	}

	public String getScreenByName(String screenName) {
		logger.info("Entered in getScreenByName Method");
		String contentToDisplay = jsonUtil.readJsonObjectFromFile(filepath);
		List<Screen> screens = convertJsonIntoString(contentToDisplay);
		for (Screen screen : screens) {
			System.out.println(screen.getName());
		}
		logger.info("Exiting in getScreenByName Method");
		return "";
		
	}

	public boolean insert(Screen myScreen) {
		
		String screensJson = convertScreenIntoJson(myScreen);
		jsonUtil.writeJsonObjectToFile(screensJson, filepath);
		return true;
	}

	public List<Screen> getAllScreen() {
		String contentToDisplay = jsonUtil.readJsonObjectFromFile(filepath);
		List<Screen> screens = convertJsonIntoString(contentToDisplay);
		for (Screen screen : screens) {
			System.out.println(screen);
		}
		return screens;
	}
	private String convertScreenIntoJson(Screen myScreen) {
		Gson gSon = new Gson();
		screens.add(myScreen);
		String screensJson = gSon.toJson(screens);
		return screensJson;
	}

	private List<Screen> convertJsonIntoString(String contentToDisplay) {
		Gson gSon = new Gson();
		Type listType = new TypeToken<List<String>>() {
		}.getType();
		List<Screen> screens = gSon.fromJson(contentToDisplay, listType);
		return screens;
	}

}
