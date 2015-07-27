package com.ex1.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

	private Object object;

	// 绑定关系，也就是关联到哪个接口（与具体的实现类绑定）的哪些方法将被调用时，执行invoke方法。
	// Proxy.newProxyInstance的第三个参数是表明这些被拦截的方法执行时需要执行哪个InvocationHandler的invoke方法
	public Object bindRelation(Object object) {
		this.object = object;
		return Proxy.newProxyInstance(object.getClass().getClassLoader(),
				object.getClass().getInterfaces(), this);
	}

	// InvocationHandler.invoke拦截关联的这个实现类的方法被调用时将被执行
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("method start....");
		Object result = method.invoke(object, args);
		System.out.println("method end....");
		return result;
	}
}
