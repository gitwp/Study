package com.ex1.factory;

import com.ex1.product.ConcreteProductA;
import com.ex1.product.ConcreteProductB;
import com.ex1.product.ConcreteProductC;
import com.ex1.product.Product;
/**
 * 工厂类/静态工厂方法模式
 */
public class ProductFactory {
	 /** 
     * 静态工厂方法<br> 
     * 根据传进来的参数的产品类型来 生产/创建 真实的产品实体对象 
     * @param productType 产品类型 
     * @return 产品实体对象 
     */  
    public static Product createProduct(String productType){  
        Product product = null;  
          
        if ("A".equals(productType)) {  
            product = new ConcreteProductA();  
            System.out.println("工厂 创建了产品对象：ConcreteProductA");  
        } else if ("B".equals(productType)) {  
            product = new ConcreteProductB();  
            System.out.println("工厂 创建了产品对象：ConcreteProductB");  
        } else if ("C".equals(productType)) {  
            product = new ConcreteProductC();  
            System.out.println("工厂 创建了产品对象：ConcreteProductC");  
        } else {  
            throw new RuntimeException("产品类型不存在");  
        }  
          
        return product;  
    }  
}
