package click.tomek.dao;

import click.tomek.entity.Something;

public class SomethingDAO extends GenericDAO<Something> {

	public SomethingDAO() {
		super(Something.class);
	}
}
