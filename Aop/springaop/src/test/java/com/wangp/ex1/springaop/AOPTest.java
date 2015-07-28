package com.wangp.ex1.springaop;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.wangp.ex1.springaop.service.AService;
import com.wangp.ex1.springaop.service.impl.BServiceImpl;

public class AOPTest extends AbstractDependencyInjectionSpringContextTests {

	private AService aService;

	private BServiceImpl bService;

	protected String[] getConfigLocations() {
		String[] configs = new String[] { "classpath*:applicationContext.xml" };
		return configs;
	}

	/**
	 * 测试正常调用
	 */
	public void testCall() {
		System.out.println("SpringTest JUnit test");
		// aService.barA();
		// bService.fooB();
		// bService.barB("JUnit test barB",0);
	}

	/**
	 * 测试After-Throwing
	 */
	public void testThrow() {
		try {
			bService.barB("JUnit call barB", 1);
		} catch (IllegalArgumentException e) {

		}
	}

	public void setAService(AService service) {
		aService = service;
	}

	public void setBService(BServiceImpl service) {
		bService = service;
	}
}
