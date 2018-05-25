package com.yash.mbs.domain;

import java.sql.Time;
import java.util.List;

/**
 * This class will be the Movie Entity and its primary work is to transfer data
 * among layers.
 * 
 * @author soumya.gupta
 *
 */
public class Movie {

	private int id;
	private String title;
	private String production;
	private Time duration;
	private List<String> actors;

	public Movie(int id, String title, String production, Time duration, List<String> actors) {
		super();
		this.id = id;
		this.title = title;
		this.production = production;
		this.duration = duration;
		this.actors = actors;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getProduction() {
		return production;
	}

	public List<String> getActors() {
		return actors;
	}

	public Time getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", production=" + production + ", duration=" + duration
				+ ", actors=" + actors + "]";
	}

}
