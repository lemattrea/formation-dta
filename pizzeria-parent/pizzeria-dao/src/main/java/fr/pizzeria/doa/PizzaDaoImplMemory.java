package fr.pizzeria.doa;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplMemory implements IPizzaDao {
	private Map<String, Pizza> pizzas = new HashMap<String, Pizza>();
	
	public PizzaDaoImplMemory() {
		pizzas.put("PEP",new Pizza("PEP","Pépéroni",12.50, CategoriePizza.SANS_VIANDE));
		pizzas.put("MAR",new Pizza("MAR","Margherita",12.50, CategoriePizza.VIANDE));
		pizzas.put("REI",new Pizza("REI","La Reine",12.50, CategoriePizza.POISSON));
		pizzas.put("FRO",new Pizza("FRO","La 4 fromages",12.50, CategoriePizza.SANS_VIANDE));
		pizzas.put("CAN",new Pizza("CAN","La cannibale",12.50, CategoriePizza.VIANDE));
		pizzas.put("SAV",new Pizza("SAV","La savoyarde",15, CategoriePizza.SANS_VIANDE));
		pizzas.put("ORI",new Pizza("ORI","L'orientale",12.50, CategoriePizza.POISSON));
		pizzas.put("IND",new Pizza("IND","L'indienne",12.50, CategoriePizza.SANS_VIANDE));
	}
	
	@Override
	public Set<Pizza> findAllPizzas() {
		return new TreeSet<Pizza>(pizzas.values());
	}

	@Override
	public void saveNewPizza(Pizza newPizza) {
		if(pizzas.containsKey(newPizza.getCode())){
			throw new SavePizzaException("Cette pizza existe d�j�");
		}
		pizzas.put(newPizza.getCode(), newPizza);
	}

	@Override
	public void updatePizza(String code, Pizza updatePizza) {
		if(!pizzas.containsKey(code)){
			throw new UpdatePizzaException("Cette pizza n'existe pas");
		}
		pizzas.remove(code);
		pizzas.put(code, updatePizza);
	}

	@Override
	public void deletePizza(String code) {
		if(!pizzas.containsKey(code)){
			throw new DeletePizzaException("Cette pizza n'existe pas");
		}
		pizzas.remove(code);
	}

}
