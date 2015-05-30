package com.wangp.ws.service;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.wangp.bean.User;

@WebService
public interface IMyService1 {
	public int add(int a, int b);
	
	@WebResult(name="currUser")
	public User getUserById(@WebParam(name="userId")int id);
}
