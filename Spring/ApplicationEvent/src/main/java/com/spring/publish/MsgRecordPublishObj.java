package com.spring.publish;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.spring.client.events.MsgRecordEvent;

@Component
public class MsgRecordPublishObj implements ApplicationContextAware {

	private ApplicationContext ctx;
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		this.ctx=ctx;
	}

	public void msgRecordPublish(String msg){
		System.out.println("msg record publish");
		MsgRecordEvent mre = new MsgRecordEvent(this.ctx,msg);
		//向容器中所有的监听器发送事件
		ctx.publishEvent(mre);
	}
}
