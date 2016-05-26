/**
 * 
 */
package fr.pizzeria.admin.metier;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY
 *
 */
@ApplicationScoped
public class PizzaService{

	@Inject @Named("PizzaDaoImplMemory") IPizzaDao pizzaDao;
	
	public Set<Pizza> findAllPizzas() {
		return pizzaDao.findAllPizzas();
	}

	public void saveNewPizza(Pizza newPizza) {
		pizzaDao.saveNewPizza(newPizza);
	}

	public void updatePizza(String code, Pizza updatePizza) {
		pizzaDao.updatePizza(code, updatePizza);	
	}

	public void deletePizza(String code) {
		pizzaDao.deletePizza(code);
	}

	public boolean transactionInsertPizza(List<Pizza> p) {
		return pizzaDao.transactionInsertPizza(p);
	}

}
