package fr.pizzeria.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Pizza implements Comparable<Pizza>{
	private static int nbPizzas = 0;

	@Id
	@Column(name = "id", length = 255, nullable = false, unique = true)
	@ToString(uppercase = true)
	private String code;
	@ToString(uppercase = false)
	private String nom;
	@ToString(uppercase = false)
	private BigDecimal prix;
	@Enumerated(EnumType.STRING)
	@ToString(uppercase = false)
	private CategoriePizza categorie; 
	@Column(name = "url_image", length = 255, unique = false)
	@ToString(uppercase = false)
	private String url = "";
	
	private static final Map<String, String> FORMAT = new HashMap<>();
	private static final String STANDART_FORMAT = "%s :";
	
	/**
	 * constructeur par defaut
	 */
	public Pizza(){
		this("PIP","marga",new BigDecimal("12.5"), CategoriePizza.VIANDE);
	}
	/**
	 * @param code
	 * @param nom
	 * @param prix
	 */
	public Pizza(String code, String nom, BigDecimal prix, CategoriePizza categ) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categ;
	}
	
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
	public BigDecimal getPrix() {
		return prix;
	}
	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}
	@Override
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
		return Comparator.comparing(Pizza::getPrix).thenComparing(Pizza::getCode).compare(this, o);
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
