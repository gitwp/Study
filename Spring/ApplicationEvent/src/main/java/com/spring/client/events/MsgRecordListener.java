package com.spring.client.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
@Component
public class MsgRecordListener implements ApplicationListener<MsgRecordEvent> {

	/**
	 * 事件处理逻辑
	 */
	public void onApplicationEvent(MsgRecordEvent event) {
		System.out.println("record meg:"+event.getMsg());
	}

}
