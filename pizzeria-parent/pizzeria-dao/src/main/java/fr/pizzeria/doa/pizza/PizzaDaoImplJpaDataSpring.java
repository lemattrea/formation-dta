package fr.pizzeria.doa.pizza;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.repos.PizzaRepository;

@Transactional
public class PizzaDaoImplJpaDataSpring implements IPizzaDao {

	@PersistenceContext private EntityManager em;
	@Autowired private BatchPizza batch;
	@Autowired private PizzaRepository pizzaRepository;

	@Override
	public Set<Pizza> findAllPizzas() {
		return new TreeSet<>(pizzaRepository.findAll());
	}

	@Override
	public void saveNewPizza(Pizza newPizza) {
		pizzaRepository.save(newPizza);
	}

	@Override
	public void updatePizza(String code, Pizza updatePizza) {
		pizzaRepository.save(updatePizza);
	}

	@Override
	public void deletePizza(String code) {
		pizzaRepository.delete(code);
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
				ope = batch.saveDataPizza(p);
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
