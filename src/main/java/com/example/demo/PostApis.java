package com.example.demo;

import java.lang.System.Logger;
import java.security.PublicKey;
import java.util.concurrent.Flow.Publisher;

import org.springframework.web.bind.annotation.ModelAttribute;
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

	@PostMapping("/ting/ting")
	public String newApi(@RequestParam String ding, @RequestParam String dong) {
		return "ting ting api is called " + ding + " " + dong;
	}

	public static class user {
		public String name;
		public int age;
	}

	@PostMapping("/list/users")
	public String listUsers(@RequestBody user user) {
		return "List of users" + " " + user.name + " " + user.age;
	}

	@PostMapping("auth/createAccount")
	public String Signup(@RequestBody UserData userData) {
		return "Account created successfully " + userData.getName() + ", " + userData.getEmail() + ", "
				+ userData.getPassword() + ", " + userData.getMobile();
	};

	@PostMapping("auth/forgotpassword")
	public String forgotPassword() {
		return "password reset successfull";
	};

	@PostMapping("user/data")
	public String userData(@RequestBody UserDataNew userDataNew) {
		return "user api data" + " " + userDataNew.getUsername() + " " + userDataNew.getEmail() + " "
				+ userDataNew.getPassword() + " " + userDataNew.getMobile();
	}

	@PostMapping("auth/signup/v2")
	public String userSignup(@ModelAttribute UserDataNew userDatanew) {
		return "signup successfull" + " " + userDatanew.toString();
	}

	@PostMapping("v1/login")
	public String login(@RequestBody LoginData loginData) {
		String dbEmail = "bhargav@gmail.com";
		String dbPwd = "9154905425";

		if (dbEmail.equals(loginData.getEmail()) && dbPwd.equals(loginData.getPassword())) {
			return "Login Data" + loginData.toString();
		} else {
			return "Login invalid";
		}
	}

}
