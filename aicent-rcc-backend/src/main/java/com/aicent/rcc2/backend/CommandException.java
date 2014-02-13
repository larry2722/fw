/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年2月13日 上午10:46:51
 */
package com.aicent.rcc2.backend;

import com.aicent.fw.modules.exception.BaseException;
import com.aicent.fw.modules.message.ResponseStatus;

public class CommandException extends BaseException {

	private static final long serialVersionUID = 3768354566626009339L;

	protected void setDefaultStatus() {
		this.status = ResponseStatus.AAAAA;
	}

}
