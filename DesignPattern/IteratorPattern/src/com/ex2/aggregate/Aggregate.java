package com.ex2.aggregate;

import com.ex2.iterator.Iterator;

public abstract class Aggregate<E> {

	public abstract Iterator<E> createIterator();
}
