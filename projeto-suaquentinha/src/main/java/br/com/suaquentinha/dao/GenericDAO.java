package br.com.suaquentinha.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public abstract class GenericDAO<T, I extends Serializable> {

	private Class<T> persistedClass;
	
	@PersistenceContext
	protected EntityManager entityManager;

	protected GenericDAO() {
	}

	protected GenericDAO(Class<T> persistedClass) {
		this();
		this.persistedClass = persistedClass;
	}

	public T salvar(T entity) {		
		entityManager.persist(entity);
		entityManager.flush();
		return entity;
	}

	public T atualizar(T entity) {
		entityManager.merge(entity);
		entityManager.flush();
		return entity;
	}
	
	/*
	public void remover(I id) {
		T entity = entityManager.find(persistedClass, id);		
		T mergedEntity = entityManager.merge(entity);
		entityManager.remove(mergedEntity);
		entityManager.flush();
	}*/

	public T obter(I id) {
		return entityManager.find(persistedClass, id);
	}
	/*
	public List<T> listar() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		return entityManager.createQuery(query).getResultList();
	}*/
}
