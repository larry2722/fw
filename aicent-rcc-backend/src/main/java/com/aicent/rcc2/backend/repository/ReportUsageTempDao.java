/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月27日 上午11:15:21
 */
package com.aicent.rcc2.backend.repository;

import java.util.List;

import com.aicent.fw.common.repository.GenericDao;
import com.aicent.rcc2.backend.dto.DailyReport;
import com.aicent.rcc2.backend.entity.ReportUsageTemp;

public interface ReportUsageTempDao extends GenericDao<ReportUsageTemp, Long> {

	int removeAll();

	int replaseData(String tableName, Long maxCdrId);

	List<DailyReport> getDailyReport();

}
