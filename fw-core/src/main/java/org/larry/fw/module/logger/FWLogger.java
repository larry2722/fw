/**  
 * Filename:    RISLogger.java
 * Description: RISLogger.java Action  
 * Copyright:   Copyright (c)2013 
 * Company:     Aicent RIS.WiFi Portal
 * @author:     Larry.Li  
 * @version:    v1.0.0  
 * Create by:   Larry.Li
 * Create Date: 2014年1月13日 下午1:25:25
 *  
 * Modification History:  
 * **************************************************************************************
 * Date         	Author      		Version     		Description   				*
 * -------------------------------------------------------------------------------------*	
 *																						*
 * **************************************************************************************
 */
package org.larry.fw.module.logger;

import org.larry.fw.module.utils.NetUtils;
import org.larry.fw.module.utils.Version;

public class FWLogger implements Logger {
	
	private Logger logger;
	
	public FWLogger(Logger logger) {
		this.logger = logger;
	}
	
	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	private String appendContextMessage(String msg) {
	    return " [RIS.Wi-Fi] " + LoggerFactory.getLevel().name() + " " + msg + ", ris.wifi version: " + Version.getVersion() + ", current host: " + NetUtils.getLogHost();
	}

	@Override
	public void trace(String msg) {
		try {
			logger.trace(appendContextMessage(msg));
		} catch (Throwable e) {
		}
	}

	@Override
	public void trace(Throwable e) {
		try {
			logger.trace(appendContextMessage(e.getMessage()), e);
		} catch (Throwable t) {
		}
	}

	@Override
	public void trace(String msg, Throwable e) {
		try {
			logger.trace(appendContextMessage(msg), e);
		} catch (Throwable t) {
		}
	}

	@Override
	public void debug(String msg) {
		try {
			logger.debug(appendContextMessage(msg));
		} catch (Throwable t) {
		}
	}

	@Override
	public void debug(Throwable e) {
		try {
			logger.debug(appendContextMessage(e.getMessage()), e);
		} catch (Throwable t) {
		}
	}

	@Override
	public void debug(String msg, Throwable e) {
		try {
			logger.debug(appendContextMessage(msg), e);
		} catch (Throwable t) {
		}
	}
	
	@Override
	public void debug(String format, Object arg) {
		try {
			logger.debug(appendContextMessage(format), arg);
		} catch (Throwable t) {
		}
	}

	@Override
	public void debug(String format, Object... arguments) {
		try {
			logger.debug(appendContextMessage(format), arguments);
		} catch (Throwable t) {
		}
	}

	@Override
	public void info(String msg) {
		try {
			logger.info(appendContextMessage(msg));
		} catch (Throwable t) {
		}
	}

	@Override
	public void info(Throwable e) {
		try {
			logger.info(appendContextMessage(e.getMessage()), e);
		} catch (Throwable t) {
		}
	}

	@Override
	public void info(String msg, Throwable e) {
		try {
			logger.info(appendContextMessage(msg), e);
		} catch (Throwable t) {
		}
	}
	
	@Override
	public void info(String format, Object arg) {
		try {
			logger.info(appendContextMessage(format), arg);
		} catch (Throwable t) {
		}
	}

	@Override
	public void info(String format, Object... arguments) {
		try {
			logger.info(appendContextMessage(format), arguments);
		} catch (Throwable t) {
		}
	}

	@Override
	public void warn(String msg) {
		try {
			logger.warn(appendContextMessage(msg));
		} catch (Throwable t) {
		}
	}

	@Override
	public void warn(Throwable e) {
		try {
			logger.warn(appendContextMessage(e.getMessage()), e);
		} catch (Throwable t) {
		}
	}

	@Override
	public void warn(String msg, Throwable e) {
		try {
			logger.warn(appendContextMessage(msg), e);
		} catch (Throwable t) {
		}
	}
	
	@Override
	public void warn(String format, Object arg) {
		try {
			logger.warn(appendContextMessage(format), arg);
		} catch (Throwable t) {
		}
	}

	@Override
	public void warn(String format, Object... arguments) {
		try {
			logger.warn(appendContextMessage(format), arguments);
		} catch (Throwable t) {
		}
	}

	@Override
	public void error(String msg) {
		try {
			logger.error(appendContextMessage(msg));
		} catch (Throwable t) {
		}
	}

	@Override
	public void error(Throwable e) {
		try {
			logger.error(appendContextMessage(e.getMessage()), e);
		} catch (Throwable t) {
		}
	}

	@Override
	public void error(String msg, Throwable e) {
		try {
			logger.error(appendContextMessage(msg), e);
		} catch (Throwable t) {
		}
	}
	
	@Override
	public void error(String format, Object arg) {
		try {
			logger.error(appendContextMessage(format), arg);
		} catch (Throwable t) {
		}
	}

	@Override
	public void error(String format, Object... arguments) {
		try {
			logger.error(appendContextMessage(format), arguments);
		} catch (Throwable t) {
		}
	}

	@Override
	public boolean isTraceEnabled() {
		try {
			return logger.isTraceEnabled();
		} catch (Throwable t) {
			return false;
		}
	}

	@Override
	public boolean isDebugEnabled() {
		try {
			return logger.isDebugEnabled();
		} catch (Throwable t) {
			return false;
		}
	}

	@Override
	public boolean isInfoEnabled() {
		try {
			return logger.isInfoEnabled();
		} catch (Throwable t) {
			return false;
		}
	}

	@Override
	public boolean isWarnEnabled() {
		try {
			return logger.isWarnEnabled();
		} catch (Throwable t) {
			return false;
		}
	}

	@Override
	public boolean isErrorEnabled() {
		try {
			return logger.isErrorEnabled();
		} catch (Throwable t) {
			return false;
		}
	}

}
