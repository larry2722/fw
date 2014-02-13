/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月27日 下午12:25:36
 */
package com.aicent.rcc2.backend.repository;

import java.util.List;

import com.aicent.fw.common.repository.GenericDao;
import com.aicent.rcc2.backend.entity.ReportUrl;

public interface ReportUrlDao extends GenericDao<ReportUrl, Long> {

	void addDomainColumn(String tableName);

	void replaseData(String reportUrlTableName, String usageTableName);

	void updateDomain(String reportUrlTableName,  ReportUrl reportUrl);

	List<ReportUrl> findByParseDomain(String reportUrlTableName);


}
