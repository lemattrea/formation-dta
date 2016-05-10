package fr.pizzeria.ihm.menu.option;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.doa.IPizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class MajPizzaOptionMenu extends AbstractOptionMenu {

	private static final String MAJ_PIZZA_LIBELLE = "Mettre � jour une pizza";

	public MajPizzaOptionMenu(Scanner scanner, IPizzaDao pizzaDao) {
		super(MAJ_PIZZA_LIBELLE, scanner, pizzaDao);
	}

	@Override
	public boolean execute() {
		System.out.println("Mise à jour d'une pizza");
		Set<Pizza> pizzas = pizzaDao.findAllPizzas();
		
		pizzas.stream()
		.forEach(pi -> System.out.println(pi.toString()));
		
		System.out.println("(99 pour abandonner)");
		System.out.println("Veuillez choisir la pizza à modifier.");
		
		String numPizza = sc.next();
		if (!numPizza.equals("99")) {
			System.out.println("Veuillez saisir le code");
			Pizza piz = new Pizza();
			piz.setCode(sc.next());
			System.out.println("Veuillez saisir le nom (sans espace)");
			piz.setNom(sc.next());
			System.out.println("Veuillez saisir le prix");
			piz.setPrix(sc.nextDouble());
			
			CategoriePizza[] catePizzas = CategoriePizza.values();
			Arrays.asList(catePizzas).stream().forEach(cat -> System.out.println(cat.ordinal()+ " -> " + cat.getLibelle()));
			
			int saisie = sc.nextInt();
			piz.setCategorie(catePizzas[saisie]);
			
			try{
				pizzaDao.updatePizza(numPizza, piz);
				System.out.println("Pizza mise � jour");
			}catch(DaoException e){
				System.err.println(e.getMessage());
			}
			
		}
		return true;
	}

}
