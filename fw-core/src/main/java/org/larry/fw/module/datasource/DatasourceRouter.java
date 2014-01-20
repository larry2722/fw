/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月20日 下午10:11:40
 */
package org.larry.fw.module.datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.util.Assert;

public class DatasourceRouter extends AbstractDataSource implements InitializingBean {
	
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

	private DataSource determineCurrentLookupKey() {
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
		return determineCurrentLookupKey().getConnection();
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return determineCurrentLookupKey().getConnection(username, password);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
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
