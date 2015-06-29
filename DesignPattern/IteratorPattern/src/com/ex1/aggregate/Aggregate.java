package com.ex1.aggregate;

import com.ex1.iterator.Iterator;

public abstract class Aggregate<E> {

	public abstract Iterator<E> createIterator();
}
