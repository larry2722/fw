/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月28日 下午5:40:57
 */
package com.aicent.rcc2.backend.repository;

import com.aicent.fw.common.repository.GenericDao;
import com.aicent.rcc2.backend.entity.ReportAppGroup;

public interface ReportAppGroupDao extends GenericDao<ReportAppGroup, Long> {

	void replaseData(String reportAppGroupTableName, String usageTableName);

}
