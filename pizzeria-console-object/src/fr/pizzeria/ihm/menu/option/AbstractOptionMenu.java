package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.doa.IPizzaDao;

public abstract class AbstractOptionMenu {
	protected Scanner sc;
	private String libelle;
	protected IPizzaDao pizzaDao;
	public abstract boolean execute();
	
	/**
	 * @param libelle
	 */
	public AbstractOptionMenu(String libelle, Scanner scanner, IPizzaDao pizzaDao) {
		super();
		this.pizzaDao = pizzaDao;
		this.sc = scanner;
		this.libelle = libelle;
	}
	
	public AbstractOptionMenu(String libelle, Scanner scanner) {
		super();
		this.sc = scanner;
		this.libelle = libelle;
	}
	
	public AbstractOptionMenu(String libelle, IPizzaDao pizzaDao) {
		super();
		this.pizzaDao = pizzaDao;
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
	
}
