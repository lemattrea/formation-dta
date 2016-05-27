package fr.pizzeria.admin.api.rest;

import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.metier.ClientService;
import fr.pizzeria.model.Client;

@Path("/clients")
public class ClientsRessources {

	@Inject private ClientService clientService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Client> list() {
		return clientService.findAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void cree(Client c) {
		clientService.saveNew(c);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void modifier(Client c) {
		clientService.update(c.getId(), c);
	}
	
	@DELETE
	@Path("/{code}")
	public void delete(@PathParam("code") String code) {
		clientService.delete(code);;
	}

}
