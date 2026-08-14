package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserData {
	String username;
	String email;
	String password;
	String mobile;
	
	
	public void setUserName(String username) {
		this.username = username;
	}
	
	public String getUserName() {
		return this.username;
	}

	// compatibility methods used elsewhere in the project
	public String getName() {
		return this.getUserName();
	}

	public String getUsername() {
		return this.getUserName();
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getMobile() {
		return mobile;
	}
	
}

