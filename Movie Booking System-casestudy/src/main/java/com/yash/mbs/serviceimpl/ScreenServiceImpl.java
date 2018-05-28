package com.yash.mbs.serviceimpl;

import org.apache.log4j.Logger;

import com.yash.mbs.dao.ScreenDAO;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.exception.CapacityExceedException;
import com.yash.mbs.exception.EmptyObjectException;
import com.yash.mbs.exception.ObjectNullPointerException;
import com.yash.mbs.exception.ScreenAlreadyExistExcepiton;
import com.yash.mbs.service.ScreenService;

public class ScreenServiceImpl implements ScreenService {

	private ScreenDAO screenDAO;
	private static final Logger logger = Logger.getLogger(MovieServiceImpl.class);

	public ScreenServiceImpl() {
	}

	public ScreenServiceImpl(ScreenDAO screenDAO) {
		this.screenDAO = screenDAO;
	}

	public boolean addScreen(Screen screen) {
		logger.info("Entered into addScreen method-ScreenServiceImpl");
		checkNullScreenObject(screen);
		checkEmptyScreenName(screen);
		checkScreenAlreadyExist(screen);
		checkScreenCapacity();
		screenDAO.insert(screen);
		System.out.println("Screen Added Successfully!");
		logger.info("Exiting into addScreen method-ScreenServiceImpl");
		return true;
	}

	private void checkScreenAlreadyExist(Screen screen) {
		if (screenDAO.getScreenByName(screen.getName()) == "exists") {
			logger.info("checking for already existing screen-ScreenServiceImpl");
			throw new ScreenAlreadyExistExcepiton("Screen Already Exist");
		}
	}

	private void checkScreenCapacity() {
		if (screenDAO.getAllScreen().size() >= 3) {
			logger.info("checking for screen capacity that should be more than 3-ScreenServiceImpl");
			throw new CapacityExceedException("Cannot add more than 3 screens.");
		}
	}

	private void checkEmptyScreenName(Screen screen) {
		if (screen.getName().equals("")) {
			logger.info("checking for empty screen-ScreenServiceImpl");
			throw new EmptyObjectException("Screen cannot be empty.");
		}
	}

	private void checkNullScreenObject(Screen screen) {
		logger.info("checking for null screen-ScreenServiceImpl");
		if (screen == null) {
			throw new ObjectNullPointerException("Screen cannot be null.");
		}
	}

}
