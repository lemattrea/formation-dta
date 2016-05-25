package fr.pizzeria.doa.pizza;

import java.util.List;
import java.util.Set;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	IPizzaDao DEFAULT_IMPLEMENTATION = new PizzaDaoImplMemory();
	
	Set<Pizza> findAllPizzas();
	void saveNewPizza(Pizza newPizza);
	void updatePizza(String code, Pizza updatePizza);
	void deletePizza(String code);
	boolean transactionInsertPizza(List<Pizza> p);
}
