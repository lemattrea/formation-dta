package fr.pizzeria.model;


public class Pizza implements Comparable<Pizza>{
	private static int nbPizzas = 0;
	private String code;
	private String nom;
	private double prix;
	private CategoriePizza categorie; 
	
	/**
	 * constructeur par defaut
	 */
	public Pizza(){
		this("PIP","marga",12.5, CategoriePizza.VIANDE);
	}
	/**
	 * @param code
	 * @param nom
	 * @param prix
	 */
	public Pizza(String code, String nom, double prix, CategoriePizza categ) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categ;
	}
	
	public CategoriePizza getCategorie() {
		return categorie;
	}
	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
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
	public String toString(){
		return this.code+"->"+this.nom+"-> ("+this.prix+" €)"+"("+this.categorie.getLibelle()+")";
	}
	@Override
	public int compareTo(Pizza o) {
		// TODO Auto-generated method stub
		int resultat;
		if(this.prix == o.prix) {
			resultat = this.code.compareTo(o.code);
		}else if(this.prix < o.prix){
			resultat = -1;
		}else{
			resultat = 1;
		}
		
		return resultat;
	}
	
	
}
