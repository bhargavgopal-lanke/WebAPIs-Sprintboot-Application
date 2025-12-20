package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetApis {
	
	@GetMapping("watch")
	public String getVedioDetails( @RequestParam String v,@RequestParam String channel) {
		return v +" "+ channel;
	};
	
	@GetMapping("/api/v1/users/profileinfo")
	public String getProfileDetails(@RequestParam String username) {
		return username;
	};
	
	// assignment
	
	@GetMapping("s")
	public String assignmentApiTaskOne(@RequestParam String k, @RequestParam String i,@RequestParam String crid) {
		return k + " " + i + " " + crid;
	}
}
