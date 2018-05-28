package com.yash.mbs.main;

import java.io.IOException;

import org.apache.log4j.Logger;

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
		 MovieBookingSystemMenu menu = new MovieBookingSystemMenu();
		 menu.getMenu();
		

	}
}
