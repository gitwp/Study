package com.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.beans.Account;

public class Client {
	public static void main( String[] args )
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Account MyAccount = ctx.getBean("account", Account.class);
        
        System.out.println(MyAccount.toString());
    }
}
