/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月27日 上午11:18:40
 */
package com.aicent.rcc2.backend.repository;

import com.aicent.fw.common.repository.GenericDao;
import com.aicent.rcc2.backend.entity.SubscriberDetailUsage;

public interface SubscriberDetailUsageDao extends GenericDao<SubscriberDetailUsage, Long> {

	long getMaxId(String tableName);

}
