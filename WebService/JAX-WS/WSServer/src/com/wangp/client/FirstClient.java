package com.wangp.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.wangp.ws.service.IMyService1;

public class FirstClient {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:8908/ws?wsdl");
		QName qname = new QName("http://impl.service.ws.wangp.com/","MyService1ImpleService");
		
		Service service = Service.create(url, qname);
		
		IMyService1 im1 = service.getPort(IMyService1.class);
		
		System.out.println(im1.add(111, 99));
	}

}
