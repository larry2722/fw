/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年2月10日 下午3:25:09
 */
package com.aicent.rcc2.backend.entity.common;

import javax.persistence.Column;
import javax.persistence.Enumerated;

import org.apache.commons.lang3.StringUtils;

import com.aicent.fw.common.entity.IdEntity;
import com.aicent.rcc2.backend.entity.type.SubscriberUserType;

public class Usage extends IdEntity<Long> {

	private static final long serialVersionUID = 1223083195744174358L;

	@Column(name = "subscription_seq")
	private Long subscriptionSeq = 0L;
	
	@Column(name = "imsi")
	private Long imsi = 0L;
	
	@Column(name = "volume_usage")
	private Long volumeUsage = 0L;
	
	@Column(name = "usage_s_time")
	private Long startTime = 0L;
	
	@Column(name = "usage_e_time")
	private Long endTime = 0L;
	
	@Column(name = "apn", length = 128)
	private String apn = StringUtils.EMPTY;
	
	@Column(name = "home_op")
	private Long homeOp = 0L;
	
	@Column(name = "visited_op")
	private Long visitedOp = 0L;
	
	@Column(name = "app_id")
	private Long appId = 0L;
	
	@Column(name = "gtp_session_id", length = 255)
	private String gtpSessionId = StringUtils.EMPTY;
	
	@Column(name = "uplink_usage")
	private Long uplinkUsage = 0L;
	
	@Column(name = "downlink_usage")
	private Long downlinkUsage = 0L;
	
	@Column(name = "end_user_ip")
	private Long endUserIp = 0L;
	
	@Column(name = "ggsn_ip")
	private Long ggsnIp = 0L;
	
	@Column(name = "package_id", nullable = false)
	private Long packageId;
	
	@Column(name = "drop_uplink_usage")
	private Long dropUplinkUsage = 0L;
	
	@Column(name = "drop_downlink_usage")
	private Long dropDownlinkUsage = 0L;
	
	@Column(name = "http_url", length = 100)
	private String httpUrl;
	
	@Column(name = "http_mime_type", length = 100)
	private String httpMimeType;
	
	@Column(name = "server_ip", length = 32)
	private String serverIp = StringUtils.EMPTY;
	
	@Column(name = "volume_identify")
	private Long volumeIdentify = 0L;
	
	@Column(name = "app_group_flag")
	private Integer appGroupFlag = 0;
	
	@Column(name = "report_trigger_rule_type")
	private Integer reportTriggerRuleType = 0;
	
	@Column(name = "rcc_customer_id")
	private Long customerId = 0L;
	
	@Enumerated
	@Column(name = "subscriber_user_type")
	private SubscriberUserType subscriberUserType = SubscriberUserType.Portal;
	
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
	 * @return the volumeUsage
	 */
	public Long getVolumeUsage() {
		return volumeUsage;
	}

	/**
	 * @param volumeUsage the volumeUsage to set
	 */
	public void setVolumeUsage(Long volumeUsage) {
		this.volumeUsage = volumeUsage;
	}

	/**
	 * @return the startTime
	 */
	public Long getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Long getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
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
	 * @return the gtpSessionId
	 */
	public String getGtpSessionId() {
		return gtpSessionId;
	}

	/**
	 * @param gtpSessionId the gtpSessionId to set
	 */
	public void setGtpSessionId(String gtpSessionId) {
		this.gtpSessionId = gtpSessionId;
	}

	/**
	 * @return the uplinkUsage
	 */
	public Long getUplinkUsage() {
		return uplinkUsage;
	}

	/**
	 * @param uplinkUsage the uplinkUsage to set
	 */
	public void setUplinkUsage(Long uplinkUsage) {
		this.uplinkUsage = uplinkUsage;
	}

	/**
	 * @return the downlinkUsage
	 */
	public Long getDownlinkUsage() {
		return downlinkUsage;
	}

	/**
	 * @param downlinkUsage the downlinkUsage to set
	 */
	public void setDownlinkUsage(Long downlinkUsage) {
		this.downlinkUsage = downlinkUsage;
	}

	/**
	 * @return the endUserIp
	 */
	public Long getEndUserIp() {
		return endUserIp;
	}

	/**
	 * @param endUserIp the endUserIp to set
	 */
	public void setEndUserIp(Long endUserIp) {
		this.endUserIp = endUserIp;
	}

	/**
	 * @return the ggsnIp
	 */
	public Long getGgsnIp() {
		return ggsnIp;
	}

	/**
	 * @param ggsnIp the ggsnIp to set
	 */
	public void setGgsnIp(Long ggsnIp) {
		this.ggsnIp = ggsnIp;
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
	 * @return the dropUplinkUsage
	 */
	public Long getDropUplinkUsage() {
		return dropUplinkUsage;
	}

	/**
	 * @param dropUplinkUsage the dropUplinkUsage to set
	 */
	public void setDropUplinkUsage(Long dropUplinkUsage) {
		this.dropUplinkUsage = dropUplinkUsage;
	}

	/**
	 * @return the dropDownlinkUsage
	 */
	public Long getDropDownlinkUsage() {
		return dropDownlinkUsage;
	}

	/**
	 * @param dropDownlinkUsage the dropDownlinkUsage to set
	 */
	public void setDropDownlinkUsage(Long dropDownlinkUsage) {
		this.dropDownlinkUsage = dropDownlinkUsage;
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
	 * @return the httpMimeType
	 */
	public String getHttpMimeType() {
		return httpMimeType;
	}

	/**
	 * @param httpMimeType the httpMimeType to set
	 */
	public void setHttpMimeType(String httpMimeType) {
		this.httpMimeType = httpMimeType;
	}

	/**
	 * @return the serverIp
	 */
	public String getServerIp() {
		return serverIp;
	}

	/**
	 * @param serverIp the serverIp to set
	 */
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	/**
	 * @return the volumeIdentify
	 */
	public Long getVolumeIdentify() {
		return volumeIdentify;
	}

	/**
	 * @param volumeIdentify the volumeIdentify to set
	 */
	public void setVolumeIdentify(Long volumeIdentify) {
		this.volumeIdentify = volumeIdentify;
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
	 * @return the reportTriggerRuleType
	 */
	public Integer getReportTriggerRuleType() {
		return reportTriggerRuleType;
	}

	/**
	 * @param reportTriggerRuleType the reportTriggerRuleType to set
	 */
	public void setReportTriggerRuleType(Integer reportTriggerRuleType) {
		this.reportTriggerRuleType = reportTriggerRuleType;
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
	 * @return the subscriberUserType
	 */
	public SubscriberUserType getSubscriberUserType() {
		return subscriberUserType;
	}

	/**
	 * @param subscriberUserType the subscriberUserType to set
	 */
	public void setSubscriberUserType(SubscriberUserType subscriberUserType) {
		this.subscriberUserType = subscriberUserType;
	}
}
