package com.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.publish.MsgRecordPublishObj;

public class Client {
	@SuppressWarnings("resource")
	public static void main( String[] args )
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        MsgRecordPublishObj publisher = ctx.getBean("msgRecordPublishObj", MsgRecordPublishObj.class);
        
        String msg="hello world";
        
        publisher.msgRecordPublish(msg);
    }
}
