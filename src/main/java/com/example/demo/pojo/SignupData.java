package com.example.demo.pojo;

import lombok.Data;

// name , email,password, mobile, gender, country
@Data
public class SignupData {
	public String name;
	public String email;
	public String password;
	public String mobile;
	public String gender;
	public String country;
}
