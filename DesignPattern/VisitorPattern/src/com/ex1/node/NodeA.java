package com.ex1.node;

import com.ex1.vistor.Visitor;

public class NodeA extends Node {

	 /**
     * 接受操作
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    /**
     * NodeA特有的方法
     */
    public String operationA(){
        return "NodeA";
    }

}
