/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月27日 上午11:15:55
 */
package com.aicent.rcc2.backend.repository.jpa;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;

import com.aicent.fw.common.entity.AbstractEntity;
import com.aicent.fw.common.repository.jpa.GenericDaoJpa;

import org.springframework.stereotype.Repository;

import com.aicent.rcc2.backend.dto.DailyReport;
import com.aicent.rcc2.backend.entity.ReportUsageTemp;
import com.aicent.rcc2.backend.repository.ReportUsageTempDao;

@Repository
public class ReportUsageTempDaoJpa extends GenericDaoJpa<ReportUsageTemp, Long> implements ReportUsageTempDao {

	@Override
	public int removeAll() {
		Query query = getRepositoryHelper().createQuery("delete from ReportUsageTemp t where t.id = 1861");
		return query.executeUpdate();
	}

	@Override
	public int replaseData(String tableName, Long maxCdrId) {
		List<String> colums = new ArrayList<String>();
		getFieldNames(ReportUsageTemp.class, colums);
		colums.remove("apm");
		colums.remove("dtype");
		String columnNames = StringUtils.join(colums, ",");
		Query query = getRepositoryHelper().createNativeQuery("replace into rcc_report_usage_temp ("+ columnNames +") select " + columnNames + " from " + tableName + " where id > " + maxCdrId);
		return query.executeUpdate();
	}
	
	private void getFieldNames(Class<?> clazz, List<String> result) {
		Class<?> superClass = clazz.getSuperclass();
		if (!superClass.getSimpleName().equals(AbstractEntity.class.getSimpleName())) {
			getFieldNames(superClass, result);
		} 
		Field[] fields = clazz.getDeclaredFields();
		if (fields != null && fields.length > 0) {
			for (Field filed : fields) {
				Column column = filed.getAnnotation(Column.class);
				if (column != null) {
					String columnName = column.name();
					if (StringUtils.isNotBlank(columnName)) {
						result.add(columnName);
					} else {
						result.add(filed.getName());
					}
				}
				Id id = filed.getAnnotation(Id.class);
				if (id != null) {
					result.add(filed.getName());
				}
			}
		}
	}

	@Override
	public List<DailyReport> getDailyReport() {
		List<DailyReport> result = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT distinct ");
		sql.append("from_unixtime(usage_e_time/1000, '%Y%m%d') timemark, ");
		sql.append("from_unixtime(usage_e_time/1000, '%Y-%m-%d') today, ");
		sql.append("DATE_FORMAT(DATE_ADD(from_unixtime(usage_e_time/1000),INTERVAL 1 DAY), '%Y-%m-%d') nextDay, ");
		sql.append("UNIX_TIMESTAMP(left(from_unixtime(usage_e_time/1000),10))*1000 startTime, ");
		sql.append("UNIX_TIMESTAMP(DATE_ADD(left(from_unixtime(usage_e_time/1000),10),INTERVAL 1 DAY) )*1000 endTime ");
		sql.append("from rcc_report_usage_temp");
		Query query = getRepositoryHelper().createNativeQuery(sql.toString());
		List<Object[]> list = query.getResultList();
		if (list != null && list.size() > 0) {
			result = new ArrayList<DailyReport>();
			for (Object obj[] : list) {
				result.add(loadDailyReport(obj));
			}
		}
		return result;
	}

	private DailyReport loadDailyReport(Object[] obj) {
		DailyReport dailyReport = new DailyReport();
		if (obj != null && obj.length > 0) {
			if (obj[0] != null && StringUtils.isNotBlank(obj[0].toString())) {
				dailyReport.setTimemark(obj[0].toString());
			}
			if (obj[1] != null && StringUtils.isNotBlank(obj[1].toString())) {
				dailyReport.setToday(obj[1].toString());
			}
			if (obj[2] != null && StringUtils.isNotBlank(obj[2].toString())) {
				dailyReport.setNextDay(obj[2].toString());
			}
			if (obj[3] != null && StringUtils.isNotBlank(obj[3].toString())) {
				dailyReport.setStartTime(obj[3].toString());
			}
			if (obj[4] != null && StringUtils.isNotBlank(obj[4].toString())) {
				dailyReport.setEndTime(obj[4].toString());
			}
		}
		return dailyReport;
	}

}
