package click.tomek.dao;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDAO<E> {

	private Class<E> type;

	@PersistenceContext
	protected EntityManager em;

	public GenericDAO(Class<E> type) {
		this.type = type;
	}

	public E get(Object id) {
		return em.find(type, id);
	}

	@Transactional
	public E add(E entity) {
		em.persist(entity);
		em.flush();
		return entity;
	}

	@Transactional
	public E update(E entity) {
		return em.merge(entity);
	}

	public void delete(E entity) {
		em.remove(entity);
	}
}
