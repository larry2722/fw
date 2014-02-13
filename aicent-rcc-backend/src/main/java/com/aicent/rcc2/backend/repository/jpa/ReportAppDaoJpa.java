/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月28日 下午5:03:24
 */
package com.aicent.rcc2.backend.repository.jpa;

import com.aicent.fw.common.repository.jpa.GenericDaoJpa;

import org.springframework.stereotype.Repository;

import com.aicent.rcc2.backend.entity.ReportApp;
import com.aicent.rcc2.backend.repository.ReportAppDao;

@Repository
public class ReportAppDaoJpa extends GenericDaoJpa<ReportApp, Long> implements ReportAppDao {

	@Override
	public void replaseData(String reportAppTableName, String hourlyUsageTableName) {
		StringBuffer sql = new StringBuffer();
		sql.append("replace into " + reportAppTableName + " (app_id,rcc_customer_id,report_type,uplink,downlink,volume,roamer,timemark) ");
		sql.append("SELECT a.app_id,a.rcc_customer_id,1,sum(a.uplink),sum(a.downlink),sum(a.volume),count(Distinct imsi), UNIX_TIMESTAMP(left(from_unixtime(timemark),10)) ");
		sql.append("from "+ hourlyUsageTableName +" a where app_group_flag = 1 group by a.app_id,a.rcc_customer_id");
		getRepositoryHelper().createNativeQuery(sql.toString()).executeUpdate();
	}

}
