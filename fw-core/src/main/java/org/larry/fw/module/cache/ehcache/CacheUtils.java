/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月22日 下午2:33:02
 */
package org.larry.fw.module.cache.ehcache;

import java.util.HashMap;
import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

import org.apache.commons.lang3.StringUtils;
import org.larry.fw.module.logger.Logger;
import org.larry.fw.module.logger.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

public class CacheUtils implements InitializingBean {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final String _DEFAULT_CACHE = "_defaultCache";

	private CacheManager cacheManager;

	private Map<String, CacheOperator> cachePool = new HashMap<String, CacheOperator>();

	public CacheOperator getCache() {
		logger.debug("get cache operator by name: {}", _DEFAULT_CACHE);
		return cachePool.get(_DEFAULT_CACHE);
	}

	public CacheOperator getCache(String name) {
		if (StringUtils.isBlank(name)) {
			return getCache();
		} else {
			if (cachePool.containsKey(name)) {
				return cachePool.get(name);
			}
			logger.debug("get cache operator by name: {}", name);
			Cache cache = cacheManager.getCache(name);
			if (cache != null) {
				CacheOperator cacheOperator = new CacheOperator(name, cache);
				cachePool.put(name, cacheOperator);
				return cacheOperator;
			}
			return getCache();
		}
	}

	public void clearCache() {
		getCache().clearStatistics();
	}

	public void clearCache(String name) {
		getCache(name).clearStatistics();
	}

	public void clearAllCache() {
		for (CacheOperator operator : cachePool.values()) {
			operator.clearStatistics();
		}
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		cachePool.put(_DEFAULT_CACHE, new CacheOperator(_DEFAULT_CACHE, cacheManager.getCache(_DEFAULT_CACHE)));
	}

}
