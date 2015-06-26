package com.ex1.decorator;

import com.ex1.decorated.Beverage;

public abstract class Ingredient extends Beverage {
	//需要添加该佐料的饮料
	Beverage beverage;
	
	@Override
	public float getCost() {
		//配料没有折扣，直接返回其价格 + 饮料价格
		return cost + beverage.getCost();
	}
	

	@Override
	public String getDesc() {
		//佐料的描述应当带上括号，以区别佐料与饮料
	    return "(" + desc + ")" + beverage.getDesc();
	}
	
	//在此添加其它Ingredient不同于Beverage的属性与行为
}
