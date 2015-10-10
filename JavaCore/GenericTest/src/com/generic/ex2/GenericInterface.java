package com.generic.ex2;

public interface GenericInterface<M,V> {

	static String field = "a";
	
	//Cannot make a static reference to the non-static type M
	//M field2;
	
	M method1(V parm1);
}
