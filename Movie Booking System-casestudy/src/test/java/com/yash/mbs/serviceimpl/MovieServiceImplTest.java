package com.yash.mbs.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.yash.mbs.dao.MovieDAO;
import com.yash.mbs.domain.Movie;
import com.yash.mbs.exception.EmptyFieldExcepiton;
import com.yash.mbs.exception.ObjectNullPointerException;
import com.yash.mbs.service.MovieService;

public class MovieServiceImplTest {

	@Mock
	MovieDAO movieDAO;

	private MovieService movieService;

	private String screenName = "Audi-1";

	@Before
	public void runBeforeTestMethod() {
		MockitoAnnotations.initMocks(this);
		movieService = new MovieServiceImpl(movieDAO);
	}

	@Test(expected = ObjectNullPointerException.class)
	public void addMovie_NullMovieObjectGiven_ThrowObjectNullPointerException() throws FileNotFoundException {
		movieService.addMovie(null, screenName);
	}

	@Test
	public void addMovie_MovieObjectGiven_ShouldReturnTrue() throws FileNotFoundException {
		Movie movie = new Movie(1, "K3G", "Dharma Productions", Time.valueOf("03:00:00"),
				Arrays.asList("Rani", "Kajol", "Kareena", "Hritik", "Shahrukh"));
		when(movieDAO.insert(movie, screenName)).thenReturn(true);
		boolean movieAddedStatus = movieService.addMovie(movie, screenName);
		assertEquals(true, movieAddedStatus);
	}

	@Test(expected = EmptyFieldExcepiton.class)
	public void addMovie_MovieObjectGivenWithAnyNullfields_ThrowsEmptyFieldExcepiton() throws FileNotFoundException {
		Movie movie = new Movie(1, "", "Dharma Productions", Time.valueOf("03:00:00"),
				Arrays.asList("Rani", "Kajol", "Kareena", "Hritik", "Shahrukh"));
		when(movieDAO.insert(movie, screenName)).thenThrow(new EmptyFieldExcepiton("No null fields Accepted."));
		movieService.addMovie(movie, screenName);

	}

	@Test(expected = EmptyFieldExcepiton.class)
	public void addMovie_NullScreenNameGiven_ThrowEmptyFieldException() throws FileNotFoundException {
		Movie movie = new Movie(1, "", "Dharma Productions", Time.valueOf("03:00:00"),
				Arrays.asList("Rani", "Kajol", "Kareena", "Hritik", "Shahrukh"));
		when(movieDAO.insert(movie, "")).thenThrow(new EmptyFieldExcepiton("Screen Name cannot eb null"));
		movieService.addMovie(movie, "");

	}

}
