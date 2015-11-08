package com.ex1;

import java.util.concurrent.atomic.AtomicReference;

public class LinkedQueue<E> {

	private static class Node<E>{
		final E item;
		final AtomicReference<Node<E>> next;
		Node(E item, Node<E> next){
			this.item = item;
			this.next = new AtomicReference<Node<E>>(next);
		}
	}
	
	private AtomicReference<Node<E>> head = new AtomicReference<LinkedQueue.Node<E>>(new Node<E>(null,null));
	private AtomicReference<Node<E>> tail = head;
	
	/**
	 * 插入一个元素涉及两个指针更新，这两个更新都是通过 CAS 进行的：
	 * 从队列当前的最后节点（C）链接到新节点，并把尾指针移动到新的最后一个节点（D）。
	 * 如果第一步失败，那么队列的状态不变，插入线程会继续重试，直到成功。
	 * 一旦操作成功，插入被当成生效，其他线程就可以看到修改。
	 * 
	 * ※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※
	 * 还需要把尾指针移动到新节点的位置上，但是这项工作可以看成是 “清理工作”，	    ※
	 * 因为任何处在这种情况下的线程都可以判断出是否需要这种清理，也知道如何进行清理。※
	 * ※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※
	 * @param item
	 * @return
	 */
	public boolean put(E item){
		Node<E> newNode = new Node<E>(item, null);
		while(true){
			Node<E> curTail = tail.get();
			Node<E> residue = curTail.next.get();
			if(curTail == tail.get()){
				if(residue == null)/* A */{
					if(curTail.next.compareAndSet(null, newNode))/* C */{
						tail.compareAndSet(curTail, newNode)/* D */;
						return true;
					}
				}else{
					tail.compareAndSet(curTail, residue) /* B */;
				}
			}
		}
	}
}
