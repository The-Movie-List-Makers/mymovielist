package com.example.servingwebcontent;

import java.util.*;

public class movieObject {
	String movie_id;
	String movie_type;
	String movie_name;
	String movie_releaseDate;
	int movie_duration;
	String movie_filmRating;

	public movieObject() {
	}

	public movieObject (String id, String type, String name, String releaseDate, int duration, String filmRating) {
		movie_id = id;
		movie_type = type;
		movie_name = name;
		movie_releaseDate = releaseDate;
		movie_duration = duration;
		movie_filmRating = filmRating;
	}
}