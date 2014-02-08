/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月24日 下午2:41:27
 */
package org.larry.fw.common.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.larry.fw.module.logger.Logger;
import org.larry.fw.module.logger.LoggerFactory;

public class ReflectUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(ReflectUtils.class);

	/**
	 * 得到指定类型的指定位置的泛型实参
	 * @param clazz
	 * @param index
	 * @param <T>
	 * @return
	 */
	public static <T> Class<T> findParameterizedType(Class<?> clazz, int index) {
		Type type = clazz.getGenericSuperclass();
		//CGLUB subclass target object(泛型在父类上), 如果本类上没有泛型，就在父类上找泛型
		if (!(type instanceof ParameterizedType)) {
			type = clazz.getSuperclass().getGenericSuperclass();
		}
		// 如果父类上还没有泛型就直接返回null
		if (!(type instanceof ParameterizedType)) {
			return null;
		}
		
		Type[] types = ((ParameterizedType) type).getActualTypeArguments();
		if (types == null || types.length == 0) {
			return null;
		}
		return (Class<T>) types[index];
	}

}
