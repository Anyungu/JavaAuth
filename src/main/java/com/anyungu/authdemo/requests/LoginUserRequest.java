package com.anyungu.authdemo.requests;

// class to collect user login data
public class LoginUserRequest {

	private String mail;

	private String password;

	// getters & setters to get and set data

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
