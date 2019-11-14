package com.anyungu.authdemo.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

//Table for the user access tokens

@Entity(name = "token")
public class Tokenn {

	@NotNull
	@Id
	@Column(name = "mail", unique = true, nullable = false)
	private String mail;

	@NotNull
	@Column(name = "token", unique = true, nullable = false)
	private String token;

	private LocalDateTime createdAt;

	private LocalDateTime expiresAt;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(LocalDateTime expiresAt) {
		this.expiresAt = expiresAt;
	}

	@Override
	public String toString() {
		return "Token [mail=" + mail + ", token=" + token + ", createdAt=" + createdAt + ", expiresAt=" + expiresAt
				+ "]";
	}

}
