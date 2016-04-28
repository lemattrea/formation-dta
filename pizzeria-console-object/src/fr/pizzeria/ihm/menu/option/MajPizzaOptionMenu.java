package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizza.exception.UpdatePizzaException;
import fr.pizzeria.doa.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class MajPizzaOptionMenu extends AbstractOptionMenu {

	private static final String MAJ_PIZZA_LIBELLE = "Mettre à jour une pizza";

	public MajPizzaOptionMenu(Scanner scanner, IPizzaDao pizzaDao) {
		super(MAJ_PIZZA_LIBELLE, scanner, pizzaDao);
	}

	@Override
	public boolean execute() {
		System.out.println("Mise à jour d’une pizza");
		Pizza[] pizzas = pizzaDao.findAllPizzas();
		
		for(Pizza p : pizzas) {
			if (p != null) {
				System.out.println(p.getCode()+"->"+p.getNom()+"-> ("+p.getPrix()+" €)");
			}
		}
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
			try{
				pizzaDao.updatePizza(numPizza, piz);
				System.out.println("Pizza mise à jour");
			}catch(UpdatePizzaException e){
				System.out.println(e.getMessage());
			}
			
		}
		return true;
	}

}
