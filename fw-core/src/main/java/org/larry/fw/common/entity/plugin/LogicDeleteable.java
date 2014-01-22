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
	
}
