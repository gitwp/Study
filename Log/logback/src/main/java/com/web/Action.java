package com.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.service.Service;

public class Action {
	private static Logger logger = LoggerFactory.getLogger(Action.class);
	
	public void execute(){
		logger.info("Action excute 开始..");
		Service service = new Service();
		service.execute();
		logger.info("Action excute end..");
	}
}
