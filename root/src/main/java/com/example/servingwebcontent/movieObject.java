package com.example.servingwebcontent;

import java.util.*;

public class MovieObject {
	String id;
	String type;
	String name;
	String releaseDate;
	int duration;
	String filmRating;

	public MovieObject (String id, String type, String name, String releaseDate, int duration, String filmRating) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.releaseDate = releaseDate;
		this.duration = duration;
		this.filmRating = filmRating;
	}
}