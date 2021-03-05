package com.example.servingwebcontent;

public class Movie {
	private String movieID;
	private String type;
	private String name;
	private String releaseDate;
	private int duration;
	private String filmRating;

	public String getId () {
		return movieID;
	}

	public void setId (String movieID) {
		this.movieID = movieID;
	}

	public String getType () {
		return type;
	}

	public String getName () {
		return name;
	}

	public String getReleaseDate () {
		return releaseDate;
	}

	public int getDuration () {
		return duration;
	}

	public String getFilmRating () {
		return filmRating;
	}

	public Movie (String type, String name, String releaseDate, int duration, String filmRating) {
		this.type = type;
		this.name = name;
		this.releaseDate = releaseDate;
		this.duration = duration;
		this.filmRating = filmRating;
	}

	public Movie (String movieID, String type, String name, String releaseDate, int duration, String filmRating) {
		this.movieID = movieID;
		this.type = type;
		this.name = name;
		this.releaseDate = releaseDate;
		this.duration = duration;
		this.filmRating = filmRating;
	}
}