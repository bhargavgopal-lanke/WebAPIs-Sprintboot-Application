package com.example.demo.controller;

import java.security.PublicKey;
// ...existing imports...
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.catalina.util.ErrorPageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.PostApis.user;
import com.example.demo.entity.User;
import com.example.demo.pojo.CommentsyoutubeApi;
import com.example.demo.pojo.EmailData;
import com.example.demo.pojo.LoginApiData;
import com.example.demo.pojo.ProfileUpdateApiData;
import com.example.demo.pojo.SignupData;
import com.example.demo.pojo.Userid;
import com.example.demo.service.AuthService;

import jakarta.validation.Valid;

@RestController
public class AuthController {

	// using @Autowired we can access the methods of AuthService class in this
	// controller class.
	@Autowired
	public AuthService authService;

	@PostMapping("/v3/login")
	public ResponseEntity<Map<String, Object>> login(@Valid @RequestBody LoginApiData loginApiData,
			BindingResult validationResult) {

		if (validationResult.hasErrors() == true) {
			Map<String, String> errorsResponse = new HashMap<String, String>();
			validationResult.getFieldErrors().forEach(Error -> {
				// Hashmap stores key values pairs we use put to add the key and value
				errorsResponse.put(Error.getField(), Error.getDefaultMessage());
			});
			// use LinkedHashMap to preserve insertion order so "Result" appears before
			// "errors"
			Map<String, Object> loginApiResponse = new LinkedHashMap<String, Object>();
			loginApiResponse.put("Result", "Failed");
			loginApiResponse.put("message", "Unable to process your request");
			loginApiResponse.put("errors", errorsResponse);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(loginApiResponse);
		} else {
			String responseString = authService.login(loginApiData);
			// preserve insertion order for consistent JSON output
			Map<String, Object> response = new LinkedHashMap<String, Object>();
			Map<String, Object> userObjMap = new HashMap<String, Object>();
			userObjMap.put("Success", "true");
			userObjMap.put("username", "bhargavlanke");
			userObjMap.put("email", "bhargav@gmail.com");
			userObjMap.put("phone", "9154905425");
			userObjMap.put("profilepic", "hgdsjhsdhshdsd");
			response.put("Login Result", responseString);
			response.put("userData", userObjMap);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}

	// Login with query
	@PostMapping("login-with-query")
	public Object loginWithQueryApi(@Valid @RequestBody LoginApiData loginApiData) {
		return authService.loginWithQueryApi(loginApiData);
	}

	// based on email fetch the data from the Db
	@PostMapping("api-email-data")
	public Object fetchDataUsingEmailApi(@Valid @RequestBody EmailData emailData) {
		return authService.fetchDataUsingEmailApi(emailData);
	}

	@PostMapping("profile-update")
	public Map<String, String> profileUpdate(@Valid @RequestBody ProfileUpdateApiData profileUpdateApiData) {
		Boolean profileResponse = authService.profileUpdate(profileUpdateApiData);
		Map<String, String> profilesResObjMap = new HashMap<String, String>();
		if (profileResponse == true) {
			profilesResObjMap.put("result", "success");
			profilesResObjMap.put("message", "successfully updated");
		} else {
			profilesResObjMap.put("result", "fail");
			profilesResObjMap.put("message", "User doesnt exist");
		}
		return profilesResObjMap;
	}

	// based on the Id fetched all the details from the API
	@GetMapping("userid/{id}")
	public Map<String, Object> userDetailsApi(@PathVariable int id) {
		Optional<User> userDetailsresponse = authService.userDetailsApi(id);
		Map<String, Object> updatedDataRResObjMap = new HashMap<String, Object>();
		if (userDetailsresponse.isPresent() == true) {
			updatedDataRResObjMap.put("result", "success");
			updatedDataRResObjMap.put("data", userDetailsresponse.get());
			updatedDataRResObjMap.put("message", "ok");
			return updatedDataRResObjMap;
		} else {
			updatedDataRResObjMap.put("result", "Failed");
			updatedDataRResObjMap.put("data", userDetailsresponse);
			updatedDataRResObjMap.put("message", "User not found");
			return updatedDataRResObjMap;
		}
	}

	// homework
	// name , email,password, mobile, gender, country
	// Implement the validations for signup method and send the response in
	// structured format like login method.

	@PostMapping("v4/Signup")
	public ResponseEntity<Map<String, Object>> signup(@Valid @RequestBody SignupData signupData,
			BindingResult signupValidationResult) {
		if (signupValidationResult.hasErrors() == true) {
			Map<String, Object> signupErrorsResponse = new HashMap<String, Object>();
			signupValidationResult.getFieldErrors().forEach(Error -> {
				signupErrorsResponse.put(Error.getField(), Error.getDefaultMessage());
			});
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(signupErrorsResponse);
		} else {
			User signupdataResponse = authService.signup(signupData);
			Map<String, Object> signUpresponse = new HashMap<String, Object>();
			signUpresponse.put("Response", "User details submitted");
			signUpresponse.put("Business Response", signupdataResponse);
			return ResponseEntity.status(HttpStatus.OK).body(signUpresponse);
		}

	}

	@PostMapping("v4/comments/add")
	public String Comments(@RequestBody CommentsyoutubeApi commnetsyoutubeapi) {
		return "Comments data" + " " + commnetsyoutubeapi.toString();
	}

	// For partial update of comment id we can use @PatchMapping
	@PatchMapping("v4/comments/{commentId}")
	public String pactchUpdateCommmentId(@PathVariable String commentId) {
		return "Update this comment id with latest Id " + " " + commentId;
	}

	// For complete update of comment we can use @PutMapping
	@PutMapping("v4/comments/{commentId}")
	public String updateCompleteComment(@PathVariable String commentId, @RequestBody CommentsyoutubeApi apidata) {
		return "update complete comment" + " " + commentId + " " + apidata.toString();
	}

	// For deleting the comment we can use @DeleteMapping
	@DeleteMapping("v4/comments/{commentId}")
	public String DeleteComment(@PathVariable String commentId) {
		return "comment deleted successfully" + " " + commentId;
	}

}
