/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC admin portal
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月26日 下午4:17:25
 */
package com.aicent.rcc2.backend.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import com.aicent.fw.common.entity.IdEntity;

@Entity
@Table(name = "rcc_report_tracing_usage")
public class ReportTracingUsage extends IdEntity<Long> {

	private static final long serialVersionUID = 3050656029814111009L;

	@Column(name = "tableName", length = 64)
	private String tableName;

	@Column(name = "start_cdr_id")
	private Long startCdrId;

	@Column(name = "finish_cdr_id")
	private Long finishCdrId;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	private Calendar updateDate;

	@Column(name = "remark", length = 64)
	private String remark;
	
	public ReportTracingUsage() {}
	
	public ReportTracingUsage(String tableName, Long minCdrId, Long maxCdrId) {
		this.tableName = tableName;
		this.startCdrId = minCdrId;
		this.finishCdrId = maxCdrId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Long getStartCdrId() {
		return startCdrId;
	}

	public void setStartCdrId(Long startCdrId) {
		this.startCdrId = startCdrId;
	}

	public Long getFinishCdrId() {
		return finishCdrId;
	}

	public void setFinishCdrId(Long finishCdrId) {
		this.finishCdrId = finishCdrId;
	}

	public Calendar getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Calendar updateDate) {
		this.updateDate = updateDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	protected void prePersist() {
		this.updateDate = Calendar.getInstance();
	}
	
	@Override
	protected void preUpdate() {
		this.updateDate = Calendar.getInstance();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("tableName", this.tableName).append("startCdrId", this.startCdrId).append("finishCdrId", this.finishCdrId).append("updateDate", this.updateDate).append("id", this.getId()).toString();
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof ReportTracingUsage)) {
			return false;
		}
		ReportTracingUsage rhs = (ReportTracingUsage) object;
		return new EqualsBuilder().append(this.getId(), rhs.getId()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-1765965303, -8787085).append(this.tableName).append(this.startCdrId).append(this.finishCdrId).toHashCode();
	}
}
