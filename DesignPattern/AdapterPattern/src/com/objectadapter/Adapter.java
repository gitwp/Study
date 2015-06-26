package com.objectadapter;
/**
 * 对象适配器
 */
public class Adapter implements Target {
	
	private Adaptee adaptee;
	
	public Adapter(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}

	@Override
	public String targetMethod() {
		String tempRst = adapteeMethod();
		String targetMethod = tempRst +"  to  targetRst";
		return targetMethod;
	}

	@Override
	public String adapteeMethod() {
		return adaptee.adapteeMethod();
	}

}
