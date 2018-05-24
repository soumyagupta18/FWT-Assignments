package com.yash.mbs.service;

import com.yash.mbs.domain.MyScreen;
import com.yash.mbs.exception.ScreenAlreadyExistExcepiton;

public interface ScreenService {

	
	/**
	 * Get the name of screen from backend based on name provided. 
	 * @param myScreen object
	 * @return positive integer in case of successsful insertion
	 * @throws ScreenAlreadyExistExcepiton if screen name already exist
	 */
	int addScreen(MyScreen myScreen) ;

	

	

}
