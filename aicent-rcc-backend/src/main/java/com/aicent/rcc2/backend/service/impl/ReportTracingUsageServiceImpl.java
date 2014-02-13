/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月26日 下午6:19:10
 */
package com.aicent.rcc2.backend.service.impl;

import com.aicent.fw.common.service.impl.BaseServiceImpl;
import com.aicent.fw.modules.datasource.AvailableDataSources;
import com.aicent.fw.modules.datasource.DatasourceAccessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aicent.rcc2.backend.entity.ReportTracingUsage;
import com.aicent.rcc2.backend.repository.ReportTracingUsageDao;
import com.aicent.rcc2.backend.service.ReportTracingUsageService;

@Service
@DatasourceAccessType(AvailableDataSources.WAREHOUSE)
public class ReportTracingUsageServiceImpl extends BaseServiceImpl<ReportTracingUsage, Long> implements ReportTracingUsageService {

	@Autowired
	private ReportTracingUsageDao reportTracingUsageDao;
	
}
