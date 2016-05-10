package fr.pizzeria.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Pizza implements Comparable<Pizza>{
	private static int nbPizzas = 0;
	@ToString(uppercase = true)
	private String code;
	@ToString(uppercase = false)
	private String nom;
	@ToString(uppercase = false)
	private double prix;
	@ToString(uppercase = false)
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
	
	private final static Map<String, String> FORMAT = new HashMap<>();
	private final static String STANDART_FORMAT = "%s ->";
	
	static {
		FORMAT.put("nom", "%s ****");
		FORMAT.put("code", "%s -> ");
		FORMAT.put("prix", "(%s) ");
		FORMAT.put("categorie", "|   %s");
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
		return Arrays.asList(this.getClass().getDeclaredFields()).stream()
		.filter(f -> f.getAnnotation(ToString.class) != null)
		.map(f -> {
			String resultat = "";
			try {
				resultat = f.getAnnotation(ToString.class).uppercase() ? f.get(this).toString().toUpperCase() : f.get(this).toString();

			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				return "";
			}
			String format = FORMAT.containsKey(f.getName()) ? FORMAT.get(f.getName()) : STANDART_FORMAT;
			return String.format(format, resultat);
		})
		.collect(Collectors.joining());
		
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
	@Override
	public int hashCode() {
		// you pick a hard-coded, randomly chosen, non-zero, odd number
		// ideally different for each class
		return new HashCodeBuilder().
		  append(code).
		  toHashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		
		return new EqualsBuilder()
                 .append(code, other.code)
                 .isEquals();
		
	}
	
	
}
