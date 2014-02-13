/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年2月10日 下午2:52:43
 */
package com.aicent.rcc2.backend.repository.jpa;

import org.springframework.stereotype.Repository;

import com.aicent.fw.common.repository.jpa.GenericDaoJpa;
import com.aicent.rcc2.backend.entity.ReportOutbound;
import com.aicent.rcc2.backend.repository.ReportOutboundDao;

@Repository
public class ReportOutboundDaoJpa extends GenericDaoJpa<ReportOutbound, Long> implements ReportOutboundDao {

	@Override
	public void replaseData(String reportOutboundTableName, String usageTableName) {
		StringBuffer sql = new StringBuffer();
		sql.append("replace into "+reportOutboundTableName+" (visited_op,rcc_customer_id,report_type, timemark, roamer,uplink,downlink,volume) ");
		sql.append("SELECT visited_op,a.rcc_customer_id,1,UNIX_TIMESTAMP(left(from_unixtime(timemark),10)), count(distinct imsi),sum(a.uplink),sum(a.downlink),sum(a.volume) ");
		sql.append("from "+usageTableName+" a group by a.visited_op,a.rcc_customer_id,UNIX_TIMESTAMP(left(from_unixtime(timemark),10))");
		getRepositoryHelper().createNativeQuery(sql.toString()).executeUpdate();
	}

}
