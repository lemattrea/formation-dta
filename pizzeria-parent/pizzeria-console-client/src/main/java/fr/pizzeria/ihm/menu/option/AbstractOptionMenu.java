package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.doa.DaoFactory;
import fr.pizzeria.model.Client;

public abstract class AbstractOptionMenu {
	protected Scanner sc;
	private String libelle;
	protected DaoFactory daoFactory;
	protected Client client;
	
	public AbstractOptionMenu(String libelle, Scanner scanner) {
		super();
		this.sc = scanner;
		this.libelle = libelle;
	}
	
	public AbstractOptionMenu(String libelle, DaoFactory daoFactory) {
		super();
		this.daoFactory = daoFactory;
		this.libelle = libelle;
	}
	
	/**
	 * @param libelle
	 */
	public AbstractOptionMenu(String libelle, Scanner scanner, DaoFactory daoFactory) {
		super();
		this.daoFactory = daoFactory;
		this.sc = scanner;
		this.libelle = libelle;
	}
	
	public AbstractOptionMenu(String libelle, Scanner scanner, DaoFactory daoFactory, Client cli) {
		super();
		this.daoFactory = daoFactory;
		this.sc = scanner;
		this.libelle = libelle;
		this.client = cli;
	}

	public abstract boolean execute();

	public String getLibelle() {
		return libelle;
	}
	
}
