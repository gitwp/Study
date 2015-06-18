package com.ex1.context;

import com.ex1.state.State;

public class Context {
	//持有一个State类型的对象实例
    private State state;
    
    //可以动态改变环境类Context的属性State的内容
    public void setState(State state) {
        this.state = state;
    }
    /**
     * 用户感兴趣的接口方法
     */
    public void request(String sampleParameter) {
        //转调state来处理
        state.handle(sampleParameter);
    }
}
