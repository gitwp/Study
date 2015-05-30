package com.wangp.client;

import java.net.MalformedURLException;

import com.wangp.ws.service.impl.IMyService1;
import com.wangp.ws.service.impl.MyService1ImplService;

public class FirstClient {

	public static void main(String[] args) throws MalformedURLException {
		//method1
//		URL url = new URL("http://localhost:8908/ws?wsdl");
//		QName qname = new QName("http://impl.service.ws.wangp.com/","MyService1ImplService");
//		Service service = Service.create(url, qname);
//		IMyService1 im1 = service.getPort(IMyService1.class);
		
		//method2
//		URL url = new URL("http://localhost:8908/ws?wsdl");
//		QName qname = new QName("http://impl.service.ws.wangp.com/","MyService1ImplService");
//		IMyService1 im1 =  new MyService1ImplService(url,qname).getMyService1ImplPort();

		//method3
		IMyService1 im1 =  new MyService1ImplService().getMyService1ImplPort();
		
		System.out.println(im1.add(111, 99));
		System.out.println(im1.getUserById(1).getName()+im1.getUserById(1).getPassword());
	}

}
