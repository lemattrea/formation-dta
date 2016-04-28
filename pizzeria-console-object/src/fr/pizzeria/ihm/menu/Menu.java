package fr.pizzeria.ihm.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import fr.pizzeria.doa.IPizzaDao;
import fr.pizzeria.ihm.menu.option.*;

public class Menu {
	private static final String PIZZERIA_ADMINISTRATION_LIBELLE = "Pizzeria Administration";
	public AbstractOptionMenu[] options;
	private Scanner sc;

	public Menu(Scanner sc,IPizzaDao pizzaDao) {
		super();
		this.sc = sc;
		initialiserOption(sc, pizzaDao);
	}

	private void initialiserOption(Scanner scanner, IPizzaDao pizzaDao) {
		options = new AbstractOptionMenu[] { 
				new ListerPizzaOptionMenu(pizzaDao),
				new NouvellePizzaOptionMenu(scanner, pizzaDao),
				new MajPizzaOptionMenu(scanner, pizzaDao),
				new SupprimerPizzaOptionMenu(scanner, pizzaDao),
				new QuitterOptionMenu(scanner)
		};
	}
	
	public void afficher() {
		boolean continuer = true;
		while(continuer){
			System.out.println("***** "+PIZZERIA_ADMINISTRATION_LIBELLE+" *****");
			for (int i = 0; i < options.length; i++) {
				AbstractOptionMenu obs = options[i];
				System.out.println(i+". "+ obs.getLibelle());
			}
			try{
				int saisie = sc.nextInt();
				continuer = options[saisie].execute();
			}catch(InputMismatchException e){
				System.err.println("Vous avez saisie une valeur incorect :"+sc.next());
			}
		}
	}
}