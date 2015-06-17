package com.ex1.concrete;

import com.ex1.templete.AbstractTemplete;

public class ConcreteTemplete extends AbstractTemplete {

	@Override
	protected void abstractMethod() {
		System.out.println("ConcreteTemplete abstractMethod");
	}

	//可选项、可实现也可不实现
	@Override
	protected void hookMethod(){
		System.out.println("ConcreteTemplete hookMethod");
	}
}
