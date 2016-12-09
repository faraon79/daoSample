package click.tomek.dao;

import click.tomek.entity.Parent;

import javax.persistence.Query;
import java.util.List;

public class ParentDAO extends GenericDAO<Parent> {

	public ParentDAO() {
		super(Parent.class);
	}

	@SuppressWarnings("unchecked")
	public List<Parent> list() {
		Query query = em.createQuery("from Parent parent");
		return query.getResultList();
	}
}
