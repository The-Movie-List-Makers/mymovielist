package com.example.servingwebcontent;

public class MovieRating {
	private String ratingID;
	private String userID;
	private String movieID;
	private String status;
	private int rating;

	public String getRatingID () {
		return ratingID;
	}

	public void setRatingID (String ratingID) {
		this.ratingID = ratingID;
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

	public MovieRating (String userID, String movieID, String status, int rating) {
		this.userID = userID;
		this.movieID = movieID;
		this.status = status;
		this.rating = rating;
	}

	public MovieRating (String ratingID, String userID, String movieID, String status, int rating) {
		this.ratingID = ratingID;
		this.userID = userID;
		this.movieID = movieID;
		this.status = status;
		this.rating = rating;
	}
}