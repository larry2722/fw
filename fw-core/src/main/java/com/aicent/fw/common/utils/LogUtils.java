/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月23日 下午11:23:15
 */
package com.aicent.fw.common.utils;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;

import com.aicent.fw.common.utils.NetUtils;
import com.aicent.fw.modules.logger.Logger;
import com.aicent.fw.modules.logger.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class LogUtils {

	private static final Logger ERROR_LOG = LoggerFactory.getLogger("fw-error");
	private static final Logger ACCESS_LOG = LoggerFactory.getLogger("fw-access");
	
	/**
     * 记录访问日志
     * [username][jsessionid][ip][accept][UserAgent][url][params][Referer]
     *
     * @param request
     */
    public static void logAccess(HttpServletRequest request) {
        String username = getUsername();
        String jsessionId = request.getRequestedSessionId();
        String ip = NetUtils.getIpAddr(request);
        String accept = request.getHeader("accept");
        String userAgent = request.getHeader("User-Agent");
        String url = request.getRequestURI();
        String params = getParams(request);
        String headers = getHeaders(request);

        StringBuilder s = new StringBuilder();
        s.append(getBlock(username));
        s.append(getBlock(jsessionId));
        s.append(getBlock(ip));
        s.append(getBlock(accept));
        s.append(getBlock(userAgent));
        s.append(getBlock(url));
        s.append(getBlock(params));
        s.append(getBlock(headers));
        s.append(getBlock(request.getHeader("Referer")));
        getAccessLog().info(s.toString());
    }
    
    protected static String getParams(HttpServletRequest request) {
        Map<String, String[]> params = request.getParameterMap();
        return JSON.toJSONString(params);
    }
    
    private static String getHeaders(HttpServletRequest request) {
        Map<String, List<String>> headers = Maps.newHashMap();
        Enumeration<String> namesEnumeration = request.getHeaderNames();
        while(namesEnumeration.hasMoreElements()) {
            String name = namesEnumeration.nextElement();
            Enumeration<String> valueEnumeration = request.getHeaders(name);
            List<String> values = Lists.newArrayList();
            while(valueEnumeration.hasMoreElements()) {
                values.add(valueEnumeration.nextElement());
            }
            headers.put(name, values);
        }
        return JSON.toJSONString(headers);
    }
    
    protected static String getUsername() {
        return (String) SecurityUtils.getSubject().getPrincipal();
    }
    
    public static String getBlock(Object msg) {
        if (msg == null) {
            msg = "";
        }
        return "[" + msg.toString() + "]";
    }
    
    public static Logger getAccessLog() {
        return ACCESS_LOG;
    }

    public static Logger getErrorLog() {
        return ERROR_LOG;
    }
}
