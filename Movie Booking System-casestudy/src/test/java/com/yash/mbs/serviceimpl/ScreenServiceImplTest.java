package com.yash.mbs.serviceimpl;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.yash.mbs.dao.ScreenDAO;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.exception.CapacityExceedException;
import com.yash.mbs.exception.EmptyObjectException;
import com.yash.mbs.exception.ObjectNullPointerException;
import com.yash.mbs.exception.ScreenAlreadyExistExcepiton;
import com.yash.mbs.service.ScreenService;

public class ScreenServiceImplTest {

	@Mock
	private ScreenDAO screenDAO;

	private ScreenService screenService;

	private Screen screen = null;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		screenService = new ScreenServiceImpl(screenDAO);

	}

	@Test(expected = ObjectNullPointerException.class)
	public void addScreen_NullScreenObjectGiven_ThrowObjectNullPointerException() {
		screenService.addScreen(screen);
	}

	@Test(expected = EmptyObjectException.class)
	public void addScreen_EmptyScreenObjectGiven_ThrowEmptyObjectException() {
		screenService.addScreen(new Screen(1, ""));
	}

	@Test
	public void addScreen_ScreenObjectGiven_ShouldReturnTrue() {
		Screen myScreen = new Screen(101, "Screen-2");
		when(screenDAO.insert(myScreen)).thenReturn(true);
		boolean rowAffected = screenService.addScreen(myScreen);
		Assert.assertEquals(true, rowAffected);
	}

	@Test(expected = ScreenAlreadyExistExcepiton.class)
	public void addScreen_ScreenObjectGivenAlreadyExist_ThrowScreenAlreadyExistException() {
		Screen myScreen = new Screen(101, "Screen-1");
		when(screenDAO.getScreenByName(myScreen.getName())).thenThrow(new ScreenAlreadyExistExcepiton());
		screenService.addScreen(myScreen);

	}

	@Test(expected = CapacityExceedException.class)
	public void addScreen_ScreenObjectGiven_WhenCollectionWillHaveMoreThanThreeScreen_ThrowCapacityExeedException() {
		when(screenDAO.getAllScreen().size()).thenThrow(new CapacityExceedException("Screen has alreday been added"));
		screenService.addScreen(new Screen(101, "Screen-4"));

	}

}
