package com.ex1.templete;

public abstract class AbstractTemplete {
	/**
	 * 模板方法-子类直接调用
	 * 包含：模板的各个选项环节
	 */
	public void templeteMethod(){
		concreteMethod();
		hookMethod();
		abstractMethod();
	}
	/**
	 * 必填项
	 */
	private final void concreteMethod(){
		System.out.println("AbstractTemplete concreteMethod......");
	}
	/**
	 * 可选项：又叫钩子方法
	 */
	protected void hookMethod(){
		System.out.println("AbstractTemplete hookMethod......");
	}
	/**
	 * 自由发挥项
	 */
	protected abstract void abstractMethod();
}
