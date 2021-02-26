
package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

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

	@GetMapping(value = "/movie/{movieId}")
	public String movie (@PathVariable String movieId) throws java.io.FileNotFoundException {
		BufferedReader reader;
		String user = "", pass = "";
	
		try {
			reader = new BufferedReader (new FileReader("./userInfo.txt"));
			user = reader.readLine();
			pass = reader.readLine();
			reader.close();
		} catch (IOException e) { throw new RuntimeException("user info file not found" ,e); }

		ConnectDatabase connection = new ConnectDatabase("movielist", user, pass);

		try {
			ResultSet rs = connection.getMovie(movieId);
		}
		finally {
			connection.closeConnection();
		}

		return "movie";
	}
}