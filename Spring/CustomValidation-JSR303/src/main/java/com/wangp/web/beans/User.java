package com.wangp.web.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.wangp.web.annotation.Phone;

public class User {

	@NotNull(message="{NotNull.user.username}")
	private String username;
	@NotNull(message="{NotNull.user.username}")
	private String password;
	@Pattern(regexp="^$|^[1-3]{1}$",message="{Pattern.user.status}")
	private String status;
	@Phone(message="{Phone.user.phone}")
	private String phone;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
