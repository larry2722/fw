/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月23日 下午11:13:32
 */
package org.larry.fw.showcase.sys.user.exception;

import org.larry.fw.module.exception.BaseException;
import org.larry.fw.module.message.ResponseStatus;

public class UserException extends BaseException {
	
	private static final long serialVersionUID = -2367363855514523739L;

	protected void setDefaultStatus() {
		this.status = ResponseStatus.USER_EXCEPTION;
	}
	
}
