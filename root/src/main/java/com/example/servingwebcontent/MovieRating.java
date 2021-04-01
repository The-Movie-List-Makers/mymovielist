package com.example.servingwebcontent;

public class MovieRating {
	private String id;
	private String userID;
	private String movieID;
	private String status;
	private int rating;
	public static final String ID = "id";
	public static final String USERID = "userid";
	public static final String MOVIEID = "movieid";
	public static final String STATUS = "status";
	public static final String RATING = "rating";

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getUserID() {
		return userID;
	}

	public String getMovieID() {
		return movieID;
	}

	public String getStatus() {
		return status;
	}

	public int getRating() {
		return rating;
	}

	public MovieRating(String userID, String movieID, String status, int rating) {
		this.userID = userID;
		this.movieID = movieID;
		this.status = status;
		this.rating = rating;
	}

	public MovieRating(String id, String userID, String movieID, String status, int rating) {
		this(userID, movieID, status, rating);
		this.id = id;
	}
}