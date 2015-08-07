package com.spring.beans;

import com.spring.enums.AccountEnum;

public class Account {

	private String name;
	private AccountEnum status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AccountEnum getStatus() {
		return status;
	}
	public void setStatus(AccountEnum status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		if(status!=null){
			return "name="+name+" status="+status.getName();
		}
		return super.toString();
	}
}
