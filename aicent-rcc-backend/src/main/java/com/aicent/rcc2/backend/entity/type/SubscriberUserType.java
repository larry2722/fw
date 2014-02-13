/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月27日 上午10:32:46
 */
package com.aicent.rcc2.backend.entity.type;

public enum SubscriberUserType {

	WEB(1), SMS(2), Portal(3), Others(4);
	
	private Integer value;
	
	SubscriberUserType(Integer value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Integer value) {
		this.value = value;
	}
	
}
