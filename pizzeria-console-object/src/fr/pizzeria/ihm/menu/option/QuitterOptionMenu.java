package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

public class QuitterOptionMenu extends AbstractOptionMenu{
	private static final String QUITTER_LIBELLE = "Quitter";

	public QuitterOptionMenu(Scanner scanner) {
		super(QUITTER_LIBELLE, scanner);
	}

	@Override
	public boolean execute() {
		System.out.println("Aurevoir :-(");
		sc.close();
		return false;
	}

}
