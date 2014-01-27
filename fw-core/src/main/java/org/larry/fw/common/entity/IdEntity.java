/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月21日 下午3:42:45
 */
package org.larry.fw.common.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.larry.fw.module.logger.Logger;
import org.larry.fw.module.logger.LoggerFactory;

@MappedSuperclass
public class IdEntity<ID extends Serializable> extends AbstractEntity<ID> {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(IdEntity.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private ID id;

	@Override
	public ID getId() {
		return id;
	}

	@Override
	public void setId(ID id) {
		this.id = id;
	}

	@PrePersist
	protected void prePersist() {
		logger.debug("entity: " + getClass().getName() + ":" + getId() + " pre persist.");
		if (id instanceof String) {
			id = (ID) UUID.randomUUID().toString();
		}
	}

	@PreUpdate
	protected void preUpdate() {
		logger.debug("entity: " + getClass().getName() + ":" + getId() + " pre update.");
	}

	@PreRemove
	protected void preRemove() {
		logger.debug("entity: " + getClass().getName() + ":" + getId() + " pre remove.");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdEntity other = (IdEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
