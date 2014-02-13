/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年2月10日 下午2:46:23
 */
package com.aicent.rcc2.backend.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.aicent.fw.common.entity.IdEntity;

@Entity
@Table(name = "rcc_report_outbound")
public class ReportOutbound extends IdEntity<Long> {

	@Column(name = "timemark")
	private Long timemark;

	@Column(name = "visited_op")
	private Long visitedOp;

	@Column(name = "rcc_customer_id")
	private Long customerId;

	@Column(name = "report_type")
	private Integer reportType;

	@Column(name = "roamer")
	private Long roamer;

	@Column(name = "uplink")
	private Long uplink;

	@Column(name = "downlink")
	private Long downlink;

	@Column(name = "volume")
	private Long volume;

	@Column(name = "remark", length = 64)
	private String remark;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "update_time")
	private Calendar updateTime;

	/**
	 * @return the timemark
	 */
	public Long getTimemark() {
		return timemark;
	}

	/**
	 * @param timemark
	 *            the timemark to set
	 */
	public void setTimemark(Long timemark) {
		this.timemark = timemark;
	}

	/**
	 * @return the visitedOp
	 */
	public Long getVisitedOp() {
		return visitedOp;
	}

	/**
	 * @param visitedOp
	 *            the visitedOp to set
	 */
	public void setVisitedOp(Long visitedOp) {
		this.visitedOp = visitedOp;
	}

	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the reportType
	 */
	public Integer getReportType() {
		return reportType;
	}

	/**
	 * @param reportType
	 *            the reportType to set
	 */
	public void setReportType(Integer reportType) {
		this.reportType = reportType;
	}

	/**
	 * @return the roamer
	 */
	public Long getRoamer() {
		return roamer;
	}

	/**
	 * @param roamer
	 *            the roamer to set
	 */
	public void setRoamer(Long roamer) {
		this.roamer = roamer;
	}

	/**
	 * @return the uplink
	 */
	public Long getUplink() {
		return uplink;
	}

	/**
	 * @param uplink
	 *            the uplink to set
	 */
	public void setUplink(Long uplink) {
		this.uplink = uplink;
	}

	/**
	 * @return the downlink
	 */
	public Long getDownlink() {
		return downlink;
	}

	/**
	 * @param downlink
	 *            the downlink to set
	 */
	public void setDownlink(Long downlink) {
		this.downlink = downlink;
	}

	/**
	 * @return the volume
	 */
	public Long getVolume() {
		return volume;
	}

	/**
	 * @param volume
	 *            the volume to set
	 */
	public void setVolume(Long volume) {
		this.volume = volume;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the updateTime
	 */
	public Calendar getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            the updateTime to set
	 */
	public void setUpdateTime(Calendar updateTime) {
		this.updateTime = updateTime;
	}

}
