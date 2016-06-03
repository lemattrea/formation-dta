package fr.pizzeria.doa.pizza;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.model.Pizza;

@Transactional
public class PizzaDaoImplJpaSpring implements IPizzaDao {

	@PersistenceContext private EntityManager em;
	@Autowired private BatchPizza batch;

	@Override
	public Set<Pizza> findAllPizzas() {
		Set<Pizza> pizzas;
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);
		pizzas = query.getResultList().stream().collect(Collectors.toSet());
		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza newPizza) {
		em.persist(newPizza);
	}

	@Override
	public void updatePizza(String code, Pizza updatePizza) {
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p where p.id=:codePizza", Pizza.class);
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

	@Override
	public void deletePizza(String code) {
		Pizza p = em.find(Pizza.class, code);
		if (p != null) {
			em.remove(p);
		}
	}

	@Override
	public boolean transactionInsertPizza(List<Pizza> pizzas) {
		return true;
	}
	
	@Transactional
	public int fullTransaction(Set<Pizza> pizzas) {
		Logger LOG = Logger.getLogger(IPizzaDao.class.toString());
		int compteur = 0;
		boolean ope;
		List<List<Pizza>> bestList = ListUtils.partition(pizzas.stream().collect(Collectors.toList()), 3);

		for(List<Pizza> p : bestList) {
			try {
				ope = batch.savePizza(p);
				if(ope) {
					compteur += p.size();
				}
			}catch (Exception e) {
				LOG.log(Level.WARNING, "Erreur lors de la création de la pizza :"+e.getMessage());
			}
		}
		return compteur;
	}

}
