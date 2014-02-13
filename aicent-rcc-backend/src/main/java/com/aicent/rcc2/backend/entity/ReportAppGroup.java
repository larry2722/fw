/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月28日 下午5:42:26
 */
package com.aicent.rcc2.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rcc_report_appgroup")
public class ReportAppGroup extends AbstractReportApp {

	private static final long serialVersionUID = 8441468540256887809L;
	
	@Column(name = "app_group_id")
	private Long appGroupId;

	/**
	 * @return the appGroupId
	 */
	public Long getAppGroupId() {
		return appGroupId;
	}

	/**
	 * @param appGroupId the appGroupId to set
	 */
	public void setAppGroupId(Long appGroupId) {
		this.appGroupId = appGroupId;
	}
	
}
