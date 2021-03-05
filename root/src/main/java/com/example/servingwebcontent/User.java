package com.example.servingwebcontent;

public class User {
	private String id;
	private String firstName;
	private String lastName;
	private String handleName;
	private static final String [] columns = {"id", "firstname", "lastname", "handlename"};

	public String getID () {
		return id;
	}

	public void setID (String id) {
		this.id = id;
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

	public static final String [] getColumns () {
		return columns;
	}

	public User (String firstName, String lastName, String handleName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.handleName = handleName;
	}

	public User (String id, String firstName, String lastName, String handleName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.handleName = handleName;
	}
}