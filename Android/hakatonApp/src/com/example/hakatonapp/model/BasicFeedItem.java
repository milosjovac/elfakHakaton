package com.example.hakatonapp.model;

import java.util.ArrayList;
import java.util.Date;

public class BasicFeedItem {
	
	String title;
	String ownerUsername;
	ArrayList<String> tags;
	Date dateAndTime;
	
	public BasicFeedItem(){}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOwnerUsername() {
		return ownerUsername;
	}
	public void setOwnerUsername(String ownerUsername) {
		this.ownerUsername = ownerUsername;
	}
	public ArrayList<String> getTags() {
		return tags;
	}
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	public Date getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}	
}
