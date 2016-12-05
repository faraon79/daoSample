package click.tomek.service;

import click.tomek.dao.SomethingDAO;
import click.tomek.entity.Something;
import org.springframework.beans.factory.annotation.Autowired;

public class CoreService {

	@Autowired
	private SomethingDAO somethingDAO;

	public Something get(long id) {
		return somethingDAO.get(id);
	}

	public Something post(Something request) {
		Something a = new Something(request.getName(), request.getValues());
		return somethingDAO.add(a);
	}
}
