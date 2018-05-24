package com.yash.mbs.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.yash.mbs.dao.ScreenDAO;
import com.yash.mbs.domain.MyScreen;
import com.yash.mbs.exception.CapacityExceedException;
import com.yash.mbs.exception.ScreenAlreadyExistExcepiton;
import com.yash.mbs.service.ScreenService;

public class ScreenServiceImpl implements ScreenService {

	List<MyScreen> screens = new ArrayList<MyScreen>();
	private ScreenDAO screenDAO;
	
	public ScreenServiceImpl() {
		screens = Arrays.asList(new MyScreen(103, "Screen-3"),new MyScreen(104, "Screen-4"), new MyScreen(105, "Screen-5"));
	}

	public ScreenServiceImpl(ScreenDAO screenDAO) {
		this.screenDAO = screenDAO;
	}
	

	public int addScreen(MyScreen myScreen) {
		
		//TODO :  if screen already exist, throw ScreenAlreadyExistException (should be replace with actual dao)
		
		if(myScreen.getName().equals("Screen-1")){
			throw new ScreenAlreadyExistExcepiton("Screen Already Exist");
		}
		
		//TODO :  if screens size exceeds 3, then throw CapacityExceedException (should be replace with actual dao) 
		if(screens.size()>=3){
			throw new CapacityExceedException("Cannot add more than 3 screens.");
		}
		
		return screenDAO.insert(myScreen);
	}

}
