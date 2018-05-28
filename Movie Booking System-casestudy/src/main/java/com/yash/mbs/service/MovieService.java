package com.yash.mbs.service;

import java.io.FileNotFoundException;

import com.yash.mbs.domain.Movie;

/**
 * This interface defines the MovieService where business logic related movies
 * will be done.
 * 
 * @author soumya.gupta
 *
 */
public interface MovieService {
	/**
	 * This method will add the movie with the following parameters to the file.
	 * 
	 * @param movie
	 * @param screenName
	 * @return
	 * @throws FileNotFoundException 
	 */
	public boolean addMovie(Movie movie, String screenName) throws FileNotFoundException;

}
