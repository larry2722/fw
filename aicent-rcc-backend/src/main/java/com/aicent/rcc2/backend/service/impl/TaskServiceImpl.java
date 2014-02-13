/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月27日 上午10:15:14
 */
package com.aicent.rcc2.backend.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.conn.util.InetAddressUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aicent.fw.common.service.impl.BaseServiceImpl;
import com.aicent.fw.modules.datasource.AvailableDataSources;
import com.aicent.fw.modules.datasource.DatasourceAccessType;
import com.aicent.fw.modules.logger.Logger;
import com.aicent.fw.modules.logger.LoggerFactory;
import com.aicent.rcc2.backend.dto.DailyReport;
import com.aicent.rcc2.backend.entity.ReportTracingUsage;
import com.aicent.rcc2.backend.entity.ReportUrl;
import com.aicent.rcc2.backend.repository.ReportAppDao;
import com.aicent.rcc2.backend.repository.ReportAppGroupDao;
import com.aicent.rcc2.backend.repository.ReportHourlyImsiDao;
import com.aicent.rcc2.backend.repository.ReportHourlyUsageDao;
import com.aicent.rcc2.backend.repository.ReportOutboundDao;
import com.aicent.rcc2.backend.repository.ReportTracingUsageDao;
import com.aicent.rcc2.backend.repository.ReportUrlDao;
import com.aicent.rcc2.backend.repository.ReportUsageTempDao;
import com.aicent.rcc2.backend.repository.SubscriberDetailUsageDao;
import com.aicent.rcc2.backend.repository.SystemServiceDao;
import com.aicent.rcc2.backend.service.TaskService;

