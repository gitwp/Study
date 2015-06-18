package com.ex1.client;

import com.ex1.context.Context;
import com.ex1.strategy.ConcreteStrategyA;
import com.ex1.strategy.Strategy;

public class Client {
	public static void main(String[] args) {
		Strategy stg = new ConcreteStrategyA();
		Context ctx = new Context(stg);
		ctx.contextInterface();
	}
}
