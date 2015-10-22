package com.ws.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.ws.model.UserInfo;
import com.ws.services.IUserServices;

public class UserTest {
	public static void main(String[] args) {
		// 创建WebService客户端代理工厂
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		// 注册WebService接口
		factory.setServiceClass(IUserServices.class);
		// 设置WebService地址
		factory.setAddress("http://localhost:9090/ws/services/userService");
		IUserServices userServices = (IUserServices) factory.create();
		System.out.println("invoke userinfo webservice...");
		// 测试返回JavaBean对象的
		UserInfo user = userServices.getUserInfo("vicky", 23);
		System.out.println("UserName: " + user.getUserName());
		System.out.println("UserAge : " + user.getUserAge());
		
		// 测试输入输出JavaBean对象的
		UserInfo user2 = userServices.setUserInfo(user);
		System.out.println("UserName: " + user2.getUserName());
		System.out.println("UserAge : " + user2.getUserAge());
		
		System.exit(0);
	}
}