package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.doa.IPizzaDao;
import fr.pizzeria.doa.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenu extends AbstractOptionMenu {

	private static final String NOUVELLE_PIZZA_LIBELLE = "Ajouter une nouvelle pizza";

	public NouvellePizzaOptionMenu(Scanner scanner, IPizzaDao pizzaDao) {
		super(NOUVELLE_PIZZA_LIBELLE, scanner, pizzaDao);
	}

	@Override
	public boolean execute() {
		System.out.println("Ajout d�une nouvelle pizza");
		
		System.out.println("Veuillez saisir le code");
		Pizza piz = new Pizza();
		piz.setCode(sc.next());
		System.out.println("Veuillez saisir le nom (sans espace)");
		piz.setNom(sc.next());
		System.out.println("Veuillez saisir le prix");
		piz.setPrix(sc.nextDouble());
		if(pizzaDao.saveNewPizza(piz)){
			System.out.println("Pizza cr�e");
		}else{
			System.err.println("Erreur lors de la cr�ation de la pizza");
		}
		return true;
	}

}