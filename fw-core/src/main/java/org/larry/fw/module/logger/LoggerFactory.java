/**  
 * Filename:    LoggerFactory.java
 * Description: LoggerFactory.java Action  
 * Copyright:   Copyright (c)2013 
 * Company:     Aicent RIS.WiFi Portal
 * @author:     Larry.Li  
 * @version:    v1.0.0  
 * Create by:   Larry.Li
 * Create Date: 2013年12月4日 下午2:30:43
 *  
 * Modification History:  
 * **************************************************************************************
 * Date         	Author      		Version     		Description   				*
 * -------------------------------------------------------------------------------------*	
 *																						*
 * **************************************************************************************
 */
package org.larry.fw.module.logger;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.aicent.wifi.riswifi.module.logger.slf4j.LogbackLoggerAdapter;

public class LoggerFactory {

	private static volatile LoggerAdapter LOGGER_ADAPTER;
	
	private static final ConcurrentMap<String, FWLogger> LOGGERS = new ConcurrentHashMap<String, FWLogger>();
	
	static {
		setAdapter(new LogbackLoggerAdapter());
	}
	
	private LoggerFactory() {
		
	}
	
	private static void setAdapter(LoggerAdapter adapter) {
		if (adapter != null) {
			Logger logger = adapter.getLogger(LoggerFactory.class);
			logger.info("using logger: " + adapter.getClass().getName());
			LoggerFactory.LOGGER_ADAPTER = adapter;
			for (Map.Entry<String, FWLogger> entry : LOGGERS.entrySet()) {
				entry.getValue().setLogger(LOGGER_ADAPTER.getLogger(entry.getKey()));
			}
		}
	}
	
	public static Logger getLogger(Class<?> clazz) {
		return getLogger(clazz.getName());
	}
	
	public static Logger getLogger(String name) {
		FWLogger logger = LOGGERS.get(name);
		if (logger == null) {
			LOGGERS.putIfAbsent(name, new FWLogger(LOGGER_ADAPTER.getLogger(name)));
			logger = LOGGERS.get(name);
		}
		return logger;
	}

	public static Logger getLogger(LoggerPath loggerPath) {
		return getLogger(loggerPath.name());
	}
	
	public static void setLevel(Level level) {
		LOGGER_ADAPTER.setLevel(level);
	}
	
	public static Level getLevel() {
		Level level = LOGGER_ADAPTER.getLevel();
		if (null == level) {
			setLevel(Level.ERROR);
		}
		return LOGGER_ADAPTER.getLevel();
	}
	
	public static File getFile() {
		return LOGGER_ADAPTER.getFile();
	}
}
