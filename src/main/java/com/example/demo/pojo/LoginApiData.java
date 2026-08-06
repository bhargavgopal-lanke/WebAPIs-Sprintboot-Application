package com.example.demo.pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginApiData {
	@NotNull
	@NotBlank
	@matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
	private String email;
	
	@NotNull
	@NotBlank
	private String password;
}
