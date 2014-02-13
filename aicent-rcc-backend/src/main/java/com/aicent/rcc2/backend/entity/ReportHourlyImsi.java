/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月27日 上午11:06:35
 */
package com.aicent.rcc2.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aicent.fw.common.entity.IdEntity;

@Entity
@Table(name = "rcc_report_hourly_imsi")
public class ReportHourlyImsi extends IdEntity<Long> {

	private static final long serialVersionUID = -2257784972849193323L;

	@Column(name = "timemark")
	private Long timemark;
	
	@Column(name = "home_op")
	private Long homeOp;
	
	@Column(name = "visited_op")
	private Long visitedOp;
	
	@Column(name = "imsi")
	private Long imsi;
	
	@Column(name = "subscription_seq")
	private Long subscriptionSeq;
	
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
	 * @return the homeOp
	 */
	public Long getHomeOp() {
		return homeOp;
	}

	/**
	 * @param homeOp the homeOp to set
	 */
	public void setHomeOp(Long homeOp) {
		this.homeOp = homeOp;
	}

	/**
	 * @return the visitedOp
	 */
	public Long getVisitedOp() {
		return visitedOp;
	}

	/**
	 * @param visitedOp the visitedOp to set
	 */
	public void setVisitedOp(Long visitedOp) {
		this.visitedOp = visitedOp;
	}

	/**
	 * @return the imsi
	 */
	public Long getImsi() {
		return imsi;
	}

	/**
	 * @param imsi the imsi to set
	 */
	public void setImsi(Long imsi) {
		this.imsi = imsi;
	}

	/**
	 * @return the subscriptionSeq
	 */
	public Long getSubscriptionSeq() {
		return subscriptionSeq;
	}

	/**
	 * @param subscriptionSeq the subscriptionSeq to set
	 */
	public void setSubscriptionSeq(Long subscriptionSeq) {
		this.subscriptionSeq = subscriptionSeq;
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
