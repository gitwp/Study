package com.ex2.client;

import com.ex2.caretaker.Caretaker;
import com.ex2.originator.Originator;

public class Client {
	public static void main(String[] args) {
		//黑箱实例
		Originator o = new Originator();
		
		//负责人对象可有可无、可以直接定义一个状态对象，而不通过负责人对象保存
		Caretaker c = new Caretaker();
		// 改变负责人对象的状态
		o.setState("On");
		// 创建备忘录对象，并将发起人对象的状态存储起来
		c.saveMemento(o.createMemento());
		// 修改发起人对象的状态
		o.setState("Off");
		// 恢复发起人对象的状态
		o.restoreMemento(c.retrieveMemento());
	}
}
