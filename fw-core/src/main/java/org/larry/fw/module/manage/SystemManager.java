/**   
 * Copyright:   Copyright (c)2014 
 * Company:     Aicent RIS.WiFi Portal
 * @author:     Larry.Li  
 * @version:    v1.0.0  
 * Create by:   Larry.Li
 * Create Date: 2014年1月13日 下午4:52:15
 */
package org.larry.fw.module.manage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aicent.wifi.riswifi.common.controller.BaseController;
import com.aicent.wifi.riswifi.module.logger.Level;
import com.aicent.wifi.riswifi.module.logger.Logger;
import com.aicent.wifi.riswifi.module.logger.LoggerFactory;
import com.aicent.wifi.riswifi.module.utils.CacheUtils;

@Controller
@RequestMapping("system")
public class SystemManager extends BaseController {
	
	private final Logger logger = LoggerFactory.getLogger(SystemManager.class);
	
	private static final String PREFIX = "system/";
	
	@Autowired
	private CacheUtils cacheUtils;

	@RequestMapping
	public String main() {
		return PREFIX + "main";
	}
	
	@RequestMapping("log/level")
	public @ResponseBody ResponseEntity<String> getLogLevel() {
		String level = LoggerFactory.getLevel().name();
		logger.info("current logger level is: " + level);
		return new ResponseEntity<String>(level, HttpStatus.OK);
	}
	
	@RequestMapping("log/level/{level}/update")
	public @ResponseBody ResponseEntity<String> updateLogLevel(@PathVariable("level") String level) {
		String result = StringUtils.EMPTY;
		try {
			Level l = Level.valueOf(level.toUpperCase());
			LoggerFactory.setLevel(l);
			result = level;
			logger.trace("trace...");
			logger.debug("forward to dashboard page.");
			logger.info("info to dashboard page.");
			logger.warn("warn to dashboard page.");
			logger.error("error ....");
		} catch (Exception e) {
			result = level + " level type error.";
		}
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	@RequestMapping("cache/clear")
	public @ResponseBody ResponseEntity<String> cacheClear() {
		try {
			cacheUtils.clearAllCache();
			return new ResponseEntity<String>("Successful.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Fail.", HttpStatus.OK);
		}
		
	}
}
