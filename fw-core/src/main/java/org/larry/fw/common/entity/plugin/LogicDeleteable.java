/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月21日 下午3:42:45
 */
package org.larry.fw.common.entity.plugin;

import java.io.Serializable;

import org.larry.fw.common.entity.IdEntity;

public abstract class LogicDeleteable<ID extends Serializable> extends IdEntity<ID> {
	
	private static final long serialVersionUID = 1L;
	
	// 逻辑删除flag
	private Boolean deleted;
	
	// 标识为已删除
	public void markDeleted() {
		this.deleted = Boolean.TRUE;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((deleted == null) ? 0 : deleted.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogicDeleteable other = (LogicDeleteable) obj;
		if (deleted == null) {
			if (other.deleted != null)
				return false;
		} else if (!deleted.equals(other.deleted))
			return false;
		return true;
	}
	
}
