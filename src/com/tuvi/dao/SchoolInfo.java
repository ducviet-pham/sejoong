package com.tuvi.dao;

public class SchoolInfo {
	private int schoolId;
	private String schoolName;
	private int level;
	private String learningFee;
	private String content;
	private String logo;
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getLearningFee() {
		return learningFee;
	}
	public void setLearningFee(String learningFee) {
		this.learningFee = learningFee;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
}
