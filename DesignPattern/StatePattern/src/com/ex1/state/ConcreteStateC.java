package com.ex1.state;

public class ConcreteStateC implements State {

	@Override
	public void handle(String sampleParameter) {
		System.out.println("ConcreteStateC handle ：" + sampleParameter);
	}

}
