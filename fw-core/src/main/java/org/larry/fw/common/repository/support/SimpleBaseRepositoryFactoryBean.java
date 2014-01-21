/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月20日 下午10:43:39
 */
package org.larry.fw.common.repository.support;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.data.repository.query.QueryLookupStrategy;

public class SimpleBaseRepositoryFactoryBean<R extends JpaRepository<E, ID>, E, ID extends Serializable> extends JpaRepositoryFactoryBean<R, E, ID> {

	public SimpleBaseRepositoryFactoryBean() {}
	
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new SimpleBaseRepositoryFactory<E, ID>(entityManager);
    }
}

class SimpleBaseRepositoryFactory<E, ID extends Serializable> extends JpaRepositoryFactory {

	public SimpleBaseRepositoryFactory(EntityManager entityManager) {
		super(entityManager);
	}
	
	protected Object getTargetRepository(RepositoryMetadata metadata) {
		// TODO: 
		return super.getTargetRepository(metadata);
	}
	
	protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
		// TODO: 
        return super.getRepositoryBaseClass(metadata);
    }

    @Override
    protected QueryLookupStrategy getQueryLookupStrategy(QueryLookupStrategy.Key key) {
        return super.getQueryLookupStrategy(key);
    }
}
