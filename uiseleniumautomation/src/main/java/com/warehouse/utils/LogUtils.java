package com.warehouse.utils;


import org.apache.logging.log4j.Logger;


import org.apache.logging.log4j.LogManager;

public class LogUtils {

	public static Logger log = (Logger) LogUtils.getLogger(LogUtils.class);
	public static Logger getLogger(Class<?> clazz) {
		return LogManager.getLogger();
	}
	
	public static void main(String[] args) {
		log.info("Software Testing");
		log.info("Software Testing");
		log.info("Software Testing");
		log.info("Software Testing");log.info("Software Testing");
		log.info("Software Testing");log.info("Software Testing");
	}
	
}
