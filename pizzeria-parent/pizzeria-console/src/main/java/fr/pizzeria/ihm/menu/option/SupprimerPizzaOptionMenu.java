package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;
import java.util.Set;

import fr.pizzeria.doa.DaoFactory;
import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends AbstractOptionMenu {

	private static final String SUPPRIMER_PIZZA_LIBELLE = "Supprimer une pizza";

	public SupprimerPizzaOptionMenu(Scanner scanner, DaoFactory daoFactory) {
		super(SUPPRIMER_PIZZA_LIBELLE, scanner, daoFactory);
	}

	@Override
	public boolean execute() {
		System.out.println("Suppression d'une pizza");
		IPizzaDao daoPizz = factoryDao.getPizzaDao();
		Set<Pizza> pizzas = daoPizz.findAllPizzas();
		
		pizzas.stream()
		.forEach(pi -> System.out.println(pi.toString()));
		
		System.out.println("Veuillez choisir la pizza à supprimer.");
		System.out.println("(99 pour abandonner)");
		String numberPizza = sc.next();
		try{
			daoPizz.deletePizza(numberPizza);
			System.out.println("Pizza supprimer");
		}catch(DaoException e){
			System.err.println(e.getMessage());
		}
		return true;
	}

}
