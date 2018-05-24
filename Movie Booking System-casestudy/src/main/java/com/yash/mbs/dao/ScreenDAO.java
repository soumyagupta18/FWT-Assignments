package com.yash.mbs.dao;

import com.yash.mbs.domain.MyScreen;

public interface ScreenDAO {

	int insert(MyScreen myScreen);

	MyScreen getScreen(String screenName);

}
