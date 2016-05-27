package fr.pizzeria.ihm.menu.option;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

import fr.pizzeria.doa.DaoFactory;
import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerBestPizzaOptionMenu extends AbstractOptionMenu {

	private static final String BEST_PIZZA_LIBELLE = "Afficher pizza la plus cher";
	
	public ListerBestPizzaOptionMenu(DaoFactory daoFactory) {
		super(BEST_PIZZA_LIBELLE, daoFactory);
	}

	@Override
	public boolean execute() {
		System.out.println("Lister pizza la plus cher menu");
		IPizzaDao pizzaDao = factoryDao.getPizzaDao();
		Set<Pizza> pizzas = pizzaDao.findAllPizzas();
		Optional<Pizza> maximum = pizzas.stream()
		.max(Comparator.comparing(Pizza::getPrix));
		System.out.println(maximum.get().toString());
		return true;
	}

}
