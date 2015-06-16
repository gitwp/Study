package com.ex2.subscribe;

import com.ex2.publish.ConcreteSubject;
import com.ex2.publish.Subject;

public class ConcreteObserver implements Observer {

	@Override
	public void update(Subject subject) {
		ConcreteSubject cs = (ConcreteSubject)subject;
		System.out.println(cs.getState());
	}

}
