package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.doa.DaoFactory;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.menu.MenuClient;
import fr.pizzeria.model.Client;

public class ConnectionClientOptionMenu extends AbstractOptionMenu{
	private static final String CONNECTION_LIBELLE = "Se connecter";

	public ConnectionClientOptionMenu(Scanner scanner, DaoFactory daoFactory) {
		super(CONNECTION_LIBELLE, scanner, daoFactory);
	}

	@Override
	public boolean execute() {
		System.out.println("Identification Client");
		String email;
		System.out.println("Veuillez saisir votre email");
		email = sc.next();
		String mdp;
		System.out.println("Veuillez saisir un mot de passe");
		mdp = sc.next();
		
		
		try{
			Client cli = daoFactory.getClientDao().identification(email, mdp);
			if(cli != null) {
				MenuClient menu = new MenuClient(sc, daoFactory, cli);
				menu.afficher();
			}
		}catch(DaoException e){
			System.err.println(e.getMessage());
		}
		return true;
	}

}
