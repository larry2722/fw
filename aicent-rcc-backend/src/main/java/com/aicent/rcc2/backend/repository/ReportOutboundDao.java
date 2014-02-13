/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年2月10日 下午2:45:46
 */
package com.aicent.rcc2.backend.repository;

import com.aicent.fw.common.repository.GenericDao;
import com.aicent.rcc2.backend.entity.ReportOutbound;

public interface ReportOutboundDao extends GenericDao<ReportOutbound, Long>  {

	void replaseData(String reportOutboundTableName, String usageTableName);

}
