package com.tuvi.dao;

public class LocationInfo {
	private int locationId;
	private String locationName;
	private String content;
	private float mapX;
	private float mapY;
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public float getMapX() {
		return mapX;
	}
	public void setMapX(float mapX) {
		this.mapX = mapX;
	}
	public float getMapY() {
		return mapY;
	}
	public void setMapY(float mapY) {
		this.mapY = mapY;
	}
}
