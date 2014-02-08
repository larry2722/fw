/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月23日 下午9:55:47
 */
package org.larry.fw.module.shiro.web.filter.authc;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

	/**
	 * 默认的成功地址
	 */
	private String defaultSuccessUrl;
	/**
	 * 管理员默认的成功地址
	 */
	private String adminDefaultSuccessUrl;

	public String getDefaultSuccessUrl() {
		return defaultSuccessUrl;
	}

	public void setDefaultSuccessUrl(String defaultSuccessUrl) {
		this.defaultSuccessUrl = defaultSuccessUrl;
	}

	public String getAdminDefaultSuccessUrl() {
		return adminDefaultSuccessUrl;
	}

	public void setAdminDefaultSuccessUrl(String adminDefaultSuccessUrl) {
		this.adminDefaultSuccessUrl = adminDefaultSuccessUrl;
	}

}
