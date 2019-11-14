package com.anyungu.authdemo.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyungu.authdemo.entities.Tokenn;
import com.anyungu.authdemo.facilities.PasswordFacility;
import com.anyungu.authdemo.repositories.TokenRepository;

//Class to manage access token logic

@Service
public class TokenService {

	// connecting the user Tokenn table using this repository
	@Autowired
	private TokenRepository tokenRepository;

	@Autowired
	private PasswordFacility passwordFacility;

	// function to generate an access token
	private String generateToken(String email, String password) throws Exception {
		String generateToken = passwordFacility.generateToken(email, password);
		return generateToken;
	}

	// Generate and Save the token Entity
	private Tokenn saveToken(String mail, String password) throws Exception {

		// generate
		String generateToken = generateToken(mail, password);

		LocalDateTime time = LocalDateTime.now().plusHours(3);
		LocalDateTime expiryrTime = time.plusDays(2);

		Tokenn tokenn = new Tokenn();
		tokenn.setCreatedAt(time);
		tokenn.setExpiresAt(expiryrTime);
		tokenn.setMail(mail);
		tokenn.setToken(generateToken);

		// Save the token Entity
		Tokenn saveTokenn = tokenRepository.save(tokenn);
		return saveTokenn;
	}

	// function to get a valid access token
	public Tokenn getTokenOnlogin(String mail, String password) throws Exception {

		Optional<Tokenn> findById = tokenRepository.findById(mail);

		// check if a token already exists
		if (findById.isPresent()) {

			LocalDateTime timeNow = LocalDateTime.now().plusHours(3);
			LocalDateTime expiresAt = findById.get().getExpiresAt();

			// check if available token has expired
			if (timeNow.isAfter(expiresAt)) {
				// generate access token
				Tokenn saveToken = saveToken(mail, password);
				return saveToken;
			}

			return findById.get();

		} else {

			// generate access token
			Tokenn saveToken = saveToken(mail, password);
			return saveToken;

		}

	}

	// function to delete an access token
	public void deleteToken(String mail) {
		tokenRepository.deleteById(mail);
	}

}
