package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Authentication {
	@GetMapping("/login")
	public void login() {
		System.out.println("Login successful");
	}
	@GetMapping("/signup")
	public String signup() {
		System.out.println("Signup succesful");
		return "Signup successful";
	}
	
	@GetMapping("/resetpassword")
	public String resetpassword() {
		System.out.println("password reset is done");
		return "Password reset is done";
	}
	
}
