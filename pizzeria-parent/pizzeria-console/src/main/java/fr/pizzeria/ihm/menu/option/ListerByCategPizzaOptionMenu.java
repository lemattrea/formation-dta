package fr.pizzeria.ihm.menu.option;

import java.util.Comparator;
import java.util.Set;

import fr.pizzeria.doa.DaoFactory;
import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerByCategPizzaOptionMenu extends AbstractOptionMenu {
	
	private static final String LISTER_PIZZA_LIBELLE = "Lister pizza par catégorie";

	public ListerByCategPizzaOptionMenu(DaoFactory daoFactory) {
		super(LISTER_PIZZA_LIBELLE, daoFactory);
	}

	@Override
	public boolean execute() {
		System.out.println("Lister pizza menu");
		IPizzaDao daoPizz = factoryDao.getPizzaDao();
		Set<Pizza> pizzas = daoPizz.findAllPizzas();
		pizzas.stream()
		.sorted(Comparator.comparing(Pizza::getCategorie).thenComparing(Pizza::getCode))
		//.collect(Collectors.groupingBy(Pizza::getCategorie))
		.forEach(pi -> System.out.println(pi.toString()));
		return true;
	}

}
