package com.example.demo.controller;

import java.util.HashMap;

import org.apache.catalina.util.ErrorPageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.LoginApiData;
import com.example.demo.pojo.SignupData;
import com.example.demo.service.AuthService;

import jakarta.validation.Valid;

@RestController
public class AuthController {
	
	// using @Autowired we can access the methods of AuthService class in this controller class.
	@Autowired
	public AuthService authService;

	@PostMapping("/v3/login")
	public String login(@Valid @RequestBody LoginApiData loginApiData) {
		String responseString = authService.login(loginApiData);
		// HashMap<String, String> errorsMap = new HashMap<String, String>();
		return responseString;
	}
	
	// homework
	// name , email,password, mobile, gender, country
	
	@PostMapping("v4/Signup")
	public String signup(@RequestBody SignupData signupData) {
		String signupdataResponse = authService.signup(signupData);				
		return signupdataResponse;
	}
	
}
