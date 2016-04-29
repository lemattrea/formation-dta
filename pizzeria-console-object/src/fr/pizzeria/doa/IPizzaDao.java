package fr.pizzeria.doa;

import java.util.List;
import java.util.Set;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	Set<Pizza> findAllPizzas();
	void saveNewPizza(Pizza newPizza);
	void updatePizza(String code, Pizza updatePizza);
	void deletePizza(String code);
}
