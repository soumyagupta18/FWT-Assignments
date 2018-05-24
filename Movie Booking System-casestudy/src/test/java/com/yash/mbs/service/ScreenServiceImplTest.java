package com.yash.mbs.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.yash.mbs.dao.ScreenDAO;
import com.yash.mbs.domain.MyScreen;
import com.yash.mbs.exception.CapacityExceedException;
import com.yash.mbs.exception.ScreenAlreadyExistExcepiton;
import com.yash.mbs.serviceimpl.ScreenServiceImpl;

public class ScreenServiceImplTest {

	@Mock
	private ScreenDAO screenDAO;

	private ScreenService screenService;

	@Before
	public void runBeforeTestMethod() {
		MockitoAnnotations.initMocks(this);
		screenService = new ScreenServiceImpl(screenDAO);

	}

	@Test
	public void addScreen_ScreenObjectGiven_ShouldReturnOne() {
		MyScreen myScreen = new MyScreen(101, "Screen-2");
		when(screenDAO.insert(myScreen)).thenReturn(1);
		int rowAffected = screenService.addScreen(myScreen);
		assertEquals(1, rowAffected);
	}

	@Test(expected = ScreenAlreadyExistExcepiton.class)
	public void addScreen_ScreenObjectGivenAlreadyExist_ThrowScreenAlreadyExistException() {
		MyScreen myScreen = new MyScreen(101, "Screen-1");
		when(screenDAO.getScreen(myScreen.getName())).thenThrow(new ScreenAlreadyExistExcepiton());
		screenService.addScreen(myScreen);

	}

	@Test(expected=CapacityExceedException.class)
	public void addScreen_ScreenObjectGiven_WhenCollectionWillHaveMoreThanThreeScreen_ThrowCapacityExeedException() {
		ScreenService screenService = new ScreenServiceImpl();
		screenService.addScreen(new MyScreen(101, "Screen-4"));

	}

}
