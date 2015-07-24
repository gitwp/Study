package com.ex1.client;

import com.ex1.factory.ProductFactory;

public class Client {
	 public static void main(String[] args) {  
	        ProductFactory.createProduct("A");  
	        ProductFactory.createProduct("C");  
	        ProductFactory.createProduct("B");  
	        ProductFactory.createProduct("D");  
	    }  
}
