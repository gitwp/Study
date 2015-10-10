package com.generic.ex3;

import java.util.ArrayList;
import java.util.List;

public class Wildcard {

	public static void main(String[] args) {
		Wildcard wildcard = new Wildcard();
		wildcard.helloWorld(new ArrayList<String>());
		wildcard.helloWorld(new ArrayList<Number>());

		wildcard.helloWorld2(new ArrayList<String>());

		wildcard.helloWorld3(new ArrayList<A>());
		wildcard.helloWorld3(new ArrayList<A1>());
		wildcard.helloWorld3(new ArrayList<B>());
		wildcard.helloWorld3(new ArrayList<A2>());
	}

	// 类型通配符
	private void helloWorld(List<?> list) {

	}

	// 类型通配符的上限
	private void helloWorld2(List<? extends Object> list) {

	}

	// 类型通配符的下限，?必须是A2或者A2的父类
	private void helloWorld3(List<? super A2> list) {

	}
}

class A {

}

interface B {

}

class A1 extends A {

}

class A2 extends A1 implements B {

}

//类型通配符多继承情况
class C<T extends A & B>{
	
}
