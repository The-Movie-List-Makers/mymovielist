package com.example.servingwebcontent;

import java.sql.*;
import java.util.*;

public class ConnectDatabase {
	Connection con = null;

	public ConnectDatabase (String database, String user, String pass) {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/" + database + "?" + "user=" + user + "&password=" + pass);
		} 
		catch (SQLException e) { 
			throw new RuntimeException("failed to connect to db" ,e); 
		}
	}

	public ResultSet queryDB (String query) {
		ResultSet rs = null;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e) { 
			throw new RuntimeException("failed to query db", e); 
		}

		return rs;
	}

	public void movieInsert (Movie newMovie) {
		String query = "insert into movies (movieid, type, name, releasedate, duration, filmrating) values (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString (1, newMovie.getId());
			preparedStmt.setString (2, newMovie.getType());
			preparedStmt.setString (3, newMovie.getName());
			preparedStmt.setString (4, newMovie.getReleaseDate());
			preparedStmt.setInt (5, newMovie.getDuration());
			preparedStmt.setString (6, newMovie.getFilmRating());
			preparedStmt.execute();
		} catch (SQLException e) { 
			throw new RuntimeException("failed to insert into db", e);
		}

	}

	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) { 
			throw new RuntimeException("failed to close connection", e); 
		}
	}

	public Connection getConnection () {
		return con;
	}

	public static void main(String args[]) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
}