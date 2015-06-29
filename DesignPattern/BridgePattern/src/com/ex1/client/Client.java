package com.ex1.client;

import com.ex1.fish.AbstractFish;
import com.ex1.fish.Carp;
import com.ex1.fish.FlyingFish;
import com.ex1.fish.Shark;
import com.ex1.operation.Braised;
import com.ex1.operation.FishOperate;
import com.ex1.operation.Steamed;

public class Client {
	public static void main(String[] args) {
		//红烧鲤鱼
		FishOperate fo = new Braised();
		AbstractFish af = new Carp(fo);
		af.cookFish();
		//红烧鲨鱼
		af=new Shark(fo);
		af.cookFish();
		//红烧飞鱼
		af=new FlyingFish(fo);
		af.cookFish();
		//清蒸鲤鱼
		fo = new Steamed();
		af = new Carp(fo);
		af.cookFish();
		//清蒸鲨鱼
		af=new Shark(fo);
		af.cookFish();
		//清蒸飞鱼
		af=new FlyingFish(fo);
		af.cookFish();
	}
}
