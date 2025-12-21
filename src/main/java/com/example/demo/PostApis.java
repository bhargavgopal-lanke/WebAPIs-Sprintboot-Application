package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostApis {
	
	@PostMapping("/auth/login")
		public String Login() {
			return "login scuccessful";
		};
		
	@PostMapping("auth/createAccount")
		public String Signup(){
			return "Account created successfully";
		};
		
	@PostMapping("auth/forgotpassword")
		public String forgotPassword() {
			return "password reset successfull";
		};
}
