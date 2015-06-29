package com.ex1.aggregate;

import com.ex1.iterator.ConcreteIterator;
import com.ex1.iterator.Iterator;

public class ConcreteAggregate<E> extends Aggregate<E> {

	private E[] eArray = null;
	
	
	public ConcreteAggregate(E[] eArray) {
		super();
		this.eArray = eArray;
	}


	@Override
	public Iterator<E> createIterator() {
		return new ConcreteIterator<E>(this);
	}
	/**
	 * 对外接口：取值接口
	 * @param index
	 * @return
	 */
	public E getElement(int index){
		if(index<eArray.length){
			return eArray[index];
		}else{
			return null;
		}
	}
	/**
	 * 对外接口：聚集对象大小
	 * @return
	 */
	public int size(){
		return eArray.length;
	}

}
