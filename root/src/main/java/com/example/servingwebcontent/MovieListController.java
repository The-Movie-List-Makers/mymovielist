
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
	public String test() {
		BufferedReader reader;
		String user = "", pass = "";
	
		try {
			reader = new BufferedReader (new FileReader("./userInfo.txt"));
			String line = reader.readLine();
			user = line;
			line = reader.readLine();
			pass = line;
			reader.close();
		} catch (IOException e) { System.out.println(e); }

		ConnectDatabase connection = new ConnectDatabase("movielist", user, pass);
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