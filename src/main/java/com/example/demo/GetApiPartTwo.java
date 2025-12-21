package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetApiPartTwo {
	
	@GetMapping("o/{upi}/{v2}/{users}/{profileInfo}")
	public String practiceApi(@PathVariable String upi, @PathVariable String v2,
			@PathVariable String users, @PathVariable String profileInfo,
			@RequestParam String username
			) {
		return upi + " " + v2 + " " + users + " " + profileInfo 
				+ "username " + username;
	};
	
}