package com.ex1;

import java.util.concurrent.atomic.AtomicLong;


public class NonblockingCounter {

	private AtomicLong value;
	
	public long getValue(){
		return value.get();
	}
	
	//使用 CAS 的非阻塞算法
	public long increment(){
		long v;
		do{
			v=value.get();
		}while(!value.compareAndSet(v, v+1));
		return v+1;
	}
}
