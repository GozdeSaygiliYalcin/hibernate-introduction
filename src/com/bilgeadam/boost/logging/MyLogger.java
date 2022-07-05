package com.bilgeadam.boost.logging;

import java.util.logging.Logger;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MyLogger {
	
	private static MyLogger instance;
	private Logger myLogger; 
	//private org.apache.logging.log4j.Logger myLogger; //bu full qualified class name kullanımıdır. Loggerler karışmasın diye bu şekilde belirttik.
	
	public static MyLogger getInstance() {
		if(MyLogger.instance == null) {
			MyLogger.instance = new MyLogger();
		}
		return MyLogger.instance;
	}
	
	private Logger getLogger() {
		if(this.myLogger == null) {
			this.myLogger = Logger.getLogger("My Logger");
		}
		return this.myLogger;
	}
	
	public void debug(String msg) {
		this.getLogger().info(msg);
	}
	
	public void warn(String msg) {
		this.getLogger().warning(msg);
	}
}
