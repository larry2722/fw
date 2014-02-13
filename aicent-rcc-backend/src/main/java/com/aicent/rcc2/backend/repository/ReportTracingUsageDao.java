/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC admin portal
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月26日 下午4:16:11
 */
package com.aicent.rcc2.backend.repository;

import com.aicent.fw.common.repository.GenericDao;
import com.aicent.rcc2.backend.entity.ReportTracingUsage;

public interface ReportTracingUsageDao extends GenericDao<ReportTracingUsage, Long> {

	ReportTracingUsage getByTableName(String tableName);

}
