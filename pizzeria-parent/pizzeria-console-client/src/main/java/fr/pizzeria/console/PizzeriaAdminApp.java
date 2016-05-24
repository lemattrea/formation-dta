package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.pizzeria.doa.DaoFactory;
import fr.pizzeria.doa.DaoFactoryBdd;
import fr.pizzeria.doa.DaoFactoryFile;
import fr.pizzeria.doa.DaoFactoryJpa;
import fr.pizzeria.doa.DaoFactoryMemoire;
import fr.pizzeria.ihm.menu.MenuPrincipale;

public class PizzeriaAdminApp {
	
	private PizzeriaAdminApp() {}
	
	public static void main(String[] args) throws ClassNotFoundException {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String confString = bundle.getString("dao.impl");
		Integer daoImplConf = Integer.valueOf(confString);
		

		switch (daoImplConf) {
		case 0:
			System.out.println("Mode Memoire");
			lancerApplication(new DaoFactoryMemoire());
			break;
		case 1:
			System.out.println("Mode fichier");
			lancerApplication(new DaoFactoryFile());
			break;
		case 2:
			System.out.println("Mode Bdd");
			ResourceBundle bundleJdbc = ResourceBundle.getBundle("jdbc");
			String user = bundleJdbc.getString("dao.bdd.user");
			String password = bundleJdbc.getString("dao.bdd.pwd");
			String url = bundleJdbc.getString("dao.bdd.url");
			String driver = bundleJdbc.getString("dao.bdd.driver");
			lancerApplication(new DaoFactoryBdd(driver, url, user, password));
			break;
		case 3:
			System.out.println("Mode JPA");
			java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.WARNING);
			EntityManagerFactory em = Persistence.createEntityManagerFactory("pizzeria-console");
			lancerApplication(new DaoFactoryJpa(em));
			em.close();
			break;
		default:
			System.err.println("Aucune configuration DAO trouvé");
			break;
		}

	}

	private static void lancerApplication(DaoFactory factoryDao) {
		Scanner sc = new Scanner(System.in);
		MenuPrincipale menu = new MenuPrincipale(sc, factoryDao);
		menu.afficher();
		sc.close();
	}

}
