package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.doa.IPizzaDao;
import fr.pizzeria.doa.PizzaDaoImplBdd;
import fr.pizzeria.doa.PizzaDaoImplFile;
import fr.pizzeria.doa.PizzaDaoImplMemory;
import fr.pizzeria.ihm.menu.Menu;

public class PizzeriaAdminApp {
	
	private PizzeriaAdminApp() {}
	
	public static void main(String[] args) throws ClassNotFoundException {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String confString = bundle.getString("dao.impl");
		Integer daoImplConf = Integer.valueOf(confString);
		

		switch (daoImplConf) {
		case 0:
			System.out.println("Mode Memoire");
			lancerApplication(new PizzaDaoImplMemory());
			break;
		case 1:
			System.out.println("Mode fichier");
			lancerApplication(new PizzaDaoImplFile());
			break;
		case 2:
			System.out.println("Mode Bdd");
			ResourceBundle bundleJdbc = ResourceBundle.getBundle("jdbc");
			String user = bundleJdbc.getString("dao.bdd.user");
			String password = bundleJdbc.getString("dao.bdd.pwd");
			String url = bundleJdbc.getString("dao.bdd.url");
			String driver = bundleJdbc.getString("dao.bdd.driver");
			lancerApplication(new PizzaDaoImplBdd(driver, url, user, password));
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
