package com.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class SysConfig {

	private String username="hello";
	private String password="world";
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "username="+username+" password="+password;
	}
}
