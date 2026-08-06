package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavaPracticeApis {
	public static void main(String[] args) {
		System.out.println("Hello World 4");
	}
	
	@GetMapping("/watch")
	public String getVedioaDetails() {
		return "vedio details";
	}
}
