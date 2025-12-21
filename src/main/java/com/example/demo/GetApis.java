package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetApis {
	
	// get values from the api which are there after ? in the form of key value pairs
	@GetMapping("watch")
	public String getVedioDetails( @RequestParam String v,@RequestParam String channel) {
		return v +" "+ channel;
	};
	
	@GetMapping("/api/v1/users/profileinfo")
	public String getProfileDetails(@RequestParam String username) {
		return username;
	};
	
	// assignment
	
	@GetMapping("k")
	public String assignmentApiTaskOne(@RequestParam String k, @RequestParam String i,@RequestParam String crid) {
		return k + " " + i + " " + crid;
	};
	
	// get  values from query parameters which are not assigned to any variable
	
	@GetMapping("c/{courseDetails}") 
	public String getCourseDetails(@PathVariable String courseDetails) {
		return "get course details for: " + courseDetails;
	};
	
	@GetMapping("p/{postid}")
	public String getpostDetails(@PathVariable String postid) {
		return "get post deatils for:" + postid; 
	};
	
	@GetMapping("{seoTitle}/dp/{productId}/{tomato}")
	public String getAmazonProductDetails(@PathVariable String seoTitle,
			@PathVariable String productId, @PathVariable String tomato) {
		return "get amazon product details for: " + seoTitle + 
				" with product id " + productId + " and tomato " + tomato;
	};
	
}
