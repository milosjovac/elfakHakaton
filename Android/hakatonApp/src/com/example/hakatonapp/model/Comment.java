package com.example.hakatonapp.model;

public class Comment {

	String username;
	String avatarUrl;
	String commenttext;

	public Comment(String username, String avatarUrl, String commenttext) {
		super();
		this.username = username;
		this.avatarUrl = avatarUrl;
		this.commenttext = commenttext;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getCommenttext() {
		return commenttext;
	}

	public void setCommenttext(String commenttext) {
		this.commenttext = commenttext;
	}

}
