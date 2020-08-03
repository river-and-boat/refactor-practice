package com.twu.refactoring;

public class Movie {

	private String title;

	private MovieTypeEnum movieTypeEnum;

	public Movie(String title, MovieTypeEnum movieTypeEnum) {
		this.title = title;
		this.movieTypeEnum = movieTypeEnum;
	}

	public MovieTypeEnum getMovieTypeEnum() {
		return movieTypeEnum;
	}

	public void setMovieTypeEnum(MovieTypeEnum movieTypeEnum) {
		this.movieTypeEnum = movieTypeEnum;
	}

	public String getTitle () {
		return title;
	}
}

