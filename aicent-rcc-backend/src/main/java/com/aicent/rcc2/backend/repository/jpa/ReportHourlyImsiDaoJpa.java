/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月27日 上午11:17:03
 */
package com.aicent.rcc2.backend.repository.jpa;

import com.aicent.fw.common.repository.jpa.GenericDaoJpa;

import org.springframework.stereotype.Repository;

import com.aicent.rcc2.backend.entity.ReportHourlyImsi;
import com.aicent.rcc2.backend.repository.ReportHourlyImsiDao;

@Repository
public class ReportHourlyImsiDaoJpa extends GenericDaoJpa<ReportHourlyImsi, Long> implements ReportHourlyImsiDao {

	@Override
	public void importHourlyImsiData(String usageTableName, String imsiTableName) {
		StringBuffer sql = new StringBuffer();
		sql.append("replace into " + imsiTableName + " (home_op,visited_op,imsi,timemark,subscription_seq,volume) ");
		sql.append("select home_op,visited_op,imsi,timemark,subscription_seq,sum(volume) from " + usageTableName + " ");
		sql.append("where subscription_seq>0 group by home_op,visited_op,imsi,timemark,subscription_seq");
		getRepositoryHelper().createNativeQuery(sql.toString()).executeUpdate();
	}

}
