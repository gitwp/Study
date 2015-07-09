package com.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dao {
private static Logger logger = LoggerFactory.getLogger(Dao.class);
	
	public void execute(){
		logger.info("Dao excute start..");
		
		logger.info("Dao excute end..");
	}
}
