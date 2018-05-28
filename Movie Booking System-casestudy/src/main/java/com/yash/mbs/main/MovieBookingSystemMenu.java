package com.yash.mbs.main;

import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.yash.mbs.dao.MovieDAO;
import com.yash.mbs.daoimpl.MovieDAOImpl;
import com.yash.mbs.domain.Movie;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.service.MovieService;
import com.yash.mbs.service.ScreenService;
import com.yash.mbs.serviceimpl.MovieServiceImpl;
import com.yash.mbs.serviceimpl.ScreenServiceImpl;
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
	private Scanner scanner;
	private FileUtil fileUtil = new FileUtil();
	private MovieDAO movieDAO=new MovieDAOImpl();
	private ScreenService screenService = new ScreenServiceImpl();
	private MovieService movieService=new MovieServiceImpl(movieDAO);
	private String mainFileStartup = "src/main/resources/operatorMenu.txt";

	/**
	 * this will show the main menu and perform all menu regarding operation
	 * @throws FileNotFoundException 
	 */
	public void getMenu() throws FileNotFoundException {
		logger.info("Entering in getMenu() method .Application Entry point.");
		scanner = new Scanner(System.in);
		List<String> listOfActors=new ArrayList<String>();
		String choice;
		int menuChoice;
		do {
			fileUtil.displayOperatorMenu(mainFileStartup);
			menuChoice = scanner.nextInt();
			switch (menuChoice) {
			case 1:
				System.out.println("Enter Screen Id: ");
				int screenId = scanner.nextInt();
				System.out.println("Enter Screen Name: ");
				String screenName = scanner.next();
				Screen screen=new Screen(screenId,screenName);
				screenService.addScreen(screen);

				break;

			case 2:
				System.out.println("Enter Screen on which you want to add movie : ");
				String audi = scanner.next();
				System.out.println("Enter Movie Id: ");
				int id = scanner.nextInt();
				System.out.println("Enter Movie Name");
				String title = scanner.next();
				System.out.println("Enter Movie Production");
				String production = scanner.next();
				scanner.nextLine();
				System.out.println("Enter duration of Movie(HH:MM:SS) : ");
				String durationOfMovie = scanner.nextLine();
				Time duration=Time.valueOf(durationOfMovie);
				System.out.println("Enter number of actors you want to add : ");
				int number = scanner.nextInt();
				for (int i = 1; i <= number; i++) {
					System.out.println("Enter actors : ");
					String actor = scanner.next();
					scanner.nextLine();
					listOfActors.add(actor);
				}
				Movie movie=new Movie(id, title, production, duration, listOfActors);
				movieService.addMovie(movie, audi);

				break;
			case 9:
				System.out.println("Thankyou for using Movie Booking System !");
				System.exit(0);
			default:
				break;
			}
			System.out.println("Do you want to continue..?");
			choice = scanner.next();
		} while (choice.equalsIgnoreCase("Yes"));
		scanner.close();
	}
}
