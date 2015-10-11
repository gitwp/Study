package com.ex7.callable.client;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThread implements Callable<Integer>{

	//线程的执行体
	@Override
	public Integer call() throws Exception {
		int i=0;
		for(;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" " + i);
		}
		return i;
	}
	
	public static void main(String[] args) {
		//Callable对象
		CallableThread ct = new CallableThread();
		//FutureTask来包装Callable对象
		FutureTask<Integer> task = new FutureTask<Integer>(ct);
		
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+" " + i);
			if(i==30){
				new Thread(task).start();
			}
		}
		
		try {
			//获取线程的返回值，task.get()方法会阻塞主线程的执行
			System.out.println("return value:"+task.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
