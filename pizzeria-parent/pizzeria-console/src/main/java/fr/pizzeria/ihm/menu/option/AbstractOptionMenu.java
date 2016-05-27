package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.doa.DaoFactory;
import fr.pizzeria.doa.pizza.IPizzaDao;

public abstract class AbstractOptionMenu {
	protected Scanner sc;
	private String libelle;
	protected DaoFactory factoryDao;
	
	public AbstractOptionMenu(String libelle, Scanner scanner) {
		super();
		this.sc = scanner;
		this.libelle = libelle;
	}
	
	public AbstractOptionMenu(String libelle, DaoFactory factoryDao) {
		super();
		this.factoryDao = factoryDao;
		this.libelle = libelle;
	}
	
	/**
	 * @param libelle
	 */
	public AbstractOptionMenu(String libelle, Scanner scanner, DaoFactory factoryDao) {
		super();
		this.factoryDao = factoryDao;
		this.sc = scanner;
		this.libelle = libelle;
	}
	
	public abstract boolean execute();

	public String getLibelle() {
		return libelle;
	}
	
}
