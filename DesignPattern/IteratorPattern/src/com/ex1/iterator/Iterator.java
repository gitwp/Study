package com.ex1.iterator;

public interface Iterator<E> {
	/**
	 * 移动游标到第一个元素
	 */
	public void first();
	/**
	 * 移动游标到下一个元素
	 */
	public void next();
	/**
	 * 判断是否为最后一个元素
	 * @return
	 */
	public boolean isDone();
	/**
	 * 返回当前游标指向的元素
	 * @return
	 */
	public E currentItem();
}
