/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月28日 下午5:42:45
 */
package com.aicent.rcc2.backend.entity;

import javax.persistence.Column;

import com.aicent.fw.common.entity.IdEntity;

public class AbstractReportApp extends IdEntity<Long> {

	private static final long serialVersionUID = 8456714298075257708L;

	@Column(name = "timemark")
	private Long timemark;
	
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

	/**
	 * @return the timemark
	 */
	public Long getTimemark() {
		return timemark;
	}

	/**
	 * @param timemark the timemark to set
	 */
	public void setTimemark(Long timemark) {
		this.timemark = timemark;
	}

	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
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
	 * @param reportType the reportType to set
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
	 * @param roamer the roamer to set
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
	 * @param uplink the uplink to set
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
	 * @param downlink the downlink to set
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
	 * @param volume the volume to set
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
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
