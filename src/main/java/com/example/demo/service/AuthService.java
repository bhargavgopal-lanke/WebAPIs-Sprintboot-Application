package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.UserDataNew;
import com.example.demo.pojo.LoginApiData;

@Service
public class AuthService {
	public String login(LoginApiData loginApiData) {
		String dbEmail = "bhargav@gmail.com";
		String dbPwd = "1253624673462";

		System.out.println("login pwd" + loginApiData.getPassword());
		
		Boolean emailValidation = loginApiData.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

//		if (emailValidation == true) {
//			return "Email is in proper format";
//		} 
		
		if(loginApiData.getPassword().length() < 8) {
			return "Password is missing";
		}

//		return "userData" + loginApiData.getPassword();

		if (dbEmail.equals(loginApiData.getEmail()) && dbPwd.equals(loginApiData.getPassword())) {
			return "userdata" + loginApiData.toString();
		} else {
			return "invalid data";
		}
	}

}
