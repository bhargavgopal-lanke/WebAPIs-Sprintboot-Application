package com.example.demo.pojo;

import lombok.Data;

// name , email,password, mobile, gender, country
@Data
public class SignupData {
	private String name;
	private String email;
	private String password;
	private String mobile;
	private String gender;
	private String country;
}
