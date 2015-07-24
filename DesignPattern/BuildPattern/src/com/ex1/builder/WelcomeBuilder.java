package com.ex1.builder;

import com.ex1.product.WelcomeMessage;

public class WelcomeBuilder extends Builder {

	public WelcomeBuilder() {
		msg = new WelcomeMessage();
	}

	@Override
    public void buildBody() {
		msg.setBody("欢迎内容");
    }

	@Override
    public void buildSubject() {
		msg.setSubject("欢迎标题");
    }
}
