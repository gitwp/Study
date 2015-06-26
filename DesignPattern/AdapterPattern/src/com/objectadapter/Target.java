package com.objectadapter;

public interface Target {
	/**
	 * 源接口
	 * @return
	 */
	String adapteeMethod();
	/**
	 * 目标接口
	 * @return
	 */
	String targetMethod();
}
