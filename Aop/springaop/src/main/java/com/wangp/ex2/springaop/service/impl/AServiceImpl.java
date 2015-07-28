package com.wangp.ex2.springaop.service.impl;

import org.springframework.stereotype.Component;

import com.wangp.ex2.springaop.service.AService;

public class AServiceImpl implements AService{

	public void fooA(String _msg) {
		 System.out.println("AServiceImpl.barA()(msg:"+_msg+")");  
		
	}

	public void barA() {
		 System.out.println("AServiceImpl.barA()");  
		
	}

}
