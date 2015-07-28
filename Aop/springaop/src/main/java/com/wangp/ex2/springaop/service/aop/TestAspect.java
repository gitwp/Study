package com.wangp.ex2.springaop.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
	//定义切入点  
    @Pointcut("execution(* com.wangp.ex2.springaop.service.impl.*.*(..))")  
    public void allMethod(){}  
    
	@Before("allMethod()")  
	public void doBefore(JoinPoint jp) {
		System.out.println("aop:before: "
				+ jp.getTarget().getClass().getName() + "."
				+ jp.getSignature().getName());
	}
	
	@After("allMethod()")  
	public void doAfter(JoinPoint jp) {
		System.out.println("aop:after: "
				+ jp.getTarget().getClass().getName() + "."
				+ jp.getSignature().getName());
	}
	
	@AfterReturning("allMethod()")  
	public void doAfterReturning(JoinPoint jp) {
		System.out.println("aop:after-returning: "
				+ jp.getTarget().getClass().getName() + "."
				+ jp.getSignature().getName());
	}

	@Around("allMethod()")  
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		long time = System.currentTimeMillis();
		Object retVal = pjp.proceed();
		time = System.currentTimeMillis() - time;
		System.out.println("aop:around: " + time + " ms");
		return retVal;
	}
	
	@AfterThrowing(pointcut="allMethod()",throwing="ex")  
	public void doThrowing(JoinPoint jp, Throwable ex) {
		System.out.println("aop:after-throwing");
		System.out.println("method " + jp.getTarget().getClass().getName()
				+ "." + jp.getSignature().getName() + " throw exception");
		System.out.println(ex.getMessage());
	}
}
