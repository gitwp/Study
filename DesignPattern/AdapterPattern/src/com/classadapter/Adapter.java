package com.classadapter;
/**
 * 类适配器
 */
public class Adapter extends Adaptee implements Target {

	@Override
	public String targetMethod() {
		String tempRst = super.adapteeMethod();
		String targetMethod = tempRst +"  to  targetRst";
		return targetMethod;
	}

}
