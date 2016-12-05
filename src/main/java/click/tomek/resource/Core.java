package click.tomek.resource;

import click.tomek.entity.Something;
import click.tomek.service.CoreService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/core")
public class Core {

	@Autowired
	private CoreService coreService;

	@GET
	@Path("/status")
	@Produces("text/html")
	public String get(){
		return "Hello world";
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Something get(@PathParam("id") long id){
		return coreService.get(id);
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Something post(Something something){
		return coreService.post(something);
	}
}
