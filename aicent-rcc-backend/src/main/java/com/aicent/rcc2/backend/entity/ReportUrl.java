/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月27日 上午11:52:32
 */
package com.aicent.rcc2.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import com.aicent.fw.common.entity.IdEntity;

@Entity
@Table(name = "rcc_report_url")
public class ReportUrl extends IdEntity<Long> {

	private static final long serialVersionUID = -8724511131887316526L;

	@Column(name = "timemark")
	private Long timemark;
	
	@Column(name = "rcc_customer_id")
	private Long customerId;
	
	@Column(name = "url")
	private String url;
	
//	@Enumerated
	@Column(name = "report_type")
//	private UrlReportType reportType = UrlReportType.DAILY;
	private Short reportType = 1;
	
	@Column(name = "roamer")
	private Long roamer;
	
	@Column(name = "uplink")
	private Long uplink;
	
	@Column(name = "downlink")
	private Long downlink;
	
	@Column(name = "volume")
	private Long volume;
	
	@Column(name = "remark")
	private String remark;
	
	@Transient
	private String domain;

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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the reportType
	 */
	public Short getReportType() {
		return reportType;
	}

	/**
	 * @param reportType the reportType to set
	 */
	public void setReportType(Short reportType) {
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
	
	/**
	 * @return the domain
	 */
	public String getDomain() {
		if (StringUtils.isNotBlank(domain) && domain.indexOf("'") != -1) {
			return domain.replace("'", "");
		}
		return domain;
	}

	/**
	 * @param domain the domain to set
	 */
	public void setDomain(String domain) {
		if (StringUtils.isNotBlank(domain)) {
			if (domain.indexOf("'") != -1) {
				domain = domain.replace("'", "");
			}
			if (domain.length() > 255) {
				domain = domain.substring(0, 254);
			}
			if (domain.endsWith("\\")) {
				domain = domain.substring(0, domain.length() - 1);
			}
		}
		this.domain = domain;
	}

	/* (non-Javadoc)
	 * @see com.aicent.fw.common.entity.IdEntity#prePersist()
	 */
	@Override
	protected void prePersist() {
		super.prePersist();
	}

	/* (non-Javadoc)
	 * @see com.aicent.fw.common.entity.IdEntity#preUpdate()
	 */
	@Override
	protected void preUpdate() {
		super.preUpdate();
	}
	
}
