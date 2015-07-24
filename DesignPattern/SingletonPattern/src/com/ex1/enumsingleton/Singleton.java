package com.ex1.enumsingleton;

public enum Singleton {
	 /**
     * 定义一个枚举的元素，它就代表了Singleton的一个实例。
     */
    INSTANCE;
    
    private Object field1;
    private Singleton(){
    	//在这里对单例对象进行初始化
    }
    /**
     * 单例可以有自己的操作
     */
    public void singletonOperation(){
    	
    }
}
