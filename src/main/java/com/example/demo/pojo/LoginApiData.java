package com.example.demo.pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginApiData {
	@NotNull(message = "Email should not be null")
	@NotBlank(message = "Email should not be blank")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email should match this pattern")
	private String email;

	@NotNull(message = "password should not be null")
	@NotBlank(message = "password should not be blank")
	@Size(min = 8, message = "password must be min 8 characters")
	private String password;
}
