package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;
import java.util.Set;

import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends AbstractOptionMenu {

	private static final String SUPPRIMER_PIZZA_LIBELLE = "Supprimer une pizza";

	public SupprimerPizzaOptionMenu(Scanner scanner, IPizzaDao pizzaDao) {
		super(SUPPRIMER_PIZZA_LIBELLE, scanner, pizzaDao);
	}

	@Override
	public boolean execute() {
		System.out.println("Suppression d'une pizza");
		Set<Pizza> pizzas = pizzaDao.findAllPizzas();
		
		pizzas.stream()
		.forEach(pi -> System.out.println(pi.toString()));
		
		System.out.println("Veuillez choisir la pizza à supprimer.");
		System.out.println("(99 pour abandonner)");
		String numberPizza = sc.next();
		try{
			pizzaDao.deletePizza(numberPizza);
			System.out.println("Pizza supprimer");
		}catch(DaoException e){
			System.err.println(e.getMessage());
		}
		return true;
	}

}
