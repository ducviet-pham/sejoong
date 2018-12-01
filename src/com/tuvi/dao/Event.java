package com.tuvi.dao;

import java.sql.Time;
import java.sql.Timestamp;

public class Event {
	private int evetnId;
	private Timestamp timePlace;
	private Timestamp timeCreated;
	private String title;
	private String content;
	public int getEvetnId() {
		return evetnId;
	}
	public void setEvetnId(int evetnId) {
		this.evetnId = evetnId;
	}
	public Timestamp getTimePlace() {
		return timePlace;
	}
	public void setTimePlace(Timestamp timePlace) {
		this.timePlace = timePlace;
	}
	public Timestamp getTimeCreated() {
		return timeCreated;
	}
	public void setTimeCreated(Timestamp timeCreated) {
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
