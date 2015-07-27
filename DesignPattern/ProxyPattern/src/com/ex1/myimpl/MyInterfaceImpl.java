package com.ex1.myimpl;

import com.ex1.myinterface.MyInterface;

public class MyInterfaceImpl implements MyInterface {

	@Override
	public void print() {
		System.out.println("HelloWorld");
	}

	@Override
	public void say() {
		System.out.println("say  HelloWorld");
	}

}
