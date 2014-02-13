/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC backend
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月28日 下午2:50:54
 */
package com.aicent.rcc2.backend.dto;

import com.aicent.fw.common.dto.AbstractDto;

public class DailyReport extends AbstractDto {

	private static final long serialVersionUID = -6892096869879116486L;
	
	private String timemark;
	private String today;
	private String nextDay;
	private String startTime;
	private String endTime;
	
	/**
	 * 
	 */
	public DailyReport() {
		super();
	}

	/**
	 * @param timemark
	 * @param today
	 * @param nextDay
	 * @param startTime
	 * @param endTime
	 */
	public DailyReport(String timemark, String today, String nextDay, String startTime, String endTime) {
		super();
		this.timemark = timemark;
		this.today = today;
		this.nextDay = nextDay;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * @return the timemark
	 */
	public String getTimemark() {
		return timemark;
	}

	/**
	 * @param timemark
	 *            the timemark to set
	 */
	public void setTimemark(String timemark) {
		this.timemark = timemark;
	}

	/**
	 * @return the today
	 */
	public String getToday() {
		return today;
	}

	/**
	 * @param today
	 *            the today to set
	 */
	public void setToday(String today) {
		this.today = today;
	}

	/**
	 * @return the nextDay
	 */
	public String getNextDay() {
		return nextDay;
	}

	/**
	 * @param nextDay
	 *            the nextDay to set
	 */
	public void setNextDay(String nextDay) {
		this.nextDay = nextDay;
	}

	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


}
