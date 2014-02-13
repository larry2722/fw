/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月27日 上午11:18:59
 */
package com.aicent.rcc2.backend.repository.jpa;

import java.math.BigInteger;

import javax.persistence.Query;

import com.aicent.fw.common.repository.jpa.GenericDaoJpa;

import org.springframework.stereotype.Repository;

import com.aicent.rcc2.backend.entity.SubscriberDetailUsage;
import com.aicent.rcc2.backend.repository.SubscriberDetailUsageDao;

@Repository
public class SubscriberDetailUsageDaoJpa extends GenericDaoJpa<SubscriberDetailUsage, Long> implements SubscriberDetailUsageDao {

	@Override
	public long getMaxId(String tableName) {
		Query query = getRepositoryHelper().createNativeQuery("select max(id) from " + tableName);
		BigInteger maxId = (BigInteger) query.getSingleResult();
		return maxId != null ? maxId.longValue() : 0;
	}

}
