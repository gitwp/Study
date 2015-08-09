package com.ex3.threadjoin.client;
/**
 * 线程合并实例
 */
public class ThreadJoinTest {

	public static void main(String[] args) {
		MyThread t = new MyThread("myThread");
		t.start();
		
		try {
			//线程合并方法调用
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<10;i++){
			System.out.println("Main---------------");
		}
	}
}

class MyThread extends Thread{
	//线程起名：便于追溯问题
	public MyThread(String name){
		super(name);
	}
	
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("thread:"+getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}