package com.yash.mbs.dao;

import java.io.FileNotFoundException;

import com.yash.mbs.domain.Movie;

public interface MovieDAO {
	
	/**
	 * This method will insert the movie and the screen name
	 * 
	 * @param movie
	 * @param screenName
	 * @return
	 * @throws FileNotFoundException 
	 */
	public boolean insert(Movie movie, String screenName) throws FileNotFoundException;

}
