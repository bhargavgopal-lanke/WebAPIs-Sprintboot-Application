package com.example.demo.pojo;

import lombok.Data;

@Data
public class CommentsApiData {
	private String comment;
	private int commentId;
	private String user_id;
	private String commentedAt;
}
