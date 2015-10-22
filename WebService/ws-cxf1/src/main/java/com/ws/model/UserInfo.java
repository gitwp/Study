package com.ws.model;

public class UserInfo {
	private String userName;
	private Integer userAge;

	public UserInfo(String name, Integer age) {
		this.userAge = age;
		this.userName = name;
	}

	public UserInfo() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

}