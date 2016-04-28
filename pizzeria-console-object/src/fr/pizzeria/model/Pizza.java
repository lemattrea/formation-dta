package fr.pizzeria.model;

public class Pizza {
	private static int nbPizzas = 0;
	private String code;
	private String nom;
	private double prix;
	
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
	
	public static int getNbPizzas() {
		return nbPizzas;
	}
	public static void setNbPizzas(int nbPizzas) {
		Pizza.nbPizzas = nbPizzas;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
}
