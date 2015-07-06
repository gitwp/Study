package com.ex1.task;

import java.util.Date;

public class SchedualTask2 {
	
	public void printMe() {
		System.out.println("SchedualTask2 ~ start:"+ new Date());
		for(int i=0;i<10;i++){
			System.out.println("SchedualTask2 ~ printMe~"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("SchedualTask2 ~ end:"+ new Date());
	}
}
