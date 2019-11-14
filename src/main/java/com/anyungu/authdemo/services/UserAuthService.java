package com.anyungu.authdemo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyungu.authdemo.entities.Tokenn;
import com.anyungu.authdemo.entities.UserAuth;
import com.anyungu.authdemo.exceptions.CustomException;
import com.anyungu.authdemo.facilities.PasswordFacility;
import com.anyungu.authdemo.repositories.UserAuthRepository;
import com.anyungu.authdemo.requests.LoginUserRequest;
import com.anyungu.authdemo.requests.RegisterUserRequest;

//service class to manage the logic of user authentication activities

@Service
public class UserAuthService {

	// connecting the user Auth table using this repository
	@Autowired
	private UserAuthRepository userAuthRepository;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private PasswordFacility passwordFacility;

	// function to create a user access
	public void createUser(RegisterUserRequest registerUserRequest) {

		Optional<UserAuth> findByMail = userAuthRepository.findByMail(registerUserRequest.getMail());

		// check if mail exists
		if (findByMail.isPresent()) {
			throw new CustomException(401, "Email already in existence");
		}

		String password = passwordFacility.encode(registerUserRequest.getPassword());

		UserAuth user = new UserAuth();
		user.setMail(registerUserRequest.getMail());
		user.setPassword(password);
		user.setUserAccountState(true);
		user.setUserType("normal");

		//save user
		userAuthRepository.save(user);

	}

	// function to log in user
	public Tokenn loginUser(LoginUserRequest loginUserRequest) throws Exception {

		String mail = loginUserRequest.getMail();
		String password = loginUserRequest.getPassword();

		// check if user exists
		Optional<UserAuth> userL = userAuthRepository.findByMail(mail);

		if (!userL.isPresent()) {
			throw new CustomException(401, "User not Found");
		}

		// check if password matches
		boolean matches = passwordFacility.matches(password, userL.get().getPassword());

		if (matches == false) {
			throw new CustomException(401, "Incorrect password. Authentication Failed");
		}

		Tokenn tokenOnlogin = tokenService.getTokenOnlogin(mail, password);
		return tokenOnlogin;

	}

	// logout User Access
	public void logoutUser(String mail) {

		tokenService.deleteToken(mail);

	}

}
