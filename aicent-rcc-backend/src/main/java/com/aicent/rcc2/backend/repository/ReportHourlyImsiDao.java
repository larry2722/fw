/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月27日 上午11:16:43
 */
package com.aicent.rcc2.backend.repository;

import com.aicent.fw.common.repository.GenericDao;
import com.aicent.rcc2.backend.entity.ReportHourlyImsi;

public interface ReportHourlyImsiDao extends GenericDao<ReportHourlyImsi, Long> {

	void importHourlyImsiData(String usageTableName, String imsiTableName);

}
