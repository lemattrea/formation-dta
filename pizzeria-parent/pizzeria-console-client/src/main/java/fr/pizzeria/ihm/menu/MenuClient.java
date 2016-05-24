package fr.pizzeria.ihm.menu;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import fr.pizzeria.doa.DaoFactory;
import fr.pizzeria.ihm.menu.option.AbstractOptionMenu;
import fr.pizzeria.ihm.menu.option.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerCommandeOptionMenu;
import fr.pizzeria.ihm.menu.option.QuitterOptionMenu;
import fr.pizzeria.model.Client;

public class MenuClient {
	private static final String PIZZERIA_ADMINISTRATION_LIBELLE = "Pizzeria Client";
	private Map<Integer, AbstractOptionMenu> options = new TreeMap<>();
	private Scanner sc;

	public MenuClient(Scanner sc, DaoFactory factoryDao, Client cli) {
		super();
		this.sc = sc;
		initialiserOption(sc, factoryDao, cli);
	}

	private void initialiserOption(Scanner scanner, DaoFactory factoryDao, Client cli) {
		options.put(99, new QuitterOptionMenu(scanner));
		options.put(1, new AjouterPizzaOptionMenu(scanner, factoryDao, cli));
		options.put(2, new ListerCommandeOptionMenu(scanner, factoryDao));
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