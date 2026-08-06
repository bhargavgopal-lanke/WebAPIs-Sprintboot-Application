package com.example.demo.controller;

import java.util.HashMap;

import org.apache.catalina.util.ErrorPageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.LoginApiData;
import com.example.demo.service.AuthService;

import jakarta.validation.Valid;

@RestController
public class AuthController {
	
	@Autowired
	public AuthService authService;

	@PostMapping("/v3/login")
	public String login(@Valid @RequestBody LoginApiData loginApiData) {
		String responseString = authService.login(loginApiData);
		
		HashMap<String, String> errorsMap = new HashMap<String, String>();
		
		
		
		return responseString;
	}
	
}
