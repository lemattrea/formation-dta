package fr.pizzeria.ihm.menu;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import fr.pizzeria.doa.DaoFactory;
import fr.pizzeria.ihm.menu.option.AbstractOptionMenu;
import fr.pizzeria.ihm.menu.option.ConnectionClientOptionMenu;
import fr.pizzeria.ihm.menu.option.InscriptionClientOptionMenu;
import fr.pizzeria.ihm.menu.option.QuitterOptionMenu;

public class MenuPrincipale {
	private static final String PIZZERIA_ADMINISTRATION_LIBELLE = "Pizzeria Client";
	private Map<Integer, AbstractOptionMenu> options = new TreeMap<>();
	private Scanner sc;

	public MenuPrincipale(Scanner sc, DaoFactory factoryDao) {
		super();
		this.sc = sc;
		initialiserOption(sc, factoryDao);
	}

	private void initialiserOption(Scanner scanner, DaoFactory factoryDao) {
		options.put(99, new QuitterOptionMenu(scanner));
		options.put(1, new InscriptionClientOptionMenu(scanner, factoryDao));
		options.put(2, new ConnectionClientOptionMenu(scanner, factoryDao));
	}

	public void afficher() {
		boolean continuer = true;
		while (continuer) {
			System.out.println("***** " + PIZZERIA_ADMINISTRATION_LIBELLE + " *****");

			options.entrySet().stream().forEach(t -> System.out.println(t.getKey() + ". " + t.getValue().getLibelle()));
			try {
				int saisie = sc.nextInt();
				if (options.containsKey(saisie)) {
					continuer = options.get(saisie).execute();
				} else {
					System.err.println("Muméro de menu incorect");
				}
			} catch (InputMismatchException e) {
				System.err.println("Vous avez saisie une valeur incorect :" + sc.next());
			}
		}
	}
}