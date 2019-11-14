package com.anyungu.authdemo.facilities;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

//Class for password ecoding and matching

@Service
public class PasswordFacility {

	public String encode(String rawPassword) {
		return BCrypt.hashpw(rawPassword, BCrypt.gensalt(4));
	}

	public boolean matches(String rawPassword, String encodedPassword) {
		return BCrypt.checkpw(rawPassword, encodedPassword);
	}

	public String generateToken(String email, String password)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		LocalDateTime dateTime = LocalDateTime.now();
		return BCrypt.hashpw(dateTime.toString() + password + email, BCrypt.gensalt(4));
	}
}
