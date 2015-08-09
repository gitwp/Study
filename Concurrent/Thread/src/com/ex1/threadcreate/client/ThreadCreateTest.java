package com.ex1.threadcreate.client;
/**
 * 线程创建实例
 */
public class ThreadCreateTest {
	public static void main(String[] args) {
		Runner r = new Runner();
		Thread t = new Thread(r);
		// 注意此处t.start()与直接使用r.run()之间的区别，前者叫做线程启动，后者叫做方法调用。
		// 线程启动：相当与在程序中开辟了一条新的执行路径，它与主线程交替执行；
		// 方法调用：程序中只用一条执行路径
		t.start();

		for (int i = 0; i < 100; i++) {
			System.out.println("Main:" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

/**
 * 自定义线程类 1、定义线程类有两种方法：①、新建一个类继承Thread类；②、新建一个类实现Runnable接口
 * <p>
 * 2、通常选择实现接口的方式创建线程类，因为这样做更灵活，即：不仅能实现该接口还能实现其他接口并且能继承其他类
 */
// class Runner extends Thread{
class Runner implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Runner:" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}