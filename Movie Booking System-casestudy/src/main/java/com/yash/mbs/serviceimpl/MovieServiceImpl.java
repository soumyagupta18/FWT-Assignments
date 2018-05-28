package com.yash.mbs.serviceimpl;

import java.io.FileNotFoundException;
import java.sql.Time;

import org.apache.log4j.Logger;

import com.yash.mbs.dao.MovieDAO;
import com.yash.mbs.domain.Movie;
import com.yash.mbs.exception.EmptyFieldExcepiton;
import com.yash.mbs.exception.ObjectNullPointerException;
import com.yash.mbs.service.MovieService;

public class MovieServiceImpl implements MovieService {

	private MovieDAO movieDAO;
	private static final Logger logger = Logger.getLogger(MovieServiceImpl.class);

	public MovieServiceImpl() {
	}
	public MovieServiceImpl(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	public boolean addMovie(Movie movie, String screenName) throws FileNotFoundException {
		logger.info("Entered into addMovie method-MovieServiceImpl");
		checkNullMovieObject(movie);
		checkEmptyMovieFields(movie, screenName);
		logger.info("Exit from addMovie method-MovieServiceImpl ");
		return movieDAO.insert(movie, screenName);

	}

	private void checkEmptyMovieFields(Movie movie, String screenName) {
		if (movie.getTitle() == "" || movie.getDuration() == Time.valueOf("00:00:00") || movie.getProduction() == ""
				|| screenName == "") {
			logger.info("Fields as Movie title ,duration,production and screen name cannot be left empty.");
			throw new EmptyFieldExcepiton("Fields cannot be empty");
		}
	}

	private void checkNullMovieObject(Movie movie) {
		if (movie == null) {
			logger.info("checking for Movie object cannot be null.");
			throw new ObjectNullPointerException("Movie cannot be null");
		}
	}

}
