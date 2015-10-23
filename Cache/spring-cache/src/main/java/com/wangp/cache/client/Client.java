package com.wangp.cache.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangp.cache.service.MyAccountService;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath*:spring-cache-anno.xml");// 加载 spring 配置文件

		MyAccountService s = (MyAccountService) context
				.getBean("myAccountService");
		// 第一次查询，应该走数据库
		System.out.print("first query...");
		s.getAccountByName("somebody");
		// 第二次查询，应该不查数据库，直接返回缓存的值
		System.out.print("second query...");
		s.getAccountByName("somebody");
		System.out.println();
	}
}
