/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月23日 下午11:22:15
 */
package com.aicent.fw.modules.exception;

import org.apache.commons.lang3.StringUtils;

import com.aicent.fw.modules.message.ResponseStatus;

public abstract class BaseException extends RuntimeException {

	private static final long serialVersionUID = -4431624903597385637L;
	
	protected ResponseStatus status;// = ResponseStatus.CONTINUE;
	
	public BaseException() {
	}

	public BaseException(ResponseStatus status) {
		this.status = status;
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(ResponseStatus status, String message) {
		super(message);
		this.status = status;
	}
	
	protected abstract void setDefaultStatus();

	@Override
	public String getMessage() {
		String message = this.status.getReason();
		if (StringUtils.isNotBlank(message)) {
			return message;
		} else {
			return super.getMessage();
		}
	}

}
