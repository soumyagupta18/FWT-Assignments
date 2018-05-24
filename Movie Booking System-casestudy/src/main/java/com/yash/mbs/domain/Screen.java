package com.yash.mbs.domain;

import java.util.ArrayList;

public class Screen {

	private int screenId;
	private String name;
	private Movie movie;
	private ArrayList<Row> rows;

	public Screen() {
	}

	public Screen(int screenId, String name) {
		super();
		this.screenId = screenId;
		this.name = name;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public ArrayList<Row> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "Screen [screenId=" + screenId + ", name=" + name + ", movie=" + movie + ", rows=" + rows + "]";
	}

}
