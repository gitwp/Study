package com.spring.client.events;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * 事件对象
 */
public class MsgRecordEvent extends ApplicationContextEvent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg;
	public MsgRecordEvent(ApplicationContext source,String msg) {
		super(source);
		this.msg=msg;
	}
	public String getMsg() {
		return msg;
	}

	
}
