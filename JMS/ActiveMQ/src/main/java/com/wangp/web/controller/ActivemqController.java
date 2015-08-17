package com.wangp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangp.mq.producer.queue.QueueSender;
import com.wangp.mq.producer.topic.TopicSender;

@Controller
@RequestMapping("/activemq")
public class ActivemqController {
	
	@Autowired 
	QueueSender queueSender;
	@Autowired
	TopicSender topicSender;
	
	/**
	 * 发送消息到队列
	 * @param message
	 * @return String
	 */
	@ResponseBody
	@RequestMapping("queueSender")
	public String queueSender(@RequestParam("message")String message){
		String opt="";
		try {
			queueSender.send("test.queue", message);
			opt="suc";
		} catch (Exception e) {
			opt=e.getCause().toString();
		}
		return opt;
	}
	
	/**
	 * 发送消息到主题
	 * @param message
	 * @return String
	 */
	@ResponseBody
	@RequestMapping("topicSender")
	public String topicSender(@RequestParam("message")String message){
		String opt="";
		try {
			topicSender.send("test.topic", message);
			opt="suc";
		} catch (Exception e) {
			opt=e.getCause().toString();
		}
		return opt;
	}
	
}
