package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.UserDataNew;
import com.example.demo.entity.User;
import com.example.demo.pojo.LoginApiData;
import com.example.demo.pojo.ProfileUpdateApiData;
import com.example.demo.pojo.SignupData;
import com.example.demo.repository.UserRepository;

@Service
public class AuthService {

	@Autowired UserRepository userRepository;
	
	// This is login method
	public String login(LoginApiData loginApiData) {
		String dbEmail = "bhargav@gmail.com";
		String dbPwd = "123456789";

		/*
		 * Boolean emailValidation = loginApiData.getEmail().matches(
		 * "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
		 * 
		 * if (emailValidation == true) { return "Email is in proper format"; }
		 * 
		 * if (loginApiData.getPassword().length() < 8) { return "Password is missing";
		 * }
		 */

		if (dbEmail.equals(loginApiData.getEmail()) && dbPwd.equals(loginApiData.getPassword())) {
			return "userdata" + loginApiData.toString();
		} else {
			return "invalid data";
		}

	}
	
	public User profileUpdate(ProfileUpdateApiData profileUpdateApiData) {
		int userId = profileUpdateApiData.getId();
		String userPassword = profileUpdateApiData.getPassword();
	    User user =	userRepository.findById(userId);
		return profileUpdateApiData.toString();
	}

	// this is sign up method
	public User signup(SignupData signupData) {
		User user = new User();
		user.name = signupData.getName();
		user.email = signupData.getEmail();
		user.password = signupData.getPassword();
		User newUser = userRepository.save(user);
		return newUser;
		
		/*
		 * if (signupData != null) { return "Signupdata is: " + signupData.toString(); }
		 * else { return "Signup data is missing"; }
		 */

	}

}
