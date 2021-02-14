
package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Controller
public class MovieListController {

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
	public String test() throws java.io.FileNotFoundException {
		BufferedReader reader;
		String user = "", pass = "";
	
		try {
			reader = new BufferedReader (new FileReader("./userInfo.txt"));
			String line = reader.readLine();
			user = line;
			line = reader.readLine();
			pass = line;
			reader.close();
		} catch (IOException e) { throw new RuntimeException("user info file not found" ,e); }

		ConnectDatabase connection = new ConnectDatabase("movielist", user, pass);
		try {
			Movie newMovie = new Movie("4", "Movie", "Titanic", "1997-12-19", 195, "PG-13");
			connection.movieInsert(newMovie);
		} //catch (SQLException e) {
			//throw new RuntimeException("failed to connect to or insert into db" ,e);
		//}
		finally {
			connection.closeConnection();
		}

		connection.closeConnection();

		return "test";
	}
}