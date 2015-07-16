package com.ex1.vistor;

import com.ex1.node.NodeA;
import com.ex1.node.NodeB;

public class VisitorB implements Visitor {

	/**
     * 对应于NodeA的访问操作
     */
    @Override
    public void visit(NodeA node) {
        System.out.println("VisitorB: "+node.operationA());
    }
    /**
     * 对应于NodeB的访问操作
     */
    @Override
    public void visit(NodeB node) {
        System.out.println("VisitorB: "+node.operationB());
    }

}
