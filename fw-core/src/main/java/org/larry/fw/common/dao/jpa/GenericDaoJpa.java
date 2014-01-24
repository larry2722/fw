/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月24日 下午1:29:20
 */
package org.larry.fw.common.dao.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.larry.fw.common.dao.GenericDao;
import org.larry.fw.common.entity.AbstractEntity;
import org.larry.fw.common.repository.RepositoryHelper;
import org.larry.fw.common.utils.ReflectUtils;
import org.larry.fw.module.logger.Logger;
import org.larry.fw.module.logger.LoggerFactory;

public class GenericDaoJpa<E extends AbstractEntity<ID>, ID extends Serializable> implements GenericDao<E, ID> {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private RepositoryHelper repositoryHelper;
	private Class<E> entityClass;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		entityClass = ReflectUtils.findParameterizedType(getClass(), 0);
		repositoryHelper = new RepositoryHelper(entityClass);
	}
	
	@Override
	public E getById(Long primaryKey) {

		return null;
	}

	@Override
	public List<E> getByIds(List<Long> primaryKeys) {

		return null;
	}

	@Override
	public boolean exists(Long primaryKey) {

		return false;
	}

	@Override
	public E refresh(E entity) {

		return null;
	}

	@Override
	public List<E> getAll() {

		return null;
	}

	@Override
	public Long getCount() {

		return null;
	}

	@Override
	public E save(E entity) {

		return null;
	}

	@Override
	public void save(List<E> entities) {

	}

	@Override
	public E update(E entity) {

		return null;
	}

	@Override
	public void remove(Long primaryKey) {

	}

}
