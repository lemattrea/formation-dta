package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.pizzeria.ihm.menu.Menu;

public class PizzeriaAdminApp {

	private PizzeriaAdminApp() {
	}

	public static void main(String[] args) throws ClassNotFoundException {
		Logger.getLogger("org").setLevel(Level.SEVERE);
		
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String confString = bundle.getString("dao.impl");
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(confString, "application-config.xml")) {
			Menu menu = context.getBean("menuPrincipale", Menu.class);
			menu.afficher();
		}
	}
}
