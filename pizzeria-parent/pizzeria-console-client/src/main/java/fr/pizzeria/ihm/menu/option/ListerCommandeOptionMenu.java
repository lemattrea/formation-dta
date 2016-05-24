package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.doa.DaoFactory;

public class ListerCommandeOptionMenu extends AbstractOptionMenu {

	private static final String LISTER_LIBELLE = "Lister ces commandes";
	
	public ListerCommandeOptionMenu(Scanner scanner, DaoFactory daoFactory) {
		super(LISTER_LIBELLE, scanner, daoFactory);
	}

	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		return false;
	}

}
