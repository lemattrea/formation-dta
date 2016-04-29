package fr.pizzeria.ihm.menu.option;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import fr.pizzeria.doa.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzaOptionMenu extends AbstractOptionMenu {

	private static final String LISTER_PIZZA_LIBELLE = "Lister pizza";

	public ListerPizzaOptionMenu(IPizzaDao pizzaDao) {
		super(LISTER_PIZZA_LIBELLE, pizzaDao);
	}

	@Override
	public boolean execute() {
		System.out.println("Lister pizza menu");
		Set<Pizza> pizzas = pizzaDao.findAllPizzas();
		
		for(Pizza p : pizzas) {
			System.out.println(p.toString());
		}
		return true;
	}

}
