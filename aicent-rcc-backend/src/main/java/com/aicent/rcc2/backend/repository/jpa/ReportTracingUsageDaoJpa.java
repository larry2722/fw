/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC admin portal
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月26日 下午4:26:03
 */
package com.aicent.rcc2.backend.repository.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import com.aicent.fw.common.repository.jpa.GenericDaoJpa;

import org.springframework.stereotype.Repository;

import com.aicent.rcc2.backend.entity.ReportTracingUsage;
import com.aicent.rcc2.backend.repository.ReportTracingUsageDao;

@Repository
public class ReportTracingUsageDaoJpa extends GenericDaoJpa<ReportTracingUsage, Long> implements ReportTracingUsageDao {

	@Override
	public ReportTracingUsage getByTableName(String tableName) {
		TypedQuery<ReportTracingUsage> query = getRepositoryHelper().createQuery("from ReportTracingUsage r where r.tableName = :tableName", ReportTracingUsage.class);
		query.setParameter("tableName", tableName);
		List<ReportTracingUsage> traceUsages = query.getResultList();
		return (traceUsages != null && traceUsages.size() > 0) ? traceUsages.get(0) : null;
	}

}
