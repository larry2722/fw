/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月28日 上午11:03:03
 */
package com.aicent.rcc2.backend.repository.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.aicent.fw.common.repository.RepositoryHelper;
import com.aicent.rcc2.backend.repository.SystemServiceDao;

@SuppressWarnings({"rawtypes", "unchecked"})
@Repository
public class SystemServiceDaoJpa implements SystemServiceDao {
	
	private RepositoryHelper repositoryHelper;
	
	@Override
	public List<String> findExistingTableName(String tableName) {
		Query query = repositoryHelper.createNativeQuery("show tables like '"+ tableName +"'");
		return query.getResultList();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		repositoryHelper = new RepositoryHelper();
	}

	@Override
	public void createTable(String tableName, String likeTableName) {
		repositoryHelper.createNativeQuery("create table if not exists " + tableName + " like " + likeTableName).executeUpdate();
	}

	@Override
	public boolean existsTable(String tableName) {
		List<String> tables = repositoryHelper.createNativeQuery("show tables like '"+tableName+"'").getResultList();
		return tables != null && tables.size() > 0;
	}

	@Override
	public boolean existsColumn(String tableName, String columnName) {
		List<String> columns = repositoryHelper.createNativeQuery("show columns from "+tableName+" like '"+columnName+"'").getResultList();
		return columns != null && columns.size() > 0;
	}

}
