package fr.pizzeria.doa.pizza;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.commons.collections4.ListUtils;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	IPizzaDao DEFAULT_IMPLEMENTATION = new PizzaDaoImplMemory();
	
	Set<Pizza> findAllPizzas();
	void saveNewPizza(Pizza newPizza);
	void updatePizza(String code, Pizza updatePizza);
	void deletePizza(String code);
	boolean transactionInsertPizza(List<Pizza> p);
	
	
	public default int fullTransaction(Set<Pizza> pizzas) {
		Logger LOG = Logger.getLogger(IPizzaDao.class.toString());
		int compteur = 0;
		boolean ope;
		List<List<Pizza>> bestList = ListUtils.partition(pizzas.stream().collect(Collectors.toList()), 3);

		for(List<Pizza> p : bestList) {
			try {
				ope = this.transactionInsertPizza(p);
				if(ope) {
					compteur += p.size();
				}
			}catch (SavePizzaException e) {
				LOG.log(Level.WARNING, "Erreur lors de la création de la pizza :"+e.getMessage());
			}
		}
		return compteur;
	}
}
