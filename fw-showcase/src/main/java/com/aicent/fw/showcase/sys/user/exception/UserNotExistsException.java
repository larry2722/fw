/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月23日 下午11:13:12
 */
package com.aicent.fw.showcase.sys.user.exception;

import com.aicent.fw.modules.message.ResponseStatus;

public class UserNotExistsException extends UserException {

	private static final long serialVersionUID = -4423614117346799958L;

	protected void setDefaultStatus() {
		this.status = ResponseStatus.USER_NOT_EXISTS_EXCEPTION;
	}
}
