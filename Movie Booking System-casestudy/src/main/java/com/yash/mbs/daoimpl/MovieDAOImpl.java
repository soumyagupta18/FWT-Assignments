package com.yash.mbs.daoimpl;

import java.io.FileNotFoundException;
import java.util.List;

import com.yash.mbs.dao.MovieDAO;
import com.yash.mbs.domain.Movie;
import com.yash.mbs.domain.Screen;
import com.yash.mbs.util.JsonUtil;
import com.yash.mbs.util.FileUtil;

public class MovieDAOImpl implements MovieDAO {

	private FileUtil fileUtil = new FileUtil();
	
	public boolean insert(Movie movie, String screenName) throws FileNotFoundException {
		
		String data = fileUtil.readFile("src/main/resources/ScreenJson.json");
		List<Screen> screen = JsonUtil.ConvertjsonToObject(data);
		for (Screen screenobject : screen) {
			if (screenobject.getName() == screenName) {
				screenobject.setMovie(movie);

			}
		}
		return true;
	}

}
