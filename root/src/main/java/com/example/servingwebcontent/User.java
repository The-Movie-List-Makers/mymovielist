package com.example.servingwebcontent;

public class User {
	private String id;
	private String firstName;
	private String lastName;
	private String handleName;
	public static final String ID = "id";
	public static final String FIRSTNAME = "firstname";
	public static final String LASTNAME = "lastname";
	public static final String HANDLENAME = "handlename";

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getHandleName() {
		return handleName;
	}

	public User(String firstName, String lastName, String handleName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.handleName = handleName;
	}

	public User(String id, String firstName, String lastName, String handleName) {
		this(firstName, lastName, handleName);
		this.id = id;
	}
}