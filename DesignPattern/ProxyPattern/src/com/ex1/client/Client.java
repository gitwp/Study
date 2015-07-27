package com.ex1.client;

import com.ex1.myimpl.MyInterfaceImpl;
import com.ex1.myinterface.MyInterface;
import com.ex1.proxy.DynamicProxy;

public class Client {
	public static void main(String[] args) {
		MyInterface myInterface = new MyInterfaceImpl();
		DynamicProxy dp = new DynamicProxy();

		//未加代理
		MyInterface myInterface2 = new MyInterfaceImpl();
		myInterface2.print();
		myInterface2.say();

		System.out.println("====================================================");
		//代理实现
		MyInterface myInterfaceProxy = (MyInterface) dp
				.bindRelation(myInterface);
		myInterfaceProxy.print();
		myInterfaceProxy.say();

	}
}
