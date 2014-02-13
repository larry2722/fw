/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月28日 上午11:02:49
 */
package com.aicent.rcc2.backend.repository;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;

public interface SystemServiceDao extends InitializingBean {

	List<String> findExistingTableName(String tableName);

	void createTable(String tableName, String likeTableName);

	boolean existsTable(String tableName);

	boolean existsColumn(String tableName, String columnName);

}
