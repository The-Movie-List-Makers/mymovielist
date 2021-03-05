package com.example.servingwebcontent;

public class User {
	private String userID;
	private String firstName;
	private String lastName;
	private String handleName;

	public String getUserID () {
		return userID;
	}

	public void setUserID (String userID) {
		this.userID = userID;
	}

	public String getFirstName () {
		return firstName;
	}

	public String getLastName () {
		return lastName;
	}

	public String getHandleName () {
		return handleName;
	}

	public User (String firstName, String lastName, String handleName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.handleName = handleName;
	}

	public User (String userID, String firstName, String lastName, String handleName) {
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.handleName = handleName;
	}
}