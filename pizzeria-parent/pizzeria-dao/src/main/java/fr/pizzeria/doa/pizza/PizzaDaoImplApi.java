package fr.pizzeria.doa.pizza;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImplApi implements IPizzaDao {

	private EntityManagerFactory em;

	public PizzaDaoImplApi(EntityManagerFactory em) {
		this.em = em;
	}

	@Override
	public Set<Pizza> findAllPizzas() {
		javax.ws.rs.client.Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/pizzeria-webapp");
		Invocation.Builder builder = target.path("api").path("pizzas").request();

		// Récupérer un objet particulier
		return builder.get(new GenericType<Set<Pizza>>() {});

	}

	@Override
	public void saveNewPizza(Pizza newPizza) {
		
		javax.ws.rs.client.Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/pizzeria-webapp");
		Invocation.Builder builder = target.path("api").path("pizzas").request();
		
		Response post = builder.post(Entity.entity(newPizza, MediaType.APPLICATION_JSON));
		
		
	}

	@Override
	public void updatePizza(String code, Pizza updatePizza) {

		javax.ws.rs.client.Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/pizzeria-webapp");
		Invocation.Builder builder = target.path("api").path("pizzas").request();
		
		Response post = builder.put(Entity.entity(updatePizza, MediaType.APPLICATION_JSON));
		
	}

	@Override
	public void deletePizza(String code) {

		javax.ws.rs.client.Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/pizzeria-webapp");
		Invocation.Builder builder = target.path("api").path("pizzas").path(code).request();
		
		Response post = builder.delete();
	}

	@Override
	public boolean transactionInsertPizza(List<Pizza> pizzas) {
		return true;
	}

}
