package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.doa.IPizzaDao;
import fr.pizzeria.doa.PizzaDaoImplFile;
import fr.pizzeria.doa.PizzaDaoImplMemory;
import fr.pizzeria.ihm.menu.Menu;

public class PizzeriaAdminApp {

	public static void main(String[] args) {
		// test changement jenkins
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String confString = bundle.getString("dao.impl");
		Integer daoImplConf = Integer.valueOf(confString);

		switch (daoImplConf) {
		case 0:
			lancerApplication(new PizzaDaoImplMemory());
			break;
		case 1:
			lancerApplication(new PizzaDaoImplFile());
			break;
		default:
			System.err.println("Aucune configuration DAO trouvé");
			break;
		}

	}

	private static void lancerApplication(IPizzaDao pizzaDao) {
		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu(sc, pizzaDao);
		menu.afficher();
	}

}
