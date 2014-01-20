package org.larry.fw.common.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.data.domain.Persistable;

public abstract class AbstractEntity<ID extends Serializable> implements Persistable<ID>, Serializable {

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
