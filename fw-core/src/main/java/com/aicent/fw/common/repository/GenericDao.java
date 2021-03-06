/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月23日 下午10:02:47
 */
package com.aicent.fw.common.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;

import com.aicent.fw.common.entity.AbstractEntity;

public interface GenericDao<E extends AbstractEntity<ID>, ID extends Serializable> extends InitializingBean {

	E getById(Long primaryKey);
	
	List<E> getByIds(final List<Long> primaryKeys);
	
	boolean exists(Long primaryKey);
	
	E refresh(E entity);
	
	List<E> getAll();
	
	Long getCount();
	
	E save(E entity);
	
	void save(List<E> entities);
	
	E update(E entity);
	
	void remove(Long primaryKey);
}
