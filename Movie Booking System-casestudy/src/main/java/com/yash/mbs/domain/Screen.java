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
	private Movie myMovie;

	public Screen(int id, String name) {
		this.id = id;
		this.name = name;

	}

	public Screen(int id, String name, Movie myMovie) {
		this.id = id;
		this.name = name;
		this.myMovie = myMovie;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Movie getMyMovie() {
		return myMovie;
	}

	@Override
	public String toString() {
		return "MyScreen [id=" + id + ", name=" + name + ", myMovie=" + myMovie + "]";
	}

}
