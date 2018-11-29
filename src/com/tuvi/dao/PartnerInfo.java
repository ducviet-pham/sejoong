package com.tuvi.dao;

public class PartnerInfo {
	private int partnerId;
	private int countryId;
	private String parterName;
	private String image;
	private String content;
	public int getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getParterName() {
		return parterName;
	}
	public void setParterName(String parterName) {
		this.parterName = parterName;
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
}
