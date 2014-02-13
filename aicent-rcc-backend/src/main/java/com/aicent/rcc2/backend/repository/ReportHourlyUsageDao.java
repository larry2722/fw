/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月27日 上午11:17:44
 */
package com.aicent.rcc2.backend.repository;

import com.aicent.fw.common.repository.GenericDao;
import com.aicent.rcc2.backend.entity.ReportHourlyUsage;

public interface ReportHourlyUsageDao extends GenericDao<ReportHourlyUsage, Long> {

	void importHourlyUsageData(String usageTableName, String startTime, String endTime);

}
