package com.spring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.beans.Account;
import com.spring.beans.Account2;
import com.spring.beans.Account3;
import com.spring.beans.Account4;

public class Client {
	public static void main( String[] args )
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //XML方式使用占位符
        Account MyAccount = ctx.getBean("account", Account.class);
        //注解方式使用占位符
        Account2 MyAccount2 = ctx.getBean("account2", Account2.class);
        //占位符值加密处理
        Account3 MyAccount3 = ctx.getBean("account3", Account3.class);
        //引用bean的属性
        Account4 MyAccount4 = ctx.getBean("account4", Account4.class);
        
        System.out.println(MyAccount.toString());
        System.out.println(MyAccount2.toString());
        System.out.println(MyAccount3.toString());
        System.out.println(MyAccount4.toString());
    }
}
