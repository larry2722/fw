/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月27日 上午11:18:01
 */
package com.aicent.rcc2.backend.repository.jpa;

import com.aicent.fw.common.repository.jpa.GenericDaoJpa;

import org.springframework.stereotype.Repository;

import com.aicent.rcc2.backend.entity.ReportHourlyUsage;
import com.aicent.rcc2.backend.repository.ReportHourlyUsageDao;

@Repository
public class ReportHourlyUsageDaoJpa extends GenericDaoJpa<ReportHourlyUsage, Long> implements ReportHourlyUsageDao {

	@Override
	public void importHourlyUsageData(String usageTableName, String startTime, String endTime) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into " + usageTableName + " ");
		sql.append("(uplink,downlink,volume,timemark,imsi,apn,home_op,visited_op,app_id,package_id,http_url,app_group_flag,subscription_seq,rcc_customer_id)");
		sql.append("SELECT sum(a.uplink_usage) uplink, sum(a.downlink_usage) downlink,sum(a.volume_usage) volume, ");
		sql.append("UNIX_TIMESTAMP(left(from_unixtime(usage_e_time/1000),13)) ,a.imsi,a.apn,a.home_op,a.visited_op,a.app_id,a.package_id,a.http_url,a.app_group_flag,a.subscription_seq ,rcc_customer_id ");
		sql.append("from rcc_report_usage_temp a ");
		sql.append("where usage_e_time >= " + startTime + " and usage_e_time < " + endTime + " ");
		sql.append("group by UNIX_TIMESTAMP(left(from_unixtime(usage_e_time/1000),13)),a.imsi,a.apn,a.home_op,a.visited_op,a.app_id,a.package_id,a.http_url,a.app_group_flag,a.subscription_seq,rcc_customer_id ");
		sql.append("ON DUPLICATE KEY UPDATE  uplink = uplink+values(uplink), downlink = downlink+values(downlink),volume = volume+values(volume)");		
		getRepositoryHelper().createNativeQuery(sql.toString()).executeUpdate();
	}

}
