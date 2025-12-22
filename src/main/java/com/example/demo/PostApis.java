package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostApis {
	
	@PostMapping("/auth/login")
		public String Login(@RequestParam String email, @RequestParam String password) {
			return "login scuccessful: " + email + " " + password;
		};
		
	@PostMapping("auth/createAccount")
		public String Signup(@RequestBody UserData userData){
			return "Account created successfully " + userData.getName()
			+ ", " + userData.getEmail() + ", " + userData.getPassword() 
			+ ", " + userData.getMobile();
		};
		
	@PostMapping("auth/forgotpassword")
		public String forgotPassword() {
			return "password reset successfull";
		};
		
		
}
