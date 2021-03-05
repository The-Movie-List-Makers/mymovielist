package com.example.servingwebcontent;

public class MovieRating {
	private String id;
	private String userID;
	private String movieID;
	private String status;
	private int rating;
	private static final String [] columns = {"id", "userid", "movieid", "status", "rating"};

	public String getID () {
		return id;
	}

	public void setID (String id) {
		this.id = id;
	}

	public String getUserID () {
		return userID;
	}

	public String getMovieID () {
		return movieID;
	}

	public String getStatus () {
		return status;
	}

	public int getRating () {
		return rating;
	}

	public static final String [] getColumns () {
		return columns;
	}

	public MovieRating (String userID, String movieID, String status, int rating) {
		this.userID = userID;
		this.movieID = movieID;
		this.status = status;
		this.rating = rating;
	}

	public MovieRating (String id, String userID, String movieID, String status, int rating) {
		this(userID, movieID, status, rating);
		this.id = id;
	}
}