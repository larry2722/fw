/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月27日 上午10:39:21
 */
package com.aicent.rcc2.backend.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.aicent.rcc2.backend.entity.common.Usage;

@Entity
@Table(name = "rcc_subscriber_detail_usage")
public class SubscriberDetailUsage extends Usage {

	private static final long serialVersionUID = 7642090349190215544L;
	
}
