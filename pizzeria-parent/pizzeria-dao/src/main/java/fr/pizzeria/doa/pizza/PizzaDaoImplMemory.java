package fr.pizzeria.doa.pizza;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.NotImplementException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplMemory implements IPizzaDao {
	private Map<String, Pizza> pizzas = new HashMap<>();
	
	public PizzaDaoImplMemory() {
		pizzas.put("PEP",new Pizza("PEP","Pépéroni",new BigDecimal("12.50"), CategoriePizza.SANS_VIANDE));
		pizzas.put("MAR",new Pizza("MAR","Margherita",new BigDecimal("12.50"), CategoriePizza.VIANDE));
		pizzas.put("REI",new Pizza("REI","La Reine",new BigDecimal("12.50"), CategoriePizza.POISSON));
		pizzas.put("FRO",new Pizza("FRO","La 4 fromages",new BigDecimal("12.50"), CategoriePizza.SANS_VIANDE));
		pizzas.put("CAN",new Pizza("CAN","La cannibale",new BigDecimal("12.50"), CategoriePizza.VIANDE));
		pizzas.put("SAV",new Pizza("SAV","La savoyarde",new BigDecimal("15"), CategoriePizza.SANS_VIANDE));
		pizzas.put("ORI",new Pizza("ORI","L'orientale",new BigDecimal("12.50"), CategoriePizza.POISSON));
		pizzas.put("IND",new Pizza("IND","L'indienne",new BigDecimal("12.50"), CategoriePizza.SANS_VIANDE));
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

	/**
	 * Fonstionnalité non accessible pour cette dao
	 */
	@Override
	public boolean transactionInsertPizza(List<Pizza> p) {
		throw new NotImplementException("Veuillez configurer l'application avec une implémentation base de données");
	}

}
