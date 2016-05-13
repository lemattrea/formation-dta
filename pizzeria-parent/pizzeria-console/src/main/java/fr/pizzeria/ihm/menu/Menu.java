package fr.pizzeria.ihm.menu;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import fr.pizzeria.doa.IPizzaDao;
import fr.pizzeria.ihm.menu.option.*;

public class Menu {
	private static final String PIZZERIA_ADMINISTRATION_LIBELLE = "Pizzeria Administration";
	public Map<Integer,AbstractOptionMenu> options = new TreeMap<Integer,AbstractOptionMenu>();
	private Scanner sc;

	public Menu(Scanner sc,IPizzaDao pizzaDao) {
		super();
		this.sc = sc;
		initialiserOption(sc, pizzaDao);
	}

	private void initialiserOption(Scanner scanner, IPizzaDao pizzaDao) {
		options.put(1, new ListerPizzaOptionMenu(pizzaDao));
		options.put(2, new NouvellePizzaOptionMenu(scanner, pizzaDao));
		options.put(3, new MajPizzaOptionMenu(scanner, pizzaDao));
		options.put(99, new QuitterOptionMenu(scanner));
		options.put(4, new SupprimerPizzaOptionMenu(scanner, pizzaDao));
		options.put(5, new ListerByCategPizzaOptionMenu(pizzaDao));
		options.put(6, new ListerBestPizzaOptionMenu(pizzaDao));
		options.put(6, new ImportPizzaOptionMenu(pizzaDao));
		
	}
	
	public void afficher() {
		boolean continuer = true;
		while(continuer){
			System.out.println("***** "+PIZZERIA_ADMINISTRATION_LIBELLE+" *****");
			
			options.entrySet().stream().forEach(t -> System.out.println(t.getKey()+". "+t.getValue().getLibelle()));
			try{
				int saisie = sc.nextInt();
				if(options.containsKey(saisie)){
					continuer = options.get(saisie).execute();
				}else{
					System.err.println("Muméro de menu incorect");
				}
			}catch(InputMismatchException e){
				System.err.println("Vous avez saisie une valeur incorect :"+sc.next());
			}
		}
	}
}