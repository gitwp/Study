package com.wangp.ws.service.impl;

import javax.jws.WebService;

import com.wangp.bean.User;
import com.wangp.ws.service.IMyService1;

@WebService(endpointInterface="com.wangp.ws.service.IMyService1")
public class MyService1Impl implements IMyService1{

	public int add(int a, int b) {
		System.out.println("a+b="+(a+b));
		return a+b;
	}

	public User getUserById(int id) {
		User user = new User();
		user.setId(1);
		user.setName("hello");
		user.setPassword("world...");
		return user;
	}


}
