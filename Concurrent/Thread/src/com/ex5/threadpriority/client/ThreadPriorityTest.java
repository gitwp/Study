package com.ex5.threadpriority.client;

/**
 * 线程优先级实例
 */
public class ThreadPriorityTest {
	public static void main(String[] args) {
		Thread t1 = new MyThread("t1");
		Thread t2 = new MyThread("t2");
		//优先级越高，占用CPU时间片时间越长
		t2.setPriority(Thread.NORM_PRIORITY+2);
		t1.start();
		t2.start();
	}
}

class MyThread extends Thread{
	public MyThread(String name){
		super(name);
	}
	
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("thread:"+getName()+"------"+i);
		}
	}
}