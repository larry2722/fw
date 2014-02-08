/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月26日 下午11:39:57
 */
package org.larry.fw.common.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.larry.fw.common.entity.AbstractEntity;

public interface EntityManagerHelper<E extends AbstractEntity<ID>, ID extends Serializable> extends EntityManager {

}
