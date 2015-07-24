package com.ex1.concrete.factory;

import com.ex1.abstracts.factory.AbstractFactory;
import com.ex1.product.Cpu;
import com.ex1.product.IntelCpu;
import com.ex1.product.IntelMainboard;
import com.ex1.product.Mainboard;

public class AmdFactory implements AbstractFactory {

    @Override
    public Cpu createCpu() {
        return new IntelCpu(938);
    }

    @Override
    public Mainboard createMainboard() {
        return new IntelMainboard(938);
    }

}