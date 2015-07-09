package wangp.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.web.Action;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		
		Logger logger = LoggerFactory.getLogger(App.class);
		logger.info("App: start.");

		Action action = new Action();
		action.execute();

		logger.info("App: end.");
	}
}
