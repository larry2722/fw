/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月28日 下午5:02:36
 */
package com.aicent.rcc2.backend.repository;

import com.aicent.fw.common.repository.GenericDao;
import com.aicent.rcc2.backend.entity.ReportApp;

public interface ReportAppDao extends GenericDao<ReportApp, Long> {

	void replaseData(String reportAppTableName, String hourlyUsageTableName);

}
