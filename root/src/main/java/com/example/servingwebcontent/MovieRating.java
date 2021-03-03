package com.example.servingwebcontent;

public class MovieRating {
	private String userID;
	private String movieID;
	private String status;
	private int rating;

	public String getUserID () {
		return userID;
	}

	public String getMovieID () {
		return movieID;
	}

	public String getStatus () {
		return status;
	}

	public String getRating () {
		return rating;
	}

	public User (String userID, String movieID, String status, int rating) {
		this.userID = userID;
		this.movieID = movieID;
		this.status = status;
		this.rating = rating;
	}
}