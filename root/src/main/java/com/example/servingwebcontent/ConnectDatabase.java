package com.example.servingwebcontent;

import java.sql.*;
import java.util.*;

public class ConnectDatabase {
	Connection con = null;

	public ConnectDatabase () {
	}

	public ConnectDatabase (String database, String user, String pass) {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/" + database + "?" + "user=" + user + "&password=" + pass);
		} catch (SQLException e) { System.out.println(e); }
	}

	public ResultSet queryDB (String query) {
		ResultSet rs = null;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e) { System.out.println(e); }

		return rs;
	}

	public void movieInsert (MovieObject newMovie) {
		String query = "insert into movies (movieid, type, name, releasedate, duration, filmrating)" + " values (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString (1, newMovie.id);
			preparedStmt.setString (2, newMovie.type);
			preparedStmt.setString (3, newMovie.name);
			preparedStmt.setString (4, newMovie.releaseDate);
			preparedStmt.setInt (5, newMovie.duration);
			preparedStmt.setString (6, newMovie.filmRating);
			preparedStmt.execute();
		} catch (SQLException e) { System.out.println(e); }

	}

	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) { System.out.println(e); }
	}

	public Connection getConnection () {
		return con;
	}

	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) { System.out.println(e); }
	}
}