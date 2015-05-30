package com.wangp.server;

import javax.xml.ws.Endpoint;

import com.wangp.ws.service.impl.MyService1Impl;

public class MyWebServiceServer {

	public static void main(String[] args) {
		String address = "http://localhost:8908/ws";
		
		Endpoint.publish(address,new MyService1Impl()); 
		
		System.out.println("web service start.......");
	}
}
