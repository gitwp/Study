package com.ex1.operation;

import com.ex1.fish.AbstractFish;

public class Steamed implements FishOperate {

	@Override
	public void cookFish(AbstractFish fish) {
		System.out.println("Steamed "+fish.getDesc());
	}

}
