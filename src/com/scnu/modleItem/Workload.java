package com.scnu.modleItem;

//教师工作量类
public class Workload {
	private String term = null; // 学年度
	private String userID = null; // 教师编号
	private String UserName = null; // 教师姓名
	private String fullTime = null; // 全日制本科总课时
	private String openTime = null; // 开放学院总课时
	private String phoenixTime = null; // 凤凰学院总课时
	private String adultTime = null; // 成人教育总课时

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getFullTime() {
		return fullTime;
	}

	public void setFullTime(String fullTime) {
		this.fullTime = fullTime;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getPhoenixTime() {
		return phoenixTime;
	}

	public void setPhoenixTime(String phoenixTime) {
		this.phoenixTime = phoenixTime;
	}

	public String getAdultTime() {
		return adultTime;
	}

	public void setAdultTime(String adultTime) {
		this.adultTime = adultTime;
	}

}
