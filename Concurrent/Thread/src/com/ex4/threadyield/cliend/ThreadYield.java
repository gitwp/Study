package com.ex4.threadyield.cliend;
/**
 * 让出CPU实例
 */
public class ThreadYield {

	public static void main(String[] args) {
		Thread t1 = new MyThread("t1");
		Thread t2 = new MyThread("t2");
		t1.start();
		t2.start();
	}
}

class MyThread extends Thread{
	public MyThread(String name){
		super(name);
	}
	
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("thread:"+getName()+"------"+i);
			if(i%10==0){
				//让出CPU，此时线程执行必然切换
				yield();
			}
		}
	}
}