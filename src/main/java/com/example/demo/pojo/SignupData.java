package com.example.demo.pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

// name , email,password, mobile, gender, country
@Data
public class SignupData {
	@NotBlank(message = "Name should not be blank")
	@NotNull(message= "Name should not be null")
	@Size(min= 3, max = 100, message ="Name should be in between 3 and 100 characters")
	private String name;
	@NotBlank(message="Email should not be blank")
	@NotNull(message =" Email should not be null")
	//@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$", message=" Email should match this pattern")
	private String email;
	@NotBlank(message="Password should not be blank")
	@NotNull(message="Password should not be null")
	@Size(min=8, message="Password must be min 8 characters")
	private String password;
//	@NotNull(message="Mobile should not be null")
//	@NotBlank(message="Mobile should not be blank")
//	@Pattern(regexp = "^[0-9]{10}$", message="Mobile should be 10 digits")
//	private String mobile;
//	private String gender;
//	private String country;
}
