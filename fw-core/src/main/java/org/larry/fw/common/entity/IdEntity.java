package org.larry.fw.common.entity;

import java.io.Serializable;

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
	}

	@PreUpdate
	protected void preUpdate() {
		logger.debug("entity: " + getClass().getName() + ":" + getId() + " pre update.");
	}

	@PreRemove
	protected void preRemove() {
		logger.debug("entity: " + getClass().getName() + ":" + getId() + " pre remove.");
	}

}
