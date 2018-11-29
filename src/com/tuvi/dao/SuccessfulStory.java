package com.tuvi.dao;

import java.sql.Time;

public class SuccessfulStory {
	private int storyId;
	private String title;
	private String image;
	private String content;
	private Time timeCreated;
	public int getStoryId() {
		return storyId;
	}
	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Time getTimeCreated() {
		return timeCreated;
	}
	public void setTimeCreated(Time timeCreated) {
		this.timeCreated = timeCreated;
	}
}
