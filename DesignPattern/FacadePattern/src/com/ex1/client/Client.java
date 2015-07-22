package com.ex1.client;

import com.ex1.facade.ModuleFacade;

public class Client {

	public static void main(String[] args) {
		//内部模块本身存在很多公共的方法，但是仅仅有一些事需要曝露给外界客户端的，通过借助门面类，很好的实现这一点!
		ModuleFacade mf = new ModuleFacade();
		mf.a1();
		mf.b1();
		mf.c1();
	}
}
