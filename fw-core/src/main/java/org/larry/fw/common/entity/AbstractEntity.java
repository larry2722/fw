/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月23日 下午9:42:45
 */
package org.larry.fw.common.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.data.domain.Persistable;

public abstract class AbstractEntity<ID extends Serializable> implements Persistable<ID>, Serializable {

	private static final long serialVersionUID = 1L;

	public abstract ID getId();
	
	public abstract void setId(final ID id);
	
	@Override
	public boolean isNew() {
		return null == getId();
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
