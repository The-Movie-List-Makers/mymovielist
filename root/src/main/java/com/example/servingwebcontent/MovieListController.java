
package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.*;

@Controller
public class MovieListController {
	ConnectDatabase connection = new ConnectDatabase("movielist", "root", "moviepass");

	@GetMapping("/navbar")
	public String navbar() {
		return "navbar";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@GetMapping("/test")
	public String test() {
		//ResultSet rs = connection.queryDB("select * from movies");

		MovieObject newMovie = new MovieObject("4", "Movie", "Titanic", "1997-12-19", 195, "PG-13");
		connection.movieInsert(newMovie);

		/**rs = connection.queryDB("select * from movies");
		while (rs.next()) {
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getInt(5) +  " " + rs.getString(6));
		}**/

		connection.closeConnection();

		return "test";
	}
}