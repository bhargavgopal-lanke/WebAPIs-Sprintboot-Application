package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.CommentsApiData;

@RestController
public class CommentsController {
	
	@PostMapping("/comments/add")
	public String addComment(@RequestBody CommentsApiData commentsApiData) {
		return "Comments data" + commentsApiData.toString();
	}
	
	@PatchMapping("/comments/{commentId}")
	public String updateComment(@PathVariable String commentId) {
		return "Update this Comment Id with latest coomment: "  + commentId;
	}
	
	@PutMapping("/comments/{commentsId}")
	public String updateCompleteComment(@RequestParam String commentId, @RequestBody CommentsApiData commentsApiData) {
		return "update complete comment: " + commentsApiData.toString();
	}
	
	@DeleteMapping("/comments/{commentsId}")
	public String deleteComment(@PathVariable String commentsId) {
		return "comment deleted successfully: " + commentsId;
	}
	
}
