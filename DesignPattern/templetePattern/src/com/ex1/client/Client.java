package com.ex1.client;

import com.ex1.concrete.ConcreteTemplete;

public class Client {
	public static void main(String[] args) {
		ConcreteTemplete ct = new ConcreteTemplete();
		ct.templeteMethod();
	}
}
