package fr.pizzeria.doa;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	Pizza[] findAllPizzas();
	void saveNewPizza(Pizza newPizza);
	void updatePizza(String code, Pizza updatePizza);
	void deletePizza(String code);
}
