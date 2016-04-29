package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizza.exception.DaoException;
import fr.pizzeria.doa.IPizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenu extends AbstractOptionMenu {

	private static final String NOUVELLE_PIZZA_LIBELLE = "Ajouter une nouvelle pizza";

	public NouvellePizzaOptionMenu(Scanner scanner, IPizzaDao pizzaDao) {
		super(NOUVELLE_PIZZA_LIBELLE, scanner, pizzaDao);
	}

	@Override
	public boolean execute() {
		String nom = "";
		System.out.println("Ajout d�une nouvelle pizza");
		
		System.out.println("Veuillez saisir le code");
		Pizza piz = new Pizza();
		piz.setCode(sc.next());
		System.out.println("Veuillez saisir le nom (sans espace)");
		nom = sc.next();
		/*while(sc.hasNext()){
			System.out.println(nom+" ->"+sc.hasNext());
			nom += sc.next();
		}*/
		piz.setNom(nom);
		System.out.println("Veuillez saisir le prix");
		piz.setPrix(sc.nextDouble());
		System.out.println("Veuillez saisir la cat�gorie de pizza");
		
		CategoriePizza[] catePizzas = CategoriePizza.values();
		for(CategoriePizza cat : catePizzas) {
			System.out.println(cat.ordinal()+ " -> " + cat.getLibelle());
		}
		int saisie = sc.nextInt();
		piz.setCategorie(catePizzas[saisie]);
		
		try{
			pizzaDao.saveNewPizza(piz);
			System.out.println("Pizza cr�e");
		}catch(DaoException e){
			System.err.println(e.getMessage());
		}
		return true;
	}

}
