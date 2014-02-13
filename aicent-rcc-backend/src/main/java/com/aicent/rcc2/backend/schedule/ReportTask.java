/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC admin portal
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月26日 下午2:22:05
 */
package com.aicent.rcc2.backend.schedule;

import com.aicent.fw.common.schedule.BaseTask;
import com.aicent.fw.modules.logger.Logger;
import com.aicent.fw.modules.logger.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aicent.rcc2.backend.service.TaskService;

@Component
public class ReportTask extends BaseTask {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TaskService globalTaskService;
	
	@Override
	protected void execute() {
		logger.debug("execute reportProcess.");
		globalTaskService.reportProcess();
	}

}
