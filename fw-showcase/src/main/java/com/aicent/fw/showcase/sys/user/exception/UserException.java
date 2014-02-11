/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月23日 下午11:13:32
 */
package com.aicent.fw.showcase.sys.user.exception;

import com.aicent.fw.modules.exception.BaseException;
import com.aicent.fw.modules.message.ResponseStatus;

public class UserException extends BaseException {
	
	private static final long serialVersionUID = -2367363855514523739L;

	protected void setDefaultStatus() {
		this.status = ResponseStatus.USER_EXCEPTION;
	}
	
}
