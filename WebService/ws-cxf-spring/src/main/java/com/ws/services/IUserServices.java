package com.ws.services;

import javax.jws.WebService;
import com.ws.model.UserInfo;

@WebService
public interface IUserServices {
	public UserInfo getUserInfo(String userName, Integer userAge);
	
	public UserInfo setUserInfo(UserInfo user);
}