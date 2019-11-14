package com.anyungu.authdemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

//MySQL TABLE Mapping

@Entity(name = "register")
public class UserRegister {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Integer userID;

	@NotNull
	@Column(name = "mail", nullable = false, unique = true)
	private String mail;

	@NotNull
	@Column(name = "phone", nullable = false, unique = true)
	private String phone;

	@NotNull
	@Column(name = "fname", nullable = false)
	private String fname;

	@NotNull
	@Column(name = "lname", nullable = false)
	private String lname;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	// toString method for Json Data Representaion
	@Override
	public String toString() {
		return "UserRegister [userID=" + userID + ", mail=" + mail + ", phone=" + phone + ", fname=" + fname
				+ ", lname=" + lname + "]";
	}

}
