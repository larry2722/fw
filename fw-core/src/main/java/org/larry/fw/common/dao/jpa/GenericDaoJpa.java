/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月23日 下午7:29:20
 */
package org.larry.fw.common.dao.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.larry.fw.common.dao.GenericDao;
import org.larry.fw.common.entity.AbstractEntity;
import org.larry.fw.common.repository.EntityManagerHelper;
import org.larry.fw.common.repository.RepositoryHelper;
import org.larry.fw.common.utils.ReflectUtils;
import org.larry.fw.module.logger.Logger;
import org.larry.fw.module.logger.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDaoJpa<T extends AbstractEntity<ID>, ID extends Serializable> implements GenericDao<T, ID> {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 这里可以扩展成继承EntityManager然后实现其所有方法，在其方法上扩展
	private EntityManagerHelper<T, ID> repositoryHelper;
	private Class<T> entityClass;
	
	protected EntityManagerHelper<T, ID> getRepositoryHelper() {
		return this.repositoryHelper;
	}
	
	@Override
	public T getById(Long primaryKey) {
		logger.debug("get " + this.entityClass.getName() + " by id: " + primaryKey);
		return this.repositoryHelper.find(entityClass, primaryKey);
	}

	@Override
	public List<T> getByIds(List<Long> primaryKeys) {
		List<T> entitys = new ArrayList<T>();
		
		List<Long> invalidIds = new ArrayList<Long>();
		
		for (Long primaryKey : primaryKeys) {
			T entity = this.repositoryHelper.find(this.entityClass, primaryKey);
			if (entity != null ){
				entitys.add(entity);
			} else {
				invalidIds.add(primaryKey);
			}
		}
		
		primaryKeys.clear();
		primaryKeys.addAll(invalidIds);
		
		return entitys;
	}

	@Override
	public boolean exists(Long primaryKey) {
		T entity = this.getById(primaryKey);
		return entity != null;
	}

	@Override
	public T refresh(T entity) {
		this.repositoryHelper.refresh(entity);
		return entity;
	}

	@Override
	public List<T> getAll() {
		return this.repositoryHelper.createQuery("select obj from " + this.entityClass.getName() + " obj", this.entityClass).setHint("org.hibernate.cacheable", true).getResultList();
	}

	@Override
	public Long getCount() {
		return this.repositoryHelper.createQuery("select count(obj) from " + this.entityClass.getName() + " obj", Long.class).getSingleResult();
	}

	@Override
	public T save(T entity) {
		this.repositoryHelper.persist(entity);
		return entity;
	}

	@Override
	public void save(List<T> entities) {
		for (T entity : entities) {
			this.repositoryHelper.persist(entity);
		}
	}

	@Override
	public T update(T entity) {
		return this.repositoryHelper.merge(entity);
	}

	@Override
	public void remove(Long primaryKey) {
		T entity = this.getById(primaryKey);
		if (entity != null) {
			this.repositoryHelper.remove(entity);
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		try {
			entityClass = ReflectUtils.findParameterizedType(getClass(), 0);
			repositoryHelper = new RepositoryHelper<T, ID>(entityClass);
			logger.debug(".......");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
