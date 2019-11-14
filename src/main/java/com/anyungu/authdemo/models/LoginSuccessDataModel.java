package com.anyungu.authdemo.models;

import java.time.LocalDateTime;

public class LoginSuccessDataModel {

	private String token;

	private LocalDateTime expiry;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getExpiry() {
		return expiry;
	}

	public void setExpiry(LocalDateTime expiry) {
		this.expiry = expiry;
	}

}
