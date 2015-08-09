package com.spring.client;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	@SuppressWarnings("resource")
	public static void main( String[] args )
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object[] params = {"honey"};
        
        String zh_CN_Msg = ctx.getMessage("welcome.msg", params,Locale.CHINA);
        String en_US_Msg = ctx.getMessage("welcome.msg", params,Locale.US);
        System.out.println("zh_CN_Msg："+zh_CN_Msg);
        System.out.println("en_US_Msg："+en_US_Msg);
    }
}
