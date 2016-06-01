package fr.pizzeria.console;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.pizzeria.ihm.menu.Menu;

public class PizzeriaAdminApp {

	private PizzeriaAdminApp() {
	}

	public static void main(String[] args) throws ClassNotFoundException {
		Logger.getLogger("org").setLevel(Level.SEVERE);
		
		/*ResourceBundle bundle = ResourceBundle.getBundle("application");
		String confString = bundle.getString("dao.impl");*/
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzeriaAppSpringConfig.class)) {
			Menu menu = context.getBean("menu", Menu.class);
			menu.afficher();
		}
	}
}
