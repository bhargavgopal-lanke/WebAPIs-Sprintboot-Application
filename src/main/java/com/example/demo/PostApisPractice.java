package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostApisPractice {
	
	@PostMapping("/v4/login")	
	public String postLoginApi(@RequestBody LoginData loginDataObj) {
		String dbEmail = "test@gmail.com";
		String dbPwd ="2345678";
		
		  if(dbEmail.equals(loginDataObj.getEmail()) && dbPwd.equals(loginDataObj.getPassword())) {
			  return "Login details are correct"; 
			} else {
			  return "Invalid login details"; 
		  }
	}
	
	@PostMapping("auth/loginn")
	public String postloginApii(@RequestParam String email, @RequestParam String password) {
		return "This is auth login api" + "username "  + email + "Password " + password;
	}
	
	@PostMapping("auth/signupp")
	public String postSignupApii(@RequestBody UserData userDataObj) {
		return "This is auth signup api" + " " + userDataObj.getUserName() + " " + userDataObj.getEmail();
	}
	
	@PostMapping("auth/resetpasswordd")
	public String postRestPasswordApii() {
		return "This is resetpassword api";
	}
}
