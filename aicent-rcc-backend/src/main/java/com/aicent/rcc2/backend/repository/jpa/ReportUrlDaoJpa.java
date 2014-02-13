/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月27日 下午12:26:15
 */
package com.aicent.rcc2.backend.repository.jpa;

import java.util.List;

import com.aicent.fw.common.repository.jpa.GenericDaoJpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aicent.rcc2.backend.entity.ReportUrl;
import com.aicent.rcc2.backend.repository.ReportUrlDao;

@Repository
public class ReportUrlDaoJpa extends GenericDaoJpa<ReportUrl, Long> implements ReportUrlDao {

	@Override
	public void addDomainColumn(String tableName) {
		getRepositoryHelper().createNativeQuery("ALTER TABLE " + tableName + " ADD COLUMN domain VARCHAR(255), ADD INDEX domain_index(domain)").executeUpdate();
	}

	@Override
	public void replaseData(String reportUrlTableName, String usageTableName) {
		StringBuffer sql = new StringBuffer();
		sql.append("replace into " + reportUrlTableName + " (url,rcc_customer_id,report_type,uplink,downlink,volume,roamer,timemark) ");
		sql.append("SELECT a.http_url,a.rcc_customer_id,1,sum(a.uplink),sum(a.downlink),sum(a.volume),count(imsi), UNIX_TIMESTAMP(left(from_unixtime(timemark),10)) ");
		sql.append("from "+usageTableName+" a group by a.http_url,a.rcc_customer_id ");
		getRepositoryHelper().createNativeQuery(sql.toString()).executeUpdate();
	}

	@Override
	public synchronized void updateDomain(String reportUrlTableName, ReportUrl reportUrl) {
		getRepositoryHelper().createNativeQuery("update " + reportUrlTableName + " set domain = '" + reportUrl.getDomain() + "' where id = " + reportUrl.getId()).executeUpdate();
	}

	@Override
	public List<ReportUrl> findByParseDomain(String reportUrlTableName) {
		return getRepositoryHelper().createNativeQuery("select * from " + reportUrlTableName + " where (domain is null || domain = '' || domain = 'null') and (url is not null && url != '' && url != 'null')", ReportUrl.class).getResultList();
	}

}
