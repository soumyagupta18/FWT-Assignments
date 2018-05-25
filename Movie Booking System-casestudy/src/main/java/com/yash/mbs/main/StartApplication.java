package com.yash.mbs.main;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.yash.mbs.util.FileUtil;

/**
 * This class is the Application Startup class.
 * 
 * @author soumya.gupta
 *
 */
public class StartApplication {
	private static final Logger logger = Logger.getLogger(StartApplication.class);

	public static void main(String[] args) throws IOException {
		logger.info("main() method started.");
		// MovieBookingSystemMenu menu = new MovieBookingSystemMenu();
		// menu.getMenu();
		FileUtil fileUtil = new FileUtil();
		fileUtil.createFile("ScreenJson.json");
		fileUtil.writeFile("another data", "src/main/resources/ScreenJson.json");

	}
}
