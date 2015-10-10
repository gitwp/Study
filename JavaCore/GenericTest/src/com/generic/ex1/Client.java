package com.generic.ex1;

public class Client {

	public static void main(String[] args) {
		ClassGeneric<String, String, String> g1 = new ClassGeneric<String, String, String>();
		ClassGeneric<Number, Number, Number> g2 = new ClassGeneric<Number, Number, Number>();
		//true:不存在泛型类，运行时g1,g2,ClassGeneric的类类型相同
		System.out.println(g1.getClass() == g2.getClass());
		System.out.println(g1.getClass() == ClassGeneric.class);
	}
}
