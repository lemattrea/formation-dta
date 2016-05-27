/**
 * 
 */
package fr.pizzeria.admin.metier;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Pizza;

/**
 * @author ETY
 *
 */
@Stateless
public class PizzaService{
	
	@PersistenceContext(unitName="pizzeria-webapp") private EntityManager em;
	
	public Set<Pizza> findAllPizzas() {
		
		Set<Pizza> pizzas;
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);
		pizzas = query.getResultList().stream().collect(Collectors.toSet());

		return pizzas;
	}

	public void saveNewPizza(Pizza newPizza) {
		em.persist(newPizza);
	}

	public void updatePizza(String code, Pizza updatePizza) {
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p where p.code=:codePizza", Pizza.class);
		query.setParameter("codePizza", code);

		Pizza pizza = query.getSingleResult();
		if (pizza != null) {
			Pizza newPizza = new Pizza();
			newPizza.setCode(code);
			newPizza.setNom(updatePizza.getNom());
			newPizza.setPrix(updatePizza.getPrix());
			newPizza.setCategorie(updatePizza.getCategorie());
			em.merge(newPizza);
		}
	}

	public void deletePizza(String code) {
		Pizza p = em.find(Pizza.class, code);

		if (p != null) {
			em.remove(p);
		}
	}

	public boolean transactionInsertPizza(List<Pizza> pizzas) {
		try {
			for (Pizza pizza : pizzas) {
				em.persist(pizza);
			}
			return true;
		} catch (PersistenceException | IllegalStateException e) {
			return false;
		}
	}

}
