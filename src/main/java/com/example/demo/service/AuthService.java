package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.UserDataNew;
import com.example.demo.pojo.LoginApiData;

@Service
public class AuthService {
	String dbEmail = "bhargav@gmail.com";
	String dbPwd = "1253624673462";

	public String login(LoginApiData loginApiData) {
		if (dbEmail.equals(loginApiData.getEmail()) && dbPwd.equals(loginApiData.getPassword())) {
			return "userdata" + loginApiData.toString();
		} else {
			return "invalid data";
		}

	}
}
