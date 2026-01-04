package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.LoginApiData;
import com.example.demo.service.AuthService;

@RestController
public class AuthController {
	
	@Autowired
	public AuthService authService;

	@PostMapping("/v3/login")
	public String login(@RequestBody LoginApiData loginApiData) {
		String responseString = authService.login(loginApiData);
		return responseString;
//		return "under development" + loginApiData.toString();
	}
	
}
