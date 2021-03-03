package com.example.servingwebcontent;

public class User {
	private String firstName;
	private String lastName;
	private String handleName;

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
}