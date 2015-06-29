package com.ex2.aggregate;

import com.ex2.iterator.Iterator;

public class ConcreteAggregate<E> extends Aggregate<E> {

	private E[] eArray = null;
	
	public ConcreteAggregate(E[] eArray) {
		super();
		this.eArray = eArray;
	}

	@Override
	public Iterator<E> createIterator() {
		return new ConcreteIterator<E>();
	}
	
	private class ConcreteIterator<E> implements Iterator<E> {

		private int index=0;
		private int size=0;
		
		@SuppressWarnings("unused")
		public ConcreteIterator() {
			this.index = 0;
			this.size = eArray.length;
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
			return (E) eArray[index];
		}

	}

}
