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

	public Movie getMovie (String id) {
		ResultSet rs = null;
		String query = "select * from movies where id=?";
		Movie movie = null;
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				movie = new Movie(rs.getString(Movie.getColumns()[2]), rs.getString(Movie.getColumns()[1]), rs.getString(Movie.getColumns()[2]), rs.getString(Movie.getColumns()[3]), rs.getInt(Movie.getColumns()[4]), rs.getString(Movie.getColumns()[5]));
			}
		} catch (SQLException e) { 
			throw new RuntimeException("failed to query movies table", e); 
		}

		return movie;
	}

	public void updateMovie (Movie movie) {
		ResultSet rs = null;
		String query = "update movies set type = ?, name = ?, releasedate = ?, duration = ?, filmrating = ? where id = ?";
		int i = 1;
		try {
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString (i++, movie.getType());
			preparedStmt.setString (i++, movie.getName());
			preparedStmt.setString (i++, movie.getReleaseDate());
			preparedStmt.setInt (i++, movie.getDuration());
			preparedStmt.setString (i++, movie.getFilmRating());
			preparedStmt.setString (i++, movie.getID());
			preparedStmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException("failed to update movie entry", e);
		}

		return;
	}

	public void movieInsert (Movie newMovie) {
		String query = "insert into movies (type, name, releasedate, duration, filmrating) values (?, ?, ?, ?, ?)";
		try {
			int i = 1;
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString (i++, newMovie.getType());
			preparedStmt.setString (i++, newMovie.getName());
			preparedStmt.setString (i++, newMovie.getReleaseDate());
			preparedStmt.setInt (i++, newMovie.getDuration());
			preparedStmt.setString (i++, newMovie.getFilmRating());
			preparedStmt.execute();
		} catch (SQLException e) { 
			throw new RuntimeException("failed to insert into movie table", e);
		}

	}

	public MovieRating getRating (String id) {
		ResultSet rs = null;
		String query = "select * from ratings where id=?";
		MovieRating rating = null;
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				rating = new MovieRating(rs.getString(MovieRating.getColumns()[0]), rs.getString(MovieRating.getColumns()[1]), rs.getString(MovieRating.getColumns()[2]), rs.getString(MovieRating.getColumns()[3]), rs.getInt(MovieRating.getColumns()[4]));
			}
		} catch (SQLException e) { 
			throw new RuntimeException("failed to query ratings table", e); 
		}

		return rating;
	}

	public void ratingInsert (MovieRating movieRating) {
		String query = "insert into ratings (userid, movieid, status, rating) values (?, ?, ?, ?)";
		try {
			int i = 1;
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString (i++, movieRating.getUserID());
			preparedStmt.setString (i++, movieRating.getMovieID());
			preparedStmt.setString (i++, movieRating.getStatus());
			preparedStmt.setInt (i++, movieRating.getRating());
			preparedStmt.execute();
		} catch (SQLException e) { 
			throw new RuntimeException("failed to insert into ratings table", e);
		}
	}

	public void updateRating (MovieRating movieRating) {
		ResultSet rs = null;
		String query = "update ratings set userid = ?, movieid = ?, status = ?, rating = ? where id = ?";
		int i = 1;
		try {
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString (i++, movieRating.getUserID());
			preparedStmt.setString (i++, movieRating.getMovieID());
			preparedStmt.setString (i++, movieRating.getStatus());
			preparedStmt.setInt (i++, movieRating.getRating());
			preparedStmt.setString (i++, movieRating.getID());
			preparedStmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException("failed to update movie entry", e);
		}

		return;
	}

	public User getUser (String id) {
		ResultSet rs = null;
		String query = "select * from users where id=?";
		User user = null;
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString(User.getColumns()[0]), rs.getString(User.getColumns()[1]), rs.getString(User.getColumns()[2]), rs.getString(User.getColumns()[3]));
			}
		} catch (SQLException e) { 
			throw new RuntimeException("failed to query user table", e); 
		}

		return user;
	}

	public void userInsert (User newUser) {
		String query = "insert into users (firstName, lastName, handleName) values (?, ?, ?)";
		try {
			int i = 1;
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString (i++, newUser.getFirstName());
			preparedStmt.setString (i++, newUser.getLastName());
			preparedStmt.setString (i++, newUser.getHandleName());
			preparedStmt.execute();
		} catch (SQLException e) { 
			throw new RuntimeException("failed to insert into user table", e);
		}

	}

	public void updateUser (User newUser) {
		ResultSet rs = null;
		String query = "update users set firstName = ?, lastName = ?, handleName = ?";
		int i = 1;
		try {
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString (i++, newUser.getFirstName());
			preparedStmt.setString (i++, newUser.getLastName());
			preparedStmt.setString (i++, newUser.getHandleName());
			preparedStmt.setString (i++, newUser.getID());
			preparedStmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException("failed to update user entry", e);
		}

		return;
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