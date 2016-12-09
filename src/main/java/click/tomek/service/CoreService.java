package click.tomek.service;

import click.tomek.dao.ParentDAO;
import click.tomek.dao.SomethingDAO;
import click.tomek.entity.Parent;
import click.tomek.entity.Something;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CoreService {

	@Autowired
	private SomethingDAO somethingDAO;

	@Autowired
	private ParentDAO parentDAO;

	public Something get(long id) {
		return somethingDAO.get(id);
	}

	public Something post(Something something) {
		return somethingDAO.add(something);
	}

	public Parent getParent(long id) {
		return parentDAO.get(id);
	}

	public Parent postParent(Parent parent) {
		return parentDAO.add(parent);
	}

	public List<Parent> listParent() {
		return parentDAO.list();
	}
}
