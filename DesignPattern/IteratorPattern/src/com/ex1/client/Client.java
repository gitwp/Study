package com.ex1.client;

import com.ex1.aggregate.Aggregate;
import com.ex1.aggregate.ConcreteAggregate;
import com.ex1.iterator.Iterator;

public class Client {
	
	public void operation(){
        Object[] objArray = {"One","Two","Three","Four","Five","Six"};
        //创建聚合对象
        Aggregate<Object> agg = new ConcreteAggregate<Object>(objArray);
        //循环输出聚合对象中的值
        Iterator<Object> it = agg.createIterator();
        while(!it.isDone()){
            System.out.println(it.currentItem());
            it.next();
        }
    }
	
    public static void main(String[] args) {
        
        Client client = new Client();
        client.operation();
    }
}
