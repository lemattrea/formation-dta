package fr.pizzeria.doa.pizza;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImplJpa implements IPizzaDao {

	private EntityManagerFactory em;

	public PizzaDaoImplJpa(EntityManagerFactory em) {
		this.em = em;
	}

	@Override
	public Set<Pizza> findAllPizzas() {

		Set<Pizza> pizzas = new TreeSet<>();

		EntityManager emCourant = em.createEntityManager();
		TypedQuery<Pizza> query = emCourant.createQuery("select p from Pizza p", Pizza.class);
		pizzas = query.getResultList().stream().collect(Collectors.toSet());

		emCourant.close();
		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza newPizza) {
		EntityManager emCourant = em.createEntityManager();
		EntityTransaction trans = emCourant.getTransaction();
		// début de la transaction
		trans.begin();
		emCourant.persist(newPizza);
		// fin de la trn
		trans.commit();
		emCourant.close();
	}

	@Override
	public void updatePizza(String code, Pizza updatePizza) {
		
		EntityManager emCourant = em.createEntityManager();
		EntityTransaction trans = emCourant.getTransaction();
		
		// début de la transaction
		trans.begin();
		TypedQuery<Pizza> query = emCourant.createQuery("select h from Hotel h where h.code=:codePizza", Pizza.class);
		query.setParameter("codePizza", code);

		Pizza pizza = query.getSingleResult();
		if (pizza != null) {
			Pizza newPizza = new Pizza();
			newPizza.setCode(code);
			newPizza.setNom(updatePizza.getNom());
			newPizza.setPrix(updatePizza.getPrix());
			emCourant.merge(newPizza);
		}
		// fin de la transaction
		trans.commit();
		emCourant.close();
	}

	@Override
	public void deletePizza(String code) {

		EntityManager emCourant = em.createEntityManager();
		EntityTransaction trans = emCourant.getTransaction();
		// début de la transaction
		trans.begin();
		Pizza p = emCourant.find(Pizza.class, code);

		if (p != null) {
			emCourant.remove(p);
		}
		// fin de la trn
		trans.commit();
		emCourant.close();
	}

	@Override
	public boolean transactionInsertPizza(List<Pizza> pizzas) {
		
		EntityManager emCourant = em.createEntityManager();
		EntityTransaction trans = emCourant.getTransaction();
		try {
			// début de la transaction
			trans.begin();
			for (Pizza pizza : pizzas) {
				emCourant.persist(pizza);
			}
			
			// fin de la transaction
			trans.commit();
			emCourant.close();
			return true;

		} catch (PersistenceException | IllegalStateException e) {
			emCourant.close();
			return false;
		}
		
		
	}

}
