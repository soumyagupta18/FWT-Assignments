package com.yash.mbs.domain;

import java.sql.Time;
import java.util.List;

public class Movie {
	private int movieId;
	private String title;
	private String production;
	private Time duration;
	private List<String> actors;

	public Movie(int movieId, String title, String production, Time duration, List<String> actors) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.production = production;
		this.duration = duration;
		this.actors = actors;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", production=" + production + ", duration="
				+ duration + ", actors=" + actors + "]";
	}

}
