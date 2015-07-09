package com.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.web.Action;

public class Proxy {
private static Logger logger = LoggerFactory.getLogger(Proxy.class);
	
	public void execute(){
		logger.info("Proxy excute start..");
		
		logger.info("Proxy excute end..");
	}
}
