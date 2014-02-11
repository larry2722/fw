/**  
 * Filename:    LoggerAdapter.java
 * Description: LoggerAdapter.java Action  
 * Copyright:   Copyright (c)2013 
 * Company:     Aicent RIS.WiFi Portal
 * @author:     Larry.Li  
 * @version:    v1.0.0  
 * Create by:   Larry.Li
 * Create Date: 2013年12月4日 下午2:00:40
 *  
 * Modification History:  
 * **************************************************************************************
 * Date         	Author      		Version     		Description   				*
 * -------------------------------------------------------------------------------------*	
 *																						*
 * **************************************************************************************
 */
package com.aicent.fw.modules.logger;

import java.io.File;

public interface LoggerAdapter {

	Logger getLogger(Class<?> clazz);
	
	Logger getLogger(String name);
	
	void setLevel(Level level);
	
	Level getLevel();
	
	File getFile();
	
	void setFile(File file);
}
