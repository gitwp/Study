package com.ex1.vistor;

import com.ex1.node.NodeA;
import com.ex1.node.NodeB;

public interface Visitor {
	 /**
     * 对应于NodeA的访问操作
     */
    public void visit(NodeA node);
    /**
     * 对应于NodeB的访问操作
     */
    public void visit(NodeB node);
}
