package com.ws.services.impl;

import javax.jws.WebService;
import com.ws.model.UserInfo;
import com.ws.services.IUserServices;

@WebService
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