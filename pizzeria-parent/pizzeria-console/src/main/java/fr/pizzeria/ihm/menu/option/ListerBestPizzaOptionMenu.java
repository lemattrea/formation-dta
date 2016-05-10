package fr.pizzeria.ihm.menu.option;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

import fr.pizzeria.doa.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerBestPizzaOptionMenu extends AbstractOptionMenu {

	private static final String BEST_PIZZA_LIBELLE = "Afficher pizza la plus cher";
	
	public ListerBestPizzaOptionMenu(IPizzaDao pizzaDao) {
		super(BEST_PIZZA_LIBELLE, pizzaDao);
	}

	@Override
	public boolean execute() {
		System.out.println("Lister pizza la plus cher menu");
		Set<Pizza> pizzas = pizzaDao.findAllPizzas();
		Optional<Pizza> maximum = pizzas.stream()
		.max(Comparator.comparing(Pizza::getPrix));
		System.out.println(maximum.get().toString());
		return true;
	}

}
