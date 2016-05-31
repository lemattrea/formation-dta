package fr.pizzeria.doa.pizza;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImplApi implements IPizzaDao {

	private String token;

	public PizzaDaoImplApi(EntityManagerFactory em) {
		javax.ws.rs.client.Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/pizzeria-webapp");
		Invocation.Builder builder = target.path("api").path("login").request();

		// Récupérer un objet particulier
		Response post = builder.post(Entity.entity("email=admin@admin.fr&motDePasse=admin", MediaType.APPLICATION_FORM_URLENCODED_TYPE));
		token = post.readEntity(String.class);
	}

	@Override
	public Set<Pizza> findAllPizzas() {
		javax.ws.rs.client.Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/pizzeria-webapp");
		Invocation.Builder builder = target.path("api").path("pizzas").request().header("auth", token);

		// Récupérer un objet particulier
		return builder.get(new GenericType<Set<Pizza>>() {});

	}

	@Override
	public void saveNewPizza(Pizza newPizza) {
		
		javax.ws.rs.client.Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/pizzeria-webapp");
		Invocation.Builder builder = target.path("api").path("pizzas").request().header("auth", token);
		
		builder.post(Entity.entity(newPizza, MediaType.APPLICATION_JSON));
		
		
	}

	@Override
	public void updatePizza(String code, Pizza updatePizza) {

		javax.ws.rs.client.Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/pizzeria-webapp");
		Invocation.Builder builder = target.path("api").path("pizzas").request().header("auth", token);
		
		builder.put(Entity.entity(updatePizza, MediaType.APPLICATION_JSON));
		
	}

	@Override
	public void deletePizza(String code) {

		javax.ws.rs.client.Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/pizzeria-webapp");
		Invocation.Builder builder = target.path("api").path("pizzas").path(code).request().header("auth", token);
		
		builder.delete();
	}

	@Override
	public boolean transactionInsertPizza(List<Pizza> pizzas) {
		return true;
	}

}
