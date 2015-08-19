package com.hashmap.ex1.unsafe;

import java.util.HashMap;

public class Client {
	//hashmap是非线程安全的
	public static final HashMap<String, String> map=new HashMap<String, String>();
	
	public static void main(String[] args) throws Exception{
		Thread t1 = new Thread(){
			public void run(){
				for(int i=0;i<100;i++){
					map.put(String.valueOf(i), String.valueOf(i));
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				for(int i=100;i<200;i++){
					map.put(String.valueOf(i), String.valueOf(i));
				}
			}
		};
		
		t1.start();
		t2.start();
		
		Thread.sleep(1000);

		//理想情况下，下面不会输出任何错误值
		//现实往往是残酷的
		for(int i=0;i<200;i++){
			if(!(i+"").equals(map.get(String.valueOf(i)))){
				System.err.println(i+":"+map.get(String.valueOf(i)));
			}
		}
	}
}
