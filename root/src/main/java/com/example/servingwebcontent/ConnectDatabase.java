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

	public ResultSet getMovie (String id) {
		ResultSet rs = null;
		String query = "select * from movies where id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
		} catch (SQLException e) { 
			throw new RuntimeException("failed to query db", e); 
		}

		return rs;
	}

	public ResultSet updateMovie (String id, String column, String value) {
		ResultSet rs = null;
		String query = "";
		if (column.equals("type")) {
			query = "update movies set type = ? where id = ?";
		}
		else if (column.equals("name")) {
			query = "update movies set name = ? where id = ?";
		}
		else if (column.equals("releasedate")) {
			query = "update movies set releasedate = ? where id = ?";
		}
		else if (column.equals("duration")) {
			query = "update movies set duration = ? where id = ?";
		}
		else if (column.equals("filmrating")) {
			query = "update movies set filmrating = ? where id = ?";
		}
		else {
			return rs;
		}

		try {
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString (1, value);
			preparedStmt.setString (2, id);
			preparedStmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException("failed to update movie entry", e);
		}

		return rs;
	}

	public void movieInsert (Movie newMovie) {
		String query = "insert into movies (type, name, releasedate, duration, filmrating) values (?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString (1, newMovie.getType());
			preparedStmt.setString (2, newMovie.getName());
			preparedStmt.setString (3, newMovie.getReleaseDate());
			preparedStmt.setInt (4, newMovie.getDuration());
			preparedStmt.setString (5, newMovie.getFilmRating());
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