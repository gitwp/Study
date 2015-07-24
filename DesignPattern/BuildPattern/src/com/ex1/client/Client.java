package com.ex1.client;

import com.ex1.builder.Builder;
import com.ex1.builder.WelcomeBuilder;
import com.ex1.director.Director;

public class Client {
	public static void main(String[] args) {
		Builder builder = new WelcomeBuilder();
		Director director = new Director(builder);
		director.construct("toAddress@126.com", "fromAddress@126.com");
	}
}
