/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月27日 上午10:43:50
 */
package com.aicent.rcc2.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aicent.fw.common.entity.IdEntity;

@Entity
@Table(name = "rcc_report_hourly_usage")
public class ReportHourlyUsage extends IdEntity<Long> {

	private static final long serialVersionUID = 3962088264695988098L;

	@Column(name = "timemark")
	private Long timemark;
	
	@Column(name = "home_op")
	private Long homeOop;
	
	@Column(name = "visited_op")
	private Long visitedOp;
	
	@Column(name = "apn", length = 128)
	private String apn;
	
	@Column(name = "app_id")
	private Long appId;
	
	@Column(name = "uplink")
	private Long uplink;
	
	@Column(name = "downlink")
	private Long downlink;
	
	@Column(name = "volume")
	private Long volume;
	
	@Column(name = "http_url", length = 100)
	private String httpUrl;
	
	@Column(name = "imsi", length = 21)
	private String imsi;
	
	@Column(name = "package_id")
	private Long packageId;
	
	@Column(name = "subscription_seq")
	private Long subscriptionSeq;
	
	@Column(name = "app_group_flag")
	private Integer appGroupFlag;
	
	@Column(name = "rcc_customer_id")
	private Long customerId;
	
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
	 * @return the homeOop
	 */
	public Long getHomeOop() {
		return homeOop;
	}

	/**
	 * @param homeOop the homeOop to set
	 */
	public void setHomeOop(Long homeOop) {
		this.homeOop = homeOop;
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
	 * @return the apn
	 */
	public String getApn() {
		return apn;
	}

	/**
	 * @param apn the apn to set
	 */
	public void setApn(String apn) {
		this.apn = apn;
	}

	/**
	 * @return the appId
	 */
	public Long getAppId() {
		return appId;
	}

	/**
	 * @param appId the appId to set
	 */
	public void setAppId(Long appId) {
		this.appId = appId;
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
	 * @return the httpUrl
	 */
	public String getHttpUrl() {
		return httpUrl;
	}

	/**
	 * @param httpUrl the httpUrl to set
	 */
	public void setHttpUrl(String httpUrl) {
		this.httpUrl = httpUrl;
	}

	/**
	 * @return the imsi
	 */
	public String getImsi() {
		return imsi;
	}

	/**
	 * @param imsi the imsi to set
	 */
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	/**
	 * @return the packageId
	 */
	public Long getPackageId() {
		return packageId;
	}

	/**
	 * @param packageId the packageId to set
	 */
	public void setPackageId(Long packageId) {
		this.packageId = packageId;
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
	 * @return the appGroupFlag
	 */
	public Integer getAppGroupFlag() {
		return appGroupFlag;
	}

	/**
	 * @param appGroupFlag the appGroupFlag to set
	 */
	public void setAppGroupFlag(Integer appGroupFlag) {
		this.appGroupFlag = appGroupFlag;
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
