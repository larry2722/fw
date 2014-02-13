/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月28日 下午5:41:29
 */
package com.aicent.rcc2.backend.repository.jpa;

import com.aicent.fw.common.repository.jpa.GenericDaoJpa;

import org.springframework.stereotype.Repository;

import com.aicent.rcc2.backend.entity.ReportAppGroup;
import com.aicent.rcc2.backend.repository.ReportAppGroupDao;

@Repository
public class ReportAppGroupDaoJpa extends GenericDaoJpa<ReportAppGroup, Long> implements ReportAppGroupDao {

	@Override
	public void replaseData(String reportAppGroupTableName, String usageTableName) {
		StringBuffer sql = new StringBuffer();
		sql.append("replace into " + reportAppGroupTableName + " (app_group_id,rcc_customer_id,report_type,uplink,downlink,volume,roamer,timemark) ");
		sql.append("SELECT a.app_id,a.rcc_customer_id,1,sum(a.uplink),sum(a.downlink),sum(a.volume),count(Distinct imsi), UNIX_TIMESTAMP(left(from_unixtime(timemark),10)) ");
		sql.append("from "+usageTableName+" a where app_group_flag = 2 group by a.app_id,a.rcc_customer_id ");
		getRepositoryHelper().createNativeQuery(sql.toString()).executeUpdate();
	}

}
