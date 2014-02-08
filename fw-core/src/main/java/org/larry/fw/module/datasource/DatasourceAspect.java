/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月26日 下午10:15:04
 */
package org.larry.fw.module.datasource;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.larry.fw.module.logger.Logger;
import org.larry.fw.module.logger.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DatasourceAspect {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Around("execution(* org.larry.fw.backend.repository.jpa.*.*(..))")
	public Object dataSourceJpa(final ProceedingJoinPoint point) throws Throwable {
		return dataSourceAround(point);
	}
	
	@Around("execution(* org.larry.fw.backend.service.impl.*.*(..))")
	public Object dataSourceService(final ProceedingJoinPoint point) throws Throwable {
		return dataSourceAround(point);
	}

	private Object dataSourceAround(ProceedingJoinPoint point) throws Throwable {
		MethodSignature signature = (MethodSignature) point.getSignature();
		Method method = signature.getMethod();
		if (method.getDeclaringClass().isInterface()) {
	        try {
	            method = point.getTarget().getClass().getDeclaredMethod(point.getSignature().getName(), method.getParameterTypes());
	        } catch (final SecurityException | NoSuchMethodException exception) {
	            //...
	        }
	    }
		DatasourceAccessType dataSourceType = method.getAnnotation(DatasourceAccessType.class);
		if (dataSourceType == null) {
			dataSourceType = point.getTarget().getClass().getAnnotation(DatasourceAccessType.class);
		}
		
		Object result = null;
		if (dataSourceType != null) {
			AvailableDataSources before = DatasourceProvider.getDataSource();
			DatasourceProvider.setDataSource(dataSourceType.value());
			logger.debug("switch datasource to " + dataSourceType.value());
			try {
				result = point.proceed();
			} catch (Exception e) {
				DatasourceProvider.setDataSource(before);
				throw e;
			} 
			DatasourceProvider.setDataSource(before);
		} else {
			result = point.proceed();
		}
		return result;
	}
}
