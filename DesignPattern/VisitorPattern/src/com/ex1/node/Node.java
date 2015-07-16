package com.ex1.node;

import com.ex1.vistor.Visitor;

public abstract class Node {
	/**
     * 接受操作
     */
    public abstract void accept(Visitor visitor);
}
