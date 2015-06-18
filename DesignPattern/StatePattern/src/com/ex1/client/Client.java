package com.ex1.client;

import com.ex1.context.Context;
import com.ex1.state.ConcreteStateA;
import com.ex1.state.ConcreteStateB;
import com.ex1.state.State;

public class Client {

	public static void main(String[] args) {
		// 创建状态,默认值
		State state = new ConcreteStateB();
		// 创建环境
		Context context = new Context();
		// 将状态设置到环境中
		context.setState(state);
		// 请求
		String requestParam = "A";
		if(requestParam.equals("A")){
			state = new ConcreteStateA();
		}
		context.request(requestParam);
	}

}
