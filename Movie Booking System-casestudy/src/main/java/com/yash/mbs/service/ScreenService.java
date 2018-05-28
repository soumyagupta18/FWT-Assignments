package com.yash.mbs.service;

import com.yash.mbs.domain.Screen;
import com.yash.mbs.exception.ScreenAlreadyExistExcepiton;

/**
 * This interface will define the screen related business logic.
 */
public interface ScreenService {

	/**
	 * Get the name of screen from back end based on name provided.
	 * 
	 * @param myScreen
	 *            object
	 * @return positive integer in case of successful insertion
	 * @throws ScreenAlreadyExistExcepiton
	 *             if screen name already exist
	 */
	public boolean addScreen(Screen screen);

}
