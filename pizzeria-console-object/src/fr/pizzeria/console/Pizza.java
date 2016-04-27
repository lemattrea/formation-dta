package fr.pizzeria.console;

public class Pizza {
	public static int nbPizzas = 0;
	public String code;
	public String nom;
	public double prix;
	
	/**
	 * constructeur par defaut
	 */
	public Pizza(){
		this("PIP","marga",12.5);
	}
	/**
	 * @param code
	 * @param nom
	 * @param prix
	 */
	public Pizza(String code, String nom, double prix) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}
	
	
}
