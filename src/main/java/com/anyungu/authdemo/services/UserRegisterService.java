package com.anyungu.authdemo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyungu.authdemo.entities.UserRegister;
import com.anyungu.authdemo.exceptions.CustomException;
import com.anyungu.authdemo.repositories.UserRegisterRepository;
import com.anyungu.authdemo.requests.RegisterUserRequest;

@Service
public class UserRegisterService {

	@Autowired
	private UserRegisterRepository userRegisterRepository;

	@Autowired
	private UserAuthService userAuthService;

	// create user
	public void createUser(RegisterUserRequest registerUserRequest) {

		Optional<UserRegister> findByMail = userRegisterRepository.findByMail(registerUserRequest.getMail());

		// check if mail is us
		if (findByMail.isPresent()) {
			throw new CustomException(401, "Email already in use");
		}

		Optional<UserRegister> findByPhone = userRegisterRepository.findByPhone(registerUserRequest.getPhone());

		// check if phone is taken
		if (findByPhone.isPresent()) {
			throw new CustomException(401, "Phone already in use");
		}

		// register use account
		userAuthService.createUser(registerUserRequest);

		UserRegister user = new UserRegister();
		user.setFname(registerUserRequest.getFname());
		user.setLname(registerUserRequest.getLname());
		user.setMail(registerUserRequest.getMail());
		user.setPhone(registerUserRequest.getPhone());

		// save user details
		userRegisterRepository.save(user);

	}

}
