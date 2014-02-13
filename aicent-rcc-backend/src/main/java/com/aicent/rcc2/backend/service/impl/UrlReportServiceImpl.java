/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月27日 下午12:23:38
 */
package com.aicent.rcc2.backend.service.impl;

import com.aicent.fw.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aicent.rcc2.backend.entity.ReportUrl;
import com.aicent.rcc2.backend.repository.ReportUrlDao;
import com.aicent.rcc2.backend.service.UrlReportService;

@Service
public class UrlReportServiceImpl extends BaseServiceImpl<ReportUrl, Long> implements UrlReportService {

	@Autowired
	private ReportUrlDao urlReportDao;
}
