package com.anyungu.authdemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

//MySQL TABLE Mapping

@Entity
public class UserAuth {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Integer userID;

	@NotNull
	@Column(name = "mail", nullable = false, unique = true)
	private String mail;

	@NotNull
	@Column(name = "password", nullable = false)
	private String password;

	@NotNull
	@Column(name = "type", nullable = false)
	private String userType;

	@NotNull
	@Column(name = "state", nullable = false)
	private Boolean userAccountState;

//getters and setters for the fields

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Boolean getUserAccountState() {
		return userAccountState;
	}

	public void setUserAccountState(Boolean userAccountState) {
		this.userAccountState = userAccountState;
	}

	// toString method for Json Data Representaion

	@Override
	public String toString() {
		return "userAuth [userID=" + userID + ", mail=" + mail + ", password=" + password + ", userType=" + userType
				+ ", userAccountState=" + userAccountState + "]";
	}

}
