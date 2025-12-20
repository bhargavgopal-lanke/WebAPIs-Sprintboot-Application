package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Authentication {
	@GetMapping("auth-login")
	public String login() {
		System.out.println("login");
		return "login successfull"; 
	}
	
	@GetMapping("create-account")
	public String signup() {
		System.out.println("Sign up");
		return "account successfull";
	}
	
	@GetMapping("reset-password")
	public void resetPassword() {
		System.out.println("Reset password");
	}
	
}
