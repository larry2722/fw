/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月23日 下午4:13:06
 */
package org.larry.fw.common.service.impl;

import java.io.Serializable;
import java.util.List;

import org.larry.fw.common.dao.GenericDao;
import org.larry.fw.common.entity.AbstractEntity;
import org.larry.fw.common.service.BaseService;
import org.larry.fw.module.logger.Logger;
import org.larry.fw.module.logger.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseServiceImpl<E extends AbstractEntity<ID>, ID extends Serializable> implements BaseService<E, ID> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected GenericDao<E, ID> dao;
	
	@Override
	public E getById(Long primaryKey) {
		return dao.getById(primaryKey);
	}

	@Override
	public List<E> getByIds(List<Long> primaryKeys) {
		return dao.getByIds(primaryKeys);
	}

	@Override
	public boolean exists(Long primaryKey) {
		return dao.exists(primaryKey);
	}

	@Override
	public E refresh(E entity) {
		return dao.refresh(entity);
	}

	@Override
	public List<E> getAll() {
		return dao.getAll();
	}

	@Override
	public Long getCount() {
		return dao.getCount();
	}

	@Override
	public E save(E entity) {
		return dao.save(entity);
	}

	@Override
	public void save(List<E> entities) {
		dao.save(entities);
	}

	@Override
	public E update(E entity) {
		return dao.update(entity);
	}

	@Override
	public void remove(Long primaryKey) {
		dao.remove(primaryKey);
	}

}
