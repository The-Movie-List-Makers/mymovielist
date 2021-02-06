
package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.*;

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
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/movielist","root","moviepass");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/movielist?" + "user=root&password=moviepass");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from movies");

			ArrayList<movieObject> movies = new ArrayList<movieObject>();
			while (rs.next()) {
				movieObject movie = new movieObject(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
				movies.add(movie);
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getInt(5) +  " " + rs.getString(6));
			}
			con.close();
		} catch (Exception e) { System.out.println(e); }
		System.out.println("hello world");

		return "test";
	}
}