package com.ex3.subscribe;

import com.ex3.publish.Observable;

public interface Observer {
	void update(Observable o, Object arg);
}
