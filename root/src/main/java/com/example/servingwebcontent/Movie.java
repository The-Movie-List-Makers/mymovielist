package com.example.servingwebcontent;

public class Movie {
	private String id;
	private String type;
	private String name;
	private String releaseDate;
	private int duration;
	private String filmRating;
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String NAME = "name";
	public static final String RELEASEDATE = "releasedate";
	public static final String DURATION = "duration";
	public static final String FILMRATING = "filmrating";

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public int getDuration() {
		return duration;
	}

	public String getFilmRating() {
		return filmRating;
	}

	public Movie(String type, String name, String releaseDate, int duration, String filmRating) {
		this.type = type;
		this.name = name;
		this.releaseDate = releaseDate;
		this.duration = duration;
		this.filmRating = filmRating;
	}

	public Movie(String id, String type, String name, String releaseDate, int duration, String filmRating) {
		this(type, name, releaseDate, duration, filmRating);
		this.id = id;
	}
}