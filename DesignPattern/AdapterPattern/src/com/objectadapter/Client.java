package com.objectadapter;

import com.objectadapter.Adapter;
import com.objectadapter.Target;

public class Client {
	public static void main(String[] args) {
		Adaptee apt = new Adaptee();
		Target tg = new Adapter(apt);
		System.out.println(tg.targetMethod());
	}
}
