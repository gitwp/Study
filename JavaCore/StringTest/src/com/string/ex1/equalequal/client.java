package com.string.ex1.equalequal;

public class client {
	public static void main(String[] args) {
		// "ab"存在常量池中，a指向常量池中"ab"的地址
		String a = "ab";
		// “b”存在常量池中
		final String bb = "b";
		String cc = "b";
		String b = "a" + bb;
		String c = "a" + cc;
		/**
		 * 变量b的值在编译就可以确定指向常量池中“ab”的地址， 因为bb使用了final修饰并且bb指向确定的字符串
		 * 变量c的值只有在运行时才能确定，变量c相当于在运行时new了一个String对象，这个新对象存储在堆中
		 */
		System.out.println(bb == cc);// true
		System.out.println(a == b); // true
		/**
		 * a指向“ab”在常量池中"ab"的地址 c指向在运行时创建的对象“ab”在堆中的地址
		 * c.intern()返回一个String对象，这个String对象指向--->c指向的对象“ab”在常量池中的地址
		 */
		System.out.println(a == c); // false
		System.out.println(a == c.intern()); // true
	}
	
	//这里是class文件中的内容
//	public static void main(String[] args)
//	  {
//	    String a = "ab";
//
//	    String bb = "b";
//	    String cc = "b";
//	    String b = "ab";
//	    String c = "a" + cc;
//
//	    System.out.println("b" == cc);
//	    System.out.println(a == b);
//
//	    System.out.println(a == c);
//	    System.out.println(a == c.intern());
//	  }
}
