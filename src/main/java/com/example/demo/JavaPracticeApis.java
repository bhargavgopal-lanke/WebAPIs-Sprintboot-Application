package com.example.demo;
import java.time.chrono.IsoChronology;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavaPracticeApis {
	
	@GetMapping("/watchpractice")
	public String getVideoDetails(@RequestParam String v, @RequestParam String t) {
		return v + " " + t;
	}
	
	@GetMapping("api/v1/webuserinfo")
	public String getUserInfo(@RequestParam String username, @RequestParam String criData) {
		return "This is username"  + " " + username + " " + criData;
	}
	
	@GetMapping("course/{coursepIdDetails}")
	public String getCoursesId(@PathVariable String coursepIdDetails) {
		return "this is the coursepid id :" + " " + coursepIdDetails;
	}
	
}
