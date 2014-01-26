/**  
 * Copyright:   Copyright (c) 2014
 * Company:     LuckyStar Common Freamwork
 * @author:     Larry.Li  
 * @version:    v1.0.0
 * Create Date: 2014年1月24日 下午1:40:10
 */
package org.larry.fw.common.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;

import org.larry.fw.common.entity.AbstractEntity;
import org.springframework.orm.jpa.SharedEntityManagerCreator;
import org.springframework.util.Assert;

public class RepositoryHelper<T extends AbstractEntity<ID>, ID extends Serializable> implements EntityManagerHelper<T, ID> {

	private static EntityManager entityManager;
	private Class<T> entityClass;
	private boolean enableQueryCache = false;

	public RepositoryHelper(Class<T> entityClass) {
		this.entityClass = entityClass;
		// TODO: 这里判断实体类上是否配置了缓存 自定义 annotation

	}

	public static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		entityManager = SharedEntityManagerCreator.createSharedEntityManager(entityManagerFactory);
	}

	public static EntityManager getEntityManager() {
		Assert.notNull(entityManager, "entityManager must null, please see [org.larry.fw.common.repository.RepositoryHelper#setEntityManagerFactory]");
		return entityManager;
	}

	@Override
	public void persist(Object entity) {
		getEntityManager().persist(entity);
	}

	@Override
	public <T> T merge(T entity) {
		return getEntityManager().merge(entity);
	}

	@Override
	public void remove(Object entity) {
		getEntityManager().remove(entity);
	}

	@Override
	public <T> T find(Class<T> entityClass, Object primaryKey) {
		return getEntityManager().find(entityClass, primaryKey);
	}

	@Override
	public <T> T find(Class<T> entityClass, Object primaryKey, Map<String, Object> properties) {
		return getEntityManager().find(entityClass, primaryKey, properties);
	}

	@Override
	public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode) {
		return getEntityManager().find(entityClass, primaryKey, lockMode);
	}

	@Override
	public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode, Map<String, Object> properties) {
		return getEntityManager().find(entityClass, primaryKey, lockMode, properties);
	}

	@Override
	public <T> T getReference(Class<T> entityClass, Object primaryKey) {
		return getEntityManager().getReference(entityClass, primaryKey);
	}

	@Override
	public void flush() {
		getEntityManager().flush();
	}

	@Override
	public void setFlushMode(FlushModeType flushMode) {
		getEntityManager().setFlushMode(flushMode);
	}

	@Override
	public FlushModeType getFlushMode() {
		return getEntityManager().getFlushMode();
	}

	@Override
	public void lock(Object entity, LockModeType lockMode) {
		getEntityManager().lock(entity, lockMode);
	}

	@Override
	public void lock(Object entity, LockModeType lockMode, Map<String, Object> properties) {
		getEntityManager().lock(entity, lockMode, properties);
	}

	@Override
	public void refresh(Object entity) {
		getEntityManager().refresh(entity);
	}

	@Override
	public void refresh(Object entity, Map<String, Object> properties) {
		getEntityManager().refresh(entity, properties);
	}

	@Override
	public void refresh(Object entity, LockModeType lockMode) {
		getEntityManager().refresh(entity, lockMode);
	}

	@Override
	public void refresh(Object entity, LockModeType lockMode, Map<String, Object> properties) {
		getEntityManager().refresh(entity, lockMode, properties);
	}

	@Override
	public void clear() {
		getEntityManager().clear();
	}

	@Override
	public void detach(Object entity) {
		getEntityManager().detach(entity);
	}

	@Override
	public boolean contains(Object entity) {
		return getEntityManager().contains(entity);
	}

	@Override
	public LockModeType getLockMode(Object entity) {
		return getEntityManager().getLockMode(entity);
	}

	@Override
	public void setProperty(String propertyName, Object value) {
		getEntityManager().setProperty(propertyName, value);
	}

	@Override
	public Map<String, Object> getProperties() {
		return getEntityManager().getProperties();
	}

	@Override
	public Query createQuery(String qlString) {
		return getEntityManager().createQuery(qlString);
	}

	@Override
	public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
		return getEntityManager().createQuery(criteriaQuery);
	}

	@Override
	public Query createQuery(CriteriaUpdate updateQuery) {
		return getEntityManager().createQuery(updateQuery);
	}

	@Override
	public Query createQuery(CriteriaDelete deleteQuery) {
		return getEntityManager().createQuery(deleteQuery);
	}

	@Override
	public <T> TypedQuery<T> createQuery(String qlString, Class<T> resultClass) {
		return getEntityManager().createQuery(qlString, resultClass);
	}

	@Override
	public Query createNamedQuery(String name) {
		return getEntityManager().createNamedQuery(name);
	}

	@Override
	public <T> TypedQuery<T> createNamedQuery(String name, Class<T> resultClass) {
		return getEntityManager().createNamedQuery(name, resultClass);
	}

	@Override
	public Query createNativeQuery(String sqlString) {
		return getEntityManager().createNamedQuery(sqlString);
	}

	@Override
	public Query createNativeQuery(String sqlString, Class resultClass) {

		return null;
	}

	@Override
	public Query createNativeQuery(String sqlString, String resultSetMapping) {

		return null;
	}

	@Override
	public StoredProcedureQuery createNamedStoredProcedureQuery(String name) {

		return null;
	}

	@Override
	public StoredProcedureQuery createStoredProcedureQuery(String procedureName) {

		return null;
	}

	@Override
	public StoredProcedureQuery createStoredProcedureQuery(
			String procedureName, Class... resultClasses) {

		return null;
	}

	@Override
	public StoredProcedureQuery createStoredProcedureQuery(
			String procedureName, String... resultSetMappings) {

		return null;
	}

	@Override
	public void joinTransaction() {

	}

	@Override
	public boolean isJoinedToTransaction() {

		return false;
	}

	@Override
	public <T> T unwrap(Class<T> cls) {

		return null;
	}

	@Override
	public Object getDelegate() {

		return null;
	}

	@Override
	public void close() {

	}

	@Override
	public boolean isOpen() {

		return false;
	}

	@Override
	public EntityTransaction getTransaction() {

		return null;
	}

	@Override
	public EntityManagerFactory getEntityManagerFactory() {

		return null;
	}

	@Override
	public CriteriaBuilder getCriteriaBuilder() {

		return null;
	}

	@Override
	public Metamodel getMetamodel() {

		return null;
	}

	@Override
	public <T> EntityGraph<T> createEntityGraph(Class<T> rootType) {

		return null;
	}

	@Override
	public EntityGraph<?> createEntityGraph(String graphName) {

		return null;
	}

	@Override
	public EntityGraph<?> getEntityGraph(String graphName) {

		return null;
	}

	@Override
	public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> entityClass) {

		return null;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
