package com.anyungu.authdemo.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anyungu.authdemo.requests.RegisterUserRequest;
import com.anyungu.authdemo.responses.StatusResponse;
import com.anyungu.authdemo.services.UserRegisterService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserRegisterController {

	@Autowired
	private UserRegisterService userRegisterService;

	// post method end point to register
	@PostMapping(path = "/register")
	public StatusResponse registerUser(@RequestBody RegisterUserRequest registerUserRequest) {

		userRegisterService.createUser(registerUserRequest);

		StatusResponse stat = new StatusResponse(LocalDateTime.now().plusHours(3), "Success!", 200);
		return stat;

	}

}
