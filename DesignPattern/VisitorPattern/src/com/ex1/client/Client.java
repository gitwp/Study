package com.ex1.client;

import com.ex1.node.NodeA;
import com.ex1.node.NodeB;
import com.ex1.objectstructure.ObjectStructure;
import com.ex1.vistor.Visitor;
import com.ex1.vistor.VisitorA;
import com.ex1.vistor.VisitorB;

public class Client {
	 public static void main(String[] args) {
	        //创建一个结构对象
	        ObjectStructure os = new ObjectStructure();
	        //给结构增加一个节点
	        os.add(new NodeA());
	        //给结构增加一个节点
	        os.add(new NodeB());
	        //创建一个访问者
	        Visitor visitorA = new VisitorA();
	        os.action(visitorA);
	        Visitor visitorB = new VisitorB();
	        os.action(visitorB);
	    }
}
