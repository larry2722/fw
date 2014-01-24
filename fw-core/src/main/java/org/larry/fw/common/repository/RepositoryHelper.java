/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月24日 下午1:40:10
 */
package org.larry.fw.common.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.larry.fw.common.entity.AbstractEntity;
import org.springframework.orm.jpa.SharedEntityManagerCreator;
import org.springframework.util.Assert;

public class RepositoryHelper<E extends AbstractEntity<ID>, ID extends Serializable> {

	private static EntityManager entityManager;
    private Class<E> entityClass;
    private boolean enableQueryCache = false;
    
	public RepositoryHelper(Class<E> entityClass) {
		this.entityClass = entityClass;
		// TODO: 这里判断实体类上是否配置了缓存 自定义 annotation
		
	}

	public static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		entityManager = SharedEntityManagerCreator.createSharedEntityManager(entityManagerFactory);
	}
	
	public static EntityManager getEntityManager() {
		Assert.notNull(entityManager, "entityManager must null, please see [org.larry.fw.common.repository.RepositoryHelper#setEntityManagerFactory]");
		return entityManager;
	}
	
	public static void flush() {
		getEntityManager().flush();
	}
	
	public static void clear() {
        flush();
        getEntityManager().clear();
    }
	
	public E getById(Long primaryKey) {
		return getEntityManager().find(entityClass, primaryKey);
	}
}
