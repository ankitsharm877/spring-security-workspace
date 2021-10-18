package com.appsdeveloperblog.ws.api.resourceserver.model;

public class User {
	private String firstName;
	private String lastName;
	private String userid;
	
	public User() {
		
	}
	public User(String firstName, String lastName, String userid) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userid = userid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
}
