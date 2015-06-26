package com.ex1.decorated;

public abstract class Beverage {
	// 定义饮料相关描述信息
	protected String desc = "Unknown Beverage";
	// 定义饮料的价格
	protected float cost;
	
	// 定义cost方法返回该饮料的价格，子类必须实现此方法
	public abstract float getCost();

	public String getDesc() {
		return desc;
	}
}
