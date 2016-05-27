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

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.model.Pizza;

@Path("/pizzas")
public class PizzasRessources {

	@Inject private PizzaService pizzaService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Pizza> list() {
		return pizzaService.findAllPizzas();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void cree(Pizza p) {
		pizzaService.saveNewPizza(p);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void modifier(Pizza p) {
		pizzaService.updatePizza(p.getCode(), p);
	}
	
	@DELETE
	@Path("/{code}")
	public void delete(@PathParam("code") String code) {
		pizzaService.deletePizza(code);
	}

}
