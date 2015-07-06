package com.ex1.task;

import java.util.Date;

public class SchedualTask1 {
	
	public void printMe() {
		System.out.println("SchedualTask1 ~ start:"+ new Date());
		for(int i=0;i<10;i++){
			System.out.println("SchedualTask1 ~ printMe~"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("SchedualTask1 ~ end:"+ new Date());
	}
}
