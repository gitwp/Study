package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dao.Dao;
import com.proxy.Proxy;

public class Service {
private static Logger logger = LoggerFactory.getLogger(Service.class);
	
	public void execute(){
		logger.info("Service excute start..");
		Proxy proxy = new Proxy();
		Dao dao = new Dao();
		
		proxy.execute();
		dao.execute();
		
		logger.info("Service excute end..");
	}
}
