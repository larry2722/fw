/**  
 * Filename:    LogbackLogger.java
 * Description: LogbackLogger.java Action  
 * Copyright:   Copyright (c)2013 
 * Company:     Aicent RIS.WiFi Portal
 * @author:     Larry.Li  
 * @version:    v1.0.0  
 * Create by:   Larry.Li
 * Create Date: 2013年12月4日 下午2:14:20
 *  
 * Modification History:  
 * **************************************************************************************
 * Date         	Author      		Version     		Description   				*
 * -------------------------------------------------------------------------------------*	
 *																						*
 * **************************************************************************************
 */
package org.larry.fw.module.logger.slf4j;

import java.io.Serializable;

import com.aicent.wifi.riswifi.module.logger.Logger;

public class LogbackLogger implements Logger, Serializable {

	private static final long serialVersionUID = -8828658012218099709L;

	private final org.slf4j.Logger logger;

	public LogbackLogger(org.slf4j.Logger logger) {
		this.logger = logger;
	}

	@Override
	public void trace(String msg) {
		logger.trace(msg);
	}

	@Override
	public void trace(Throwable e) {
		logger.trace(e.getMessage(), e);
	}

	@Override
	public void trace(String msg, Throwable e) {
		logger.trace(msg, e);
	}

	@Override
	public void debug(String msg) {
		logger.debug(msg);
	}

	@Override
	public void debug(Throwable e) {
		logger.debug(e.getMessage(), e);
	}

	@Override
	public void debug(String msg, Throwable e) {
		logger.debug(msg, e);
	}

	@Override
	public void info(String msg) {
		logger.info(msg);
	}

	@Override
	public void info(Throwable e) {
		logger.info(e.getMessage(), e);
	}

	@Override
	public void info(String msg, Throwable e) {
		logger.info(msg, e);
	}

	@Override
	public void warn(String msg) {
		logger.warn(msg);
	}

	@Override
	public void warn(Throwable e) {
		logger.warn(e.getMessage(), e);
	}

	@Override
	public void warn(String msg, Throwable e) {
		logger.warn(msg, e);
	}

	@Override
	public void error(String msg) {
		logger.error(msg);
	}

	@Override
	public void error(Throwable e) {
		logger.error(e.getMessage(), e);
	}

	@Override
	public void error(String msg, Throwable e) {
		logger.error(msg, e);
	}

	@Override
	public boolean isTraceEnabled() {
		return logger.isTraceEnabled();
	}

	@Override
	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

	@Override
	public boolean isInfoEnabled() {
		return logger.isInfoEnabled();
	}

	@Override
	public boolean isWarnEnabled() {
		return logger.isWarnEnabled();
	}

	@Override
	public boolean isErrorEnabled() {
		return logger.isErrorEnabled();
	}

}
