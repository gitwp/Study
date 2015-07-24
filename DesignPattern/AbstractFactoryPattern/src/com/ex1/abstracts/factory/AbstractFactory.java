package com.ex1.abstracts.factory;

import com.ex1.product.Cpu;
import com.ex1.product.Mainboard;

public interface AbstractFactory {
	/**
     * 创建CPU对象
     * @return CPU对象
     */
    public Cpu createCpu();
    /**
     * 创建主板对象
     * @return 主板对象
     */
    public Mainboard createMainboard();
}
