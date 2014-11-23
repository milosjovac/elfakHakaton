package com.example.hakatonapp.model;

import java.util.ArrayList;
import java.util.Date;

public class BasicFeedItem {
	
	String roomId;
	String title;
	String ownerUsername;
	ArrayList<String> tags;
	Date dateAndTime;
	int maxStudents;
	ArrayList<Integer> studentIds;
	

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public int getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}

	public ArrayList<Integer> getStudentIds() {
		return studentIds;
	}

	public void setStudentIds(ArrayList<Integer> studentIds) {
		this.studentIds = studentIds;
	}

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
