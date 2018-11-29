package com.tuvi.dao;

import java.sql.Time;

public class Event {
	private int evetnId;
	private Time timePlace;
	private Time timeCreated;
	private String title;
	private String content;
	public int getEvetnId() {
		return evetnId;
	}
	public void setEvetnId(int evetnId) {
		this.evetnId = evetnId;
	}
	public Time getTimePlace() {
		return timePlace;
	}
	public void setTimePlace(Time timePlace) {
		this.timePlace = timePlace;
	}
	public Time getTimeCreated() {
		return timeCreated;
	}
	public void setTimeCreated(Time timeCreated) {
		this.timeCreated = timeCreated;
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
}
