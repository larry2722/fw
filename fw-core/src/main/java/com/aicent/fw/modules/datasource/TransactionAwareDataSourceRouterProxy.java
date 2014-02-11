/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月20日 下午10:11:40
 */
package com.aicent.fw.modules.datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.util.Assert;

public class TransactionAwareDataSourceRouterProxy extends TransactionAwareDataSourceProxy implements InitializingBean {
	
	private Map<AvailableDataSources, Object> targetDataSources;
	private DataSource defaultTargetDataSource;
	
	private Map<AvailableDataSources, DataSource> resolvedDataSources;
	private DataSource resolvedDefaultDataSource;

	public void setTargetDataSources(Map<AvailableDataSources, Object> targetDataSources) {
		this.targetDataSources = targetDataSources;
	}

	public void setDefaultTargetDataSource(DataSource defaultTargetDataSource) {
		this.defaultTargetDataSource = defaultTargetDataSource;
	}

	public DataSource getTargetDataSource() {
		Assert.notNull(this.resolvedDataSources, "DataSource router not initialized");
		AvailableDataSources lookupKey = DatasourceProvider.getDataSource();
		DataSource dataSource = this.resolvedDataSources.get(lookupKey);
		if (dataSource == null) {
			dataSource = this.resolvedDefaultDataSource;
		}
		if (dataSource == null) {
			throw new IllegalStateException("Cannot determine target DataSource for lookup key [" + lookupKey + "]");
		}
		return dataSource;
	}

	@Override
	public Connection getConnection() throws SQLException {
		DataSource ds = getTargetDataSource();
		Assert.state(ds != null, "'targetDataSource' is required");
		// see: http://blog.csdn.net/dingqinghu/article/details/8982298
		// 直接通过数据源获取连接（jdbcTemplate.getDataSource().getConnection())，需要显式释放，不然会出现连接泄漏问题
		return getTransactionAwareConnectionProxy(ds);
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return getTargetDataSource().getConnection(username, password);
	}

	@Override
	public void afterPropertiesSet() {
		if (this.targetDataSources == null) {
			throw new IllegalArgumentException("Property 'targetDataSources' is required");
		}
		this.resolvedDataSources = new HashMap<AvailableDataSources, DataSource>(this.targetDataSources.size());
		for (Map.Entry<AvailableDataSources, Object> entry : this.targetDataSources.entrySet()) {
			DataSource dataSource = (DataSource) entry.getValue();
			this.resolvedDataSources.put(entry.getKey(), dataSource);
		}
		if (this.defaultTargetDataSource != null) {
			this.resolvedDefaultDataSource = this.defaultTargetDataSource;
		}
	}

}
