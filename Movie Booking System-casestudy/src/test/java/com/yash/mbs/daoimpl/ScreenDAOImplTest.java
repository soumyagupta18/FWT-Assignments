package com.yash.mbs.daoimpl;

import static org.junit.Assert.*;

import java.sql.Time;
import java.util.Arrays;

import org.junit.Test;

import com.yash.mbs.dao.ScreenDAO;
import com.yash.mbs.domain.Movie;
import com.yash.mbs.domain.Screen;

public class ScreenDAOImplTest {

	private ScreenDAO screenDAO = new ScreenDAOImpl();

	@Test
	public void insertScreen_ScreenObjectGiven_ShouldReturnTrue() {

		boolean isScreenAdded = screenDAO.insert(new Screen(102, "Screen-2",
				new Movie(1, "K3G", "Dharma Production", Time.valueOf("04:00:00"), Arrays.asList("Sharukh", "Kajol"))));
		assertTrue(isScreenAdded);
	}

}
