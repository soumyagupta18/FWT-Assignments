package com.yash.mbs.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.yash.mbs.util.FileUtil;

/**
 * This class will be the user interactive class that will perform the
 * operations case wise according to user's selection.
 * 
 * @author soumya.gupta
 *
 */
public class MovieBookingSystemMenu {
	private static final Logger logger = Logger.getLogger(MovieBookingSystemMenu.class);
	Scanner scanner;
	FileUtil fileUtil = new FileUtil();

	// public void getMenu() {
	//logger.info("Entered in MovieBookingSystemMenu");
	// int option;
	//
	// do {
	//
	// fileUtil.displayOperatorMenu("src/main/resources/operatorMenu.txt");
	// option = scanner.nextInt();
	// switch (option) {
	// case 1:
	// System.out.println("Case 1");
	// break;
	// case 2:
	// System.out.println("Case 2");
	// break;
	// case 3:
	// System.out.println("Case 3");
	// break;
	// case 4:
	// System.out.println("Case 4");
	// break;
	// case 5:
	// System.out.println("Case 5");
	// break;
	// case 6:
	// System.out.println("Case 6");
	// break;
	// case 7:
	// System.out.println("Case 7");
	// break;
	// case 8:
	// System.out.println("Case 8");
	// break;
	// default:
	// System.out.println("Invalid Option");
	// break;
	//
	// }
	//
	// }
	// while (choice.equalsIgnoreCase("Yes"));
	//
	// scanner.close();
	//
	// }
	//logger.info("Exit in MovieBookingSystemMenu");
}
