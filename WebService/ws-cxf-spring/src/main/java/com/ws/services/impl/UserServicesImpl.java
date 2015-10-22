package com.ws.services.impl;

import javax.jws.WebService;

import com.ws.model.UserInfo;
import com.ws.services.IUserServices;

@WebService(
		serviceName="userService",
		targetNamespace="http://services.ws.com/", 
		portName="UserServicePort",
		endpointInterface = "com.ws.services.IUserServices"
)
public class UserServicesImpl implements IUserServices {
	@Override
	public UserInfo getUserInfo(String userName, Integer userAge) {
		return new UserInfo(userName, userAge);
	}

	@Override
	public UserInfo setUserInfo(UserInfo user) {
		return user;
	}
}