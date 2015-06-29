package com.ex1.operation;

import com.ex1.fish.AbstractFish;

public class Braised implements FishOperate {

	@Override
	public void cookFish(AbstractFish fish) {
		System.out.println("Braised "+fish.getDesc());
	}

}
