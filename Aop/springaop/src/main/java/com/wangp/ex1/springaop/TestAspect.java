package com.wangp.ex1.springaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class TestAspect {
	public void doBefore(JoinPoint jp) {
		System.out.println("aop:before: "
				+ jp.getTarget().getClass().getName() + "."
				+ jp.getSignature().getName());
	}
	
	public void doAfter(JoinPoint jp) {
		System.out.println("aop:after: "
				+ jp.getTarget().getClass().getName() + "."
				+ jp.getSignature().getName());
	}
	public void doAfterReturning(JoinPoint jp) {
		System.out.println("aop:after-returning: "
				+ jp.getTarget().getClass().getName() + "."
				+ jp.getSignature().getName());
	}

	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		long time = System.currentTimeMillis();
		Object retVal = pjp.proceed();
		time = System.currentTimeMillis() - time;
		System.out.println("aop:around: " + time + " ms");
		return retVal;
	}
	
	public void doThrowing(JoinPoint jp, Throwable ex) {
		System.out.println("aop:after-throwing");
		System.out.println("method " + jp.getTarget().getClass().getName()
				+ "." + jp.getSignature().getName() + " throw exception");
		System.out.println(ex.getMessage());
	}
}
