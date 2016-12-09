package click.tomek.resource;

import click.tomek.entity.Parent;
import click.tomek.entity.Something;
import click.tomek.service.CoreService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/core")
public class Core {

	@Autowired
	private CoreService coreService;

	@GET
	@Path("/status")
	@Produces("text/html")
	public String get() {
		return "Hello world";
	}

	@GET
	@Path("/something/{id}")
	@Produces("application/json")
	public Something getSomething(@PathParam("id") long id) {
		return coreService.get(id);
	}

	/**
	 * Sample request:
	 * {
	 * "name": "something K",
	 * "values": [
	 * 1.2,
	 * 3.4,
	 * 5.6
	 * ]
	 * }
	 *
	 * @param something
	 * @return
	 */
	@POST
	@Path("/something")
	@Consumes("application/json")
	@Produces("application/json")
	public Something postSomething(Something something) {
		return coreService.post(something);
	}

	@GET
	@Path("/parent/{id}")
	@Produces("application/json")
	public Parent getParent(@PathParam("id") long id) {
		return coreService.getParent(id);
	}

	/**
	 * Sample request:
	 * {
	 * "name":"parent A",
	 * "somethings":[
	 * {
	 * "name":"something K",
	 * "values":[
	 * 1.2, 3.4, 5.6
	 * ]
	 * },
	 * {
	 * "name":"something L",
	 * "values":[
	 * 6.5, 4.3, 2.1
	 * ]
	 * }
	 * ]
	 * }
	 *
	 * @param parent
	 * @return
	 */
	@POST
	@Path("/parent")
	@Consumes("application/json")
	@Produces("application/json")
	public Parent postParent(Parent parent) {
		return coreService.postParent(parent);
	}

	@GET
	@Path("/parent")
	@Produces("application/json")
	public List<Parent> getParentList() {
		return coreService.listParent();
	}
}
