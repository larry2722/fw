/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月20日 下午10:15:56
 */
package com.aicent.fw.modules.datasource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.support.PersistenceExceptionTranslator;

import com.aicent.fw.modules.logger.Logger;
import com.aicent.fw.modules.logger.LoggerFactory;

public class AicentSqlSessionTemplate extends SqlSessionTemplate {

	private final Logger log = LoggerFactory.getLogger(AicentSqlSessionTemplate.class);
	
	public AicentSqlSessionTemplate(SqlSessionFactory sqlSessionFactory, ExecutorType executorType, PersistenceExceptionTranslator exceptionTranslator) {
		super(sqlSessionFactory, executorType, exceptionTranslator);
	}

	public AicentSqlSessionTemplate(SqlSessionFactory sqlSessionFactory, ExecutorType executorType) {
		super(sqlSessionFactory, executorType);
	}

	public AicentSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		super(sqlSessionFactory);
	}

	@Override
	public void close() {
		log.warn("Manual close is not allowed over a Spring managed SqlSession");
	}
}
