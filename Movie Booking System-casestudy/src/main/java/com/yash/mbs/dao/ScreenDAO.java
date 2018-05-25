package com.yash.mbs.dao;

import java.util.List;

import com.yash.mbs.domain.Screen;

public interface ScreenDAO {

	/**
	 * This method inserts the screen object into file.
	 * @param screen
	 * @return
	 */
	public boolean insert(Screen screen);
	/**
	 * This method gets the screen by giving screen name
	 * @param screenName
	 * @return
	 */
	public String getScreenByName(String screenName);
	/**
	 * get all the screen that is present in the file.
	 * @return
	 */
	public List<Screen> getAllScreen();
	
	

}
