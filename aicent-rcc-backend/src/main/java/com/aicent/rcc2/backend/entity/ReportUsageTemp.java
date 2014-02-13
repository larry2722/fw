/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月27日 上午10:20:40
 */
package com.aicent.rcc2.backend.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.aicent.rcc2.backend.entity.common.Usage;

@Entity
@Table(name = "rcc_report_usage_temp")
public class ReportUsageTemp extends Usage {

	private static final long serialVersionUID = 7667153894329984360L;

}
