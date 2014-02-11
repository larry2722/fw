/**  
 * Copyright:   Copyright (c) 2014
 * Company:     Aicent RCC admin portal
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月23日 下午7:01:33
 */
package com.aicent.fw.common.schedule;

import java.util.Stack;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.orm.jpa.EntityManagerHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.aicent.fw.modules.logger.Logger;
import com.aicent.fw.modules.logger.LoggerFactory;

public abstract class BaseTask implements InitializingBean {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final Stack<EntityManagerHolder> bindings = new Stack<EntityManagerHolder>();
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	public final void run() {
		try {
			bind();
			execute();
		} catch (Exception e) {
			logger.error("task error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			unbind();
		}
	}
	
	protected abstract void execute();

	public void afterPropertiesSet() throws Exception {
		execute();
	}
	
	private void bind() {
		synchronized (bindings) {
			EntityManagerHolder current = (EntityManagerHolder) TransactionSynchronizationManager.getResource(entityManagerFactory);
			
			if (current != null) {
				TransactionSynchronizationManager.unbindResource(entityManagerFactory);
			}
			
			bindings.push(current);
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			TransactionSynchronizationManager.bindResource(entityManagerFactory, new EntityManagerHolder(entityManager));
		}
	}
	
	private void unbind() {
		synchronized (bindings) {
			EntityManagerHolder current = (EntityManagerHolder) TransactionSynchronizationManager.getResource(entityManagerFactory);
			
			if (current != null) {
				TransactionSynchronizationManager.unbindResource(entityManagerFactory);
				EntityManagerFactoryUtils.closeEntityManager(current.getEntityManager());
			}
			
			Object holder = null;
			if (bindings.size() > 0) {
				holder = bindings.pop();
			}
			if (holder != null) {
				TransactionSynchronizationManager.bindResource(entityManagerFactory, holder);
			}
		}
	}
	
	public void setWarehouseEntityManagerFactory(EntityManagerFactory warehouseEntityManagerFactory) {
		this.entityManagerFactory = warehouseEntityManagerFactory;
	}

}
