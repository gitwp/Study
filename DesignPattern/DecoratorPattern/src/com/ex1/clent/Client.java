package com.ex1.clent;

import com.ex1.decorated.Beverage;
import com.ex1.decorated.Milk;
import com.ex1.decorator.Coffee;
import com.ex1.decorator.IceWater;
import com.ex1.decorator.Mocha;

public class Client {
	public static void main(String[] args) {
		Beverage bev;

		System.out.println("做一杯加摩卡加咖啡的Milk。。");
		bev = new Milk();// 先做一杯Milk
		bev = new Mocha(bev);// 添加Mocha
		bev = new Coffee(bev);// 添加Coffee
		System.out.println(bev.getDesc() + " " + bev.getCost() + "￥");

		System.out.println("做一杯加双份冰水双份摩卡的咖啡Milk。。");
		bev = new Milk();// 重新做一杯Milk
		bev = new IceWater(bev);// 添加冰水
		bev = new IceWater(bev);// 添加冰水
		bev = new Mocha(bev);// 添加Mocha
		bev = new Mocha(bev);// 添加Mocha
		bev = new Coffee(bev);// 添加Coffee
		System.out.println(bev.getDesc() + " " + bev.getCost() + "￥");
	}
}
