package com.yash.mbs.domain;

/**
 * This class will be of Screen Entity and its primary work is to transfer data
 * among layers.
 * 
 * @author soumya.gupta
 *
 */
public class Screen {

	private int id;
	private String name;
	private Movie movie;

	public Screen(int id, String name) {
		this.id = id;
		this.name = name;

	}

	public Screen(int id, String name, Movie movie) {
		this.id = id;
		this.name = name;
		this.movie = movie;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Movie getmovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "MyScreen [id=" + id + ", name=" + name + ", movie=" + movie + "]";
	}

}
