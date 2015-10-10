package com.generic.ex1;
/**
 * 泛型类，尖括号E，跟在类名后面
 */
public class ClassGeneric<E,T,M> {
	//1、实例变量，合法
	E filed1;
	
	//2、静态(类)变量不合法;Cannot make a static reference to the non-static type E
	//static E filed2;
	
	//3、实例方法，合法
	E helloWorld(E parm1){
		E a = null;
		return a; 
	}
	
	//4、静态(类)方法、不合法;Cannot make a static reference to the non-static type E
//	static E staticMethod(){
//		return null;
//	}
}
