package com.tuvi.dao;

import java.sql.Time;

public class News {
	private int newsId;
	private String image;
	private String title;
	private String content;
	private Time timeCreated;
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
