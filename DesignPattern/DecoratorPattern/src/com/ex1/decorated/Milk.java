package com.ex1.decorated;

public class Milk extends Beverage {

	float discount = 1;//定义折扣，节假日Milk可能会打折（默认不打折）

	public float getDiscount() {
	    return discount;
	}

	public void setDiscount(float discount) {
	    this.discount = discount;
	}

	public Milk(){
	    cost = 4.5f;//初始化Milk的价格
	    desc = "Milk";//初始化描述信息
	}

	@Override
	public float getCost(){
	    return discount * cost;//返回打折后的价格
	}

}