@SuppressWarnings("rawtypes")
@Service
@DatasourceAccessType(AvailableDataSources.WAREHOUSE)
public class TaskServiceImpl extends BaseServiceImpl implements TaskService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ReportHourlyImsiDao reportHourlyImsiDao;
	
	@Autowired
	private ReportHourlyUsageDao reportHourlyUsageDao;
	
	@Autowired
	private ReportTracingUsageDao reportTracingUsageDao;
	
	@Autowired
	private ReportUsageTempDao reportUsageTempDao;
	
	@Autowired
	private SubscriberDetailUsageDao subscriberDetailUsageDao;
	
	@Autowired
	private ReportUrlDao reportUrlDao;
	
	@Autowired
	private SystemServiceDao systemServiceDao;
	
	@Autowired
	private ReportAppDao reportAppDao;
	
	@Autowired
	private ReportAppGroupDao reportAppGroupDao;
	
	@Autowired
	private ReportOutboundDao reportOutboundDao;
	
	@Override
	@Transactional
	public void reportProcess() {
		// 遍历系统中已经存在的天表名称， show tables like 'rcc_subscriber_detail_usage_%';
		List<String> tableNames = systemServiceDao.findExistingTableName("rcc_subscriber_detail_usage_%");
		long maxId = 0;
		for (String tableName : tableNames) {
			// 跟踪表中遍历天表处理情况，不存在该天表，则初始化跟踪天表
			ReportTracingUsage traceUsage = getTraceUsage(tableName);
			
			// 存在，比较跟踪表中最终跟踪的ID，和该天表最大ID是否一致，如不一致，替换导入之后的数据到临时表temp进行处理
			maxId = subscriberDetailUsageDao.getMaxId(tableName);
			if (traceUsage.getFinishCdrId() < maxId) {
				rebuildUsageTemp(tableName, traceUsage);
				
				List<DailyReport> dailyReports = reportUsageTempDao.getDailyReport();
				if (dailyReports != null && dailyReports.size() > 0) {
					for (DailyReport dailyReport : dailyReports) {
						// 处理临时表中数据，生成相关表(rcc_report_hourly_usage_% | rcc_report_hourly_imsi_% | rcc_report_url_%)
						generateHourlyUsage(dailyReport);
						generateHourlyImsi(dailyReport);
					}
				}
				
				traceUsage.setFinishCdrId(maxId);
				// 最后，更新跟踪表，已处理数据
				reportTracingUsageDao.update(traceUsage);
			}
		}
		
		parseUrlDomainProcess();
	}
	
	private void generateHourlyUsage(DailyReport dailyReport) {
		String usageTableName = "rcc_report_hourly_usage_" + dailyReport.getTimemark();
		if (!existsTable(usageTableName)) {
			systemServiceDao.createTable(usageTableName, "rcc_report_hourly_usage");
			reportHourlyUsageDao.importHourlyUsageData(usageTableName, dailyReport.getStartTime(), dailyReport.getEndTime());
		}
		String timemark = dailyReport.getTimemark().substring(0, 6);
		generateReportApp(timemark, usageTableName);
		generateReportAppGroup(timemark, usageTableName);
		generateReportUrl(timemark, usageTableName);
		generateOutbound(timemark, usageTableName);
	}
	
	private void generateReportAppGroup(String timemark, String usageTableName) {
		String reportAppGroupTableName = "rcc_report_appgroup_" + timemark;
		systemServiceDao.createTable(reportAppGroupTableName, "rcc_report_appgroup");
		reportAppGroupDao.replaseData(reportAppGroupTableName, usageTableName);
	}

	private void generateReportApp(String timemark, String usageTableName) {
		String reportAppTableName = "rcc_report_app_" + timemark;
		systemServiceDao.createTable(reportAppTableName, "rcc_report_app");
		reportAppDao.replaseData(reportAppTableName, usageTableName);
	}
	
	private void generateReportUrl(String timemark, String usageTableName) {
		String reportUrlTableName = "rcc_report_url_" + timemark;
		createReportUrlTable(reportUrlTableName);
		reportUrlDao.replaseData(reportUrlTableName, usageTableName);
	}
	
	private void generateOutbound(String timemark, String usageTableName) {
		String reportOutboundTableName = "rcc_report_outbound_" + timemark;
		systemServiceDao.createTable(reportOutboundTableName, "rcc_report_outbound");
		reportOutboundDao.replaseData(reportOutboundTableName, usageTableName);
	}

	private final String regular = "(?<=http://|\\.|)[^.]*?\\.(?:com\\.cn|com\\.py|net\\.cn|org\\.cn|co\\.kr|co\\.uk|com|cn|net|org|biz|info|cc|tv|me|it|de)";
	private final Pattern p = Pattern.compile(regular, Pattern.CASE_INSENSITIVE);
	
	private synchronized void parseUrlDomain(String reportUrlTableName) {
		List<ReportUrl> reportUrls = reportUrlDao.findByParseDomain(reportUrlTableName);
		for (ReportUrl reportUrl : reportUrls) {
			if (StringUtils.isNotBlank(reportUrl.getUrl()) && !reportUrl.getUrl().equals("null") && reportUrl.getUrl().length() < 255) {
				updateDomain(reportUrlTableName, reportUrl);
			}
		}
	}

	private void updateDomain(String reportUrlTableName, ReportUrl reportUrl) {
		synchronized (reportUrl) {
			Matcher matcher;
			try {
				logger.debug(reportUrl.getUrl());
				if (isIPAddress(reportUrl.getUrl())) {
					reportUrl.setDomain(reportUrl.getUrl());
					reportUrlDao.updateDomain(reportUrlTableName, reportUrl);
				} else {
					matcher = p.matcher(reportUrl.getUrl());
					if (matcher.find()) {
						reportUrl.setDomain(matcher.group());
						reportUrlDao.updateDomain(reportUrlTableName, reportUrl);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private boolean isIPAddress(String url) {
		return (InetAddressUtils.isIPv4Address(url) || InetAddressUtils.isIPv6Address(url)) ? true : false;
	}

	private void generateHourlyImsi(DailyReport dailyReport) {
		String usageTableName = "rcc_report_hourly_usage_" + dailyReport.getTimemark();
		String imsiTableName = "rcc_report_hourly_imsi_" + dailyReport.getTimemark();
		if (!existsTable(imsiTableName)) {
			systemServiceDao.createTable(imsiTableName, "rcc_report_hourly_imsi");
			reportHourlyImsiDao.importHourlyImsiData(usageTableName, imsiTableName);
		}
	}
	
	private void rebuildUsageTemp(String tableName, ReportTracingUsage traceUsage) {
		reportUsageTempDao.removeAll();
		reportUsageTempDao.replaseData(tableName, traceUsage.getFinishCdrId());
	}

	private ReportTracingUsage getTraceUsage(String tableName) {
		ReportTracingUsage traceUsage = reportTracingUsageDao.getByTableName(tableName);
		// 不存在，初始化跟踪
		if (traceUsage == null) {
			traceUsage = reportTracingUsageDao.save(new ReportTracingUsage(tableName, 0L, 0L));
		}
		return traceUsage;
	}

	private boolean existsTable(String tableName) {
		return systemServiceDao.existsTable(tableName);
	}

	private void createReportUrlTable(String tableName) {
		if (!existsTable(tableName)) {
			systemServiceDao.createTable(tableName, "rcc_report_url");
			logger.debug("create table " + tableName);
			// 为 url_report月表添加主域名字段，并加索引
			reportUrlDao.addDomainColumn(tableName);
//			createIndex(tableName, "domain");
		} else if(!existsColumn(tableName, "domain")) {
			// 检查domain字段是否存在
			reportUrlDao.addDomainColumn(tableName);
		}
	}

	private boolean existsColumn(String tableName, String columnName) {
		return systemServiceDao.existsColumn(tableName, columnName);
	}

	public void parseUrlDomainProcess() {
		List<String> tableNames = systemServiceDao.findExistingTableName("rcc_report_url_%");
		for (String tableName : tableNames) {
			parseUrlDomain(tableName);
		}
	}

}
