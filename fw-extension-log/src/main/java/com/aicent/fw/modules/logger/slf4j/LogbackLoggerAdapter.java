/**  
 * Filename:    Slf4jLoggerAdapter.java
 * Description: Slf4jLoggerAdapter.java Action  
 * Copyright:   Copyright (c)2013 
 * Company:     Aicent RIS.WiFi Portal
 * @author:     Larry.Li  
 * @version:    v1.0.0  
 * Create by:   Larry.Li
 * Create Date: 2013年12月4日 下午2:13:34
 *  
 * Modification History:  
 * **************************************************************************************
 * Date         	Author      		Version     		Description   				*
 * -------------------------------------------------------------------------------------*	
 *																						*
 * **************************************************************************************
 */
package com.aicent.fw.modules.logger.slf4j;

import java.io.File;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.aicent.fw.modules.logger.Level;
import com.aicent.fw.modules.logger.Logger;
import com.aicent.fw.modules.logger.LoggerAdapter;

import ch.qos.logback.classic.LoggerContext;

public class LogbackLoggerAdapter implements LoggerAdapter {

	private Level level;

	private File file;

	@Override
	public Logger getLogger(Class<?> clazz) {
		return new LogbackLogger(LoggerFactory.getLogger(clazz));
	}

	@Override
	public Logger getLogger(String name) {
		return new LogbackLogger(LoggerFactory.getLogger(name));
	}

	@Override
	public void setLevel(Level level) {
		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		List<ch.qos.logback.classic.Logger> loggers = context.getLoggerList();
		for (ch.qos.logback.classic.Logger l : loggers) {
			l.setLevel(toLogbackLevel(level));
		}
		this.level = level;
	}

	private ch.qos.logback.classic.Level toLogbackLevel(Level level) {
		if (null == level) 
			return ch.qos.logback.classic.Level.OFF;
		if (level == Level.ALL) 
			return ch.qos.logback.classic.Level.ALL;
		if (level == Level.TRACE) 
			return ch.qos.logback.classic.Level.TRACE;
		if (level == Level.DEBUG) 
			return ch.qos.logback.classic.Level.DEBUG;
		if (level == Level.INFO) 
			return ch.qos.logback.classic.Level.INFO;
		if (level == Level.WARN) 
			return ch.qos.logback.classic.Level.WARN;
		if (level == Level.ERROR) 
			return ch.qos.logback.classic.Level.ERROR;
		return ch.qos.logback.classic.Level.OFF;
	}
	
	private Level toRISLogger(ch.qos.logback.classic.Level level) {
		if (null == level) 
			return Level.OFF;
		if (level == ch.qos.logback.classic.Level.ALL)
			return Level.ALL;
		if (level == ch.qos.logback.classic.Level.TRACE)
			return Level.TRACE;
		if (level == ch.qos.logback.classic.Level.DEBUG)
			return Level.DEBUG;
		if (level == ch.qos.logback.classic.Level.INFO)
			return Level.INFO;
		if (level == ch.qos.logback.classic.Level.WARN)
			return Level.WARN;
		if (level == ch.qos.logback.classic.Level.ERROR)
			return Level.ERROR;
		return Level.OFF;
	}

	@Override
	public Level getLevel() {
		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		List<ch.qos.logback.classic.Logger> loggers = context.getLoggerList();
		for (ch.qos.logback.classic.Logger l : loggers) {
			ch.qos.logback.classic.Level level = l.getLevel();
			if (null != level) {
				return toRISLogger(level);
			}
		}
		return Level.ERROR;
	}

	@Override
	public File getFile() {
		return file;
	}

	@Override
	public void setFile(File file) {
		this.file = file;
	}

}
