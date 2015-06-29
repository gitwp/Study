package com.ex1.iterator;

import com.ex1.aggregate.ConcreteAggregate;

public class ConcreteIterator<E> implements Iterator<E> {

	private ConcreteAggregate<E> agg;
	private int index=0;
	private int size=0;
	
	public ConcreteIterator(ConcreteAggregate<E> agg) {
		super();
		this.agg = agg;
		this.index = 0;
		this.size = agg.size();
	}

	@Override
	public void first() {
		index=0;
	}

	@Override
	public void next() {
		if(index<size){
			index++;
		}
	}

	@Override
	public boolean isDone() {
		return (index >= size);
	}

	@Override
	public E currentItem() {
		return agg.getElement(index);
	}

}
