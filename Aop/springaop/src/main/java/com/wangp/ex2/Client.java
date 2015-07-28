package com.wangp.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangp.ex2.springaop.service.AService;

public class Client {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:annotation.xml");
		
		AService aService = (AService) ac.getBean("aService");
		
		aService.barA();
	}
}
