package com.ex2.threadinterrupt.client;

import java.util.Date;
/**
 * 线程中断实例
 */
public class InterruptTest {

	public static void main(String[] args) {
		MyThread t = new MyThread();
		MyThread2 t2 = new MyThread2();
		t.start();
		t2.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 粗暴的打断线程的方法，如果被打断的线程正在休眠，那么会抛出异常;t.stop()也能打断休眠中的线程
		// 粗暴的打断线程如果异常未处理那么往往会带来一些不必要的麻烦，比如资源的释放
		t.interrupt();
		// 通过这种方式终端线程的执行比较安全
		t2.shutdown();
	}

}

class MyThread extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.println("MyThread:" + new Date());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyThread2 extends Thread {
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			System.out.println("MyThread2:" + new Date());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shutdown(){
		this.flag=false;
	}
}