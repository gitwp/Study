package com.test;

import javax.xml.ws.Endpoint;

import com.ws.services.impl.UserServicesImpl;

public class ServerTest {
	public ServerTest() {
		// 发布User服务接口
		Endpoint.publish("http://localhost:9090/ws/services/userService",
				new UserServicesImpl());
	}

	public static void main(String[] args) {
		// 启动服务
		new ServerTest();
		System.out.println("Server ready...");
		try {
			Thread.sleep(2000 * 60);// 休眠五分分钟，便于测试
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Server exit...");
		System.exit(0);
	}
}