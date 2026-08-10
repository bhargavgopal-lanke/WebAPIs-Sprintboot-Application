package com.example.demo.controller;

import java.util.HashMap;

import org.apache.catalina.util.ErrorPageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.CommentsyoutubeApi;
import com.example.demo.pojo.LoginApiData;
import com.example.demo.pojo.SignupData;
import com.example.demo.service.AuthService;

import jakarta.validation.Valid;

@RestController
public class AuthController {
	
	// using @Autowired we can access the methods of AuthService class in this controller class.
	@Autowired
	public AuthService authService;

	@PostMapping("/v3/login")
	public String login(@Valid @RequestBody LoginApiData loginApiData) {
		String responseString = authService.login(loginApiData);
		// HashMap<String, String> errorsMap = new HashMap<String, String>();
		return responseString;
	}
	
	// homework
	// name , email,password, mobile, gender, country
	
	@PostMapping("v4/Signup")
	public String signup(@RequestBody SignupData signupData) {
		String signupdataResponse = authService.signup(signupData);				
		return signupdataResponse;
	}
	
	@PostMapping("v4/comments/add")
	public String  Comments(@RequestBody CommentsyoutubeApi commnetsyoutubeapi) {
		return "Comments data" +" " + commnetsyoutubeapi.toString();
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
