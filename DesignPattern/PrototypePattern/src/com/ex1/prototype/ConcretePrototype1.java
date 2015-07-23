package com.ex1.prototype;

public class ConcretePrototype1 implements Prototype {

	private String name;

	/**
	 * 深度克隆方法，这个例子中只有一个String类型的属性，深度克隆实现比较简单
	 */
	public Prototype clone() {
		ConcretePrototype1 prototype = new ConcretePrototype1();
		prototype.setName(this.name);
		return prototype;
	}

	public String toString() {
		return "Now in Prototype1 , name = " + this.name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
