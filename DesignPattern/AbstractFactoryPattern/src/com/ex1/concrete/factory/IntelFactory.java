package com.ex1.concrete.factory;

import com.ex1.abstracts.factory.AbstractFactory;
import com.ex1.product.Cpu;
import com.ex1.product.IntelCpu;
import com.ex1.product.IntelMainboard;
import com.ex1.product.Mainboard;

public class IntelFactory implements AbstractFactory {

    @Override
    public Cpu createCpu() {
        // TODO Auto-generated method stub
        return new IntelCpu(755);
    }

    @Override
    public Mainboard createMainboard() {
        // TODO Auto-generated method stub
        return new IntelMainboard(755);
    }

}
