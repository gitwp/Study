package com.ex1.context;

import com.ex1.strategy.Strategy;

public class Context {
	private Strategy strategy;

	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}
	
	public void contextInterface(){
		System.out.println("Context contextInterface start.......");
		strategy.strategyInterface();
		System.out.println("Context contextInterface end.......");
	}
}
