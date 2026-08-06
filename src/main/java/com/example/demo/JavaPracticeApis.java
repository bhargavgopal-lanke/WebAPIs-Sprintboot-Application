package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavaPracticeApis {
	
	@GetMapping("/watchpractice")
	public String getVideoDetails(@RequestParam String v) {
		return v;
	}
}
