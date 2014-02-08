/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月23日 下午10:49:37
 */
package org.larry.fw.module.cache.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.commons.codec.digest.DigestUtils;
import org.larry.fw.module.logger.Logger;
import org.larry.fw.module.logger.LoggerFactory;

public class CacheOperator {

	private final Logger logger = LoggerFactory.getLogger(CacheOperator.class);

	private String cacheName;
	private Cache cache = null;

	public CacheOperator(String cacheName, Cache cache) {
		this.cacheName = cacheName;
		this.cache = cache;
	}

	public Object get(String key) {
		try {
			logger.debug("cacheName:{}, get key:{}", cacheName, key);
			Object obj = cache.get(DigestUtils.md5Hex(key));
			return obj != null ? obj : null;
		} catch (Exception e) {
			return null;
		}
	}

	public void put(String key, Object value) {
		try {
			logger.debug("cacheName:{}, put key:{}", cacheName, key);
			Element element = new Element(DigestUtils.md5Hex(key), value);
			cache.put(element);
		} catch (Exception e) {
		}
	}

	public void remove(String key) {
		try {
			if (get(key) != null) {
				logger.debug("cacheName:{}, remove key:{}", cacheName, key);
				cache.remove(DigestUtils.md5Hex(key));
			}
		} catch (Exception e) {
		}
	}

	public void clearStatistics() {
		try {
			logger.debug("cacheName:{}, clear.", cacheName);
			cache.clearStatistics();
		} catch (Exception e) {
		}
	}
}
