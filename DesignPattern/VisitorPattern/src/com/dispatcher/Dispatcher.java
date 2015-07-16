package com.dispatcher;

import com.dispatcher.beans.BlackHorse;
import com.dispatcher.beans.Horse;
import com.dispatcher.beans.WhiteHorse;

public class Dispatcher {
	public void ride(Horse h){
        System.out.println("骑马");
    }
    
    public void ride(WhiteHorse wh){
        System.out.println("骑白马");
    }
    
    public void ride(BlackHorse bh){
        System.out.println("骑黑马");
    }
    
    public static void main(String[] args) {
    	//静态分派(Static Dispatch)发生在编译时期，分派根据静态类型信息发生。方法重载就是静态分派。
    	//静态分派
        Horse wh = new WhiteHorse();
        Horse bh = new BlackHorse();
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.ride(wh);
        dispatcher.ride(bh);
        
        //动态分派(Dynamic Dispatch)发生在运行时期，动态分派动态地置换掉某个方法。
        //方法的重写、多态就是动态分派
        Horse h = new BlackHorse();
        h.eat();
    }
}
