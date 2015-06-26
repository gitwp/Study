package com.classadapter;

public class Client {
	public static void main(String[] args) {
		Target tg = new Adapter();
		System.out.println(tg.targetMethod());
	}
}
