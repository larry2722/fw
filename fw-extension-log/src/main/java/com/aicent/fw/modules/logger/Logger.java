/**  
 * Filename:    Logger.java
 * Description: Logger.java Action  
 * Copyright:   Copyright (c)2013 
 * Company:     Aicent RIS.WiFi Portal
 * @author:     Larry.Li  
 * @version:    v1.0.0  
 * Create by:   Larry.Li
 * Create Date: 2013年12月4日 下午2:08:45
 *  
 * Modification History:  
 * **************************************************************************************
 * Date         	Author      		Version     		Description   				*
 * -------------------------------------------------------------------------------------*	
 *																						*
 * **************************************************************************************
 */
package com.aicent.fw.modules.logger;

public interface Logger {
	
	void trace(String msg);

	void trace(Throwable e);

	void trace(String msg, Throwable e);

	void debug(String msg);

	void debug(Throwable e);

	void debug(String msg, Throwable e);
	
	void debug(String format, Object arg);
	
	void debug(String format, Object...arguments);

	void info(String msg);

	void info(Throwable e);

	void info(String msg, Throwable e);
	
	void info(String format, Object arg);
	
	void info(String format, Object...arguments);

	void warn(String msg);

	void warn(Throwable e);

	void warn(String msg, Throwable e);
	
	void warn(String format, Object arg);
	
	void warn(String format, Object...arguments);	

	void error(String msg);

	void error(Throwable e);

	void error(String msg, Throwable e);
	
	void error(String format, Object arg);
	
	void error(String format, Object...arguments);

	boolean isTraceEnabled();

	boolean isDebugEnabled();

	boolean isInfoEnabled();

	boolean isWarnEnabled();

	boolean isErrorEnabled();

}
