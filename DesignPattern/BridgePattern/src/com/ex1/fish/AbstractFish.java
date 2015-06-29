package com.ex1.fish;

import com.ex1.operation.FishOperate;

public abstract class AbstractFish {
	//鱼的种类
	private String desc;
	//鱼的做法
	private FishOperate fishOperate;
	
	public AbstractFish(FishOperate fishOperate) {
		super();
		this.fishOperate = fishOperate;
	}

	public String getDesc() {
		return desc;
	}
	
	protected void setDesc(String desc){
		this.desc=desc;
	}

	public void cookFish(){
		fishOperate.cookFish(this);
	}
}
