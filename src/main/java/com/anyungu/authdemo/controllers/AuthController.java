package com.anyungu.authdemo.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anyungu.authdemo.entities.Tokenn;
import com.anyungu.authdemo.models.LoginSuccessDataModel;
import com.anyungu.authdemo.requests.LoginUserRequest;
import com.anyungu.authdemo.responses.GeneralResponse;
import com.anyungu.authdemo.responses.StatusResponse;
import com.anyungu.authdemo.services.UserAuthService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

	@Autowired
	private UserAuthService userAuthService;

	// post method to log in
	@PostMapping(path = "/login")
	public GeneralResponse<LoginSuccessDataModel> LoginUser(@RequestBody LoginUserRequest loginUserRequest) throws Exception {

		Tokenn loginUser = userAuthService.loginUser(loginUserRequest);

		LoginSuccessDataModel suc = new LoginSuccessDataModel();
		suc.setExpiry(loginUser.getExpiresAt());
		suc.setToken(loginUser.getToken());

		GeneralResponse<LoginSuccessDataModel> gen = new GeneralResponse<LoginSuccessDataModel>(
				LocalDateTime.now().plusHours(3), "Login Successfully", 200, suc);
		return gen;
	}

	// post method to log out
	@PostMapping(path = "/logout")
	public StatusResponse LogoutUser(String mail) throws Exception {

		userAuthService.logoutUser(mail);

		StatusResponse stat = new StatusResponse(LocalDateTime.now().plusHours(3), "Log Out Success", 200);
		return stat;

	}

}
