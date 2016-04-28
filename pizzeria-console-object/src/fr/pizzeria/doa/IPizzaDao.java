package fr.pizzeria.doa;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	Pizza[] findAllPizzas();
	boolean saveNewPizza(Pizza newPizza);
	boolean updatePizza(String code, Pizza updatePizza);
	boolean deletePizza(String code);
}
