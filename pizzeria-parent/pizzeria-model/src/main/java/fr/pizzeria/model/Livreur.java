package fr.pizzeria.model;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Livreur implements Comparable<Livreur> {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	
	@OneToMany(mappedBy="client")
	private Set<Commande> commandes;
	
	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 */
	public Livreur(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		commandes = new TreeSet<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public int compareTo(Livreur o) {
		return Comparator.comparing(Livreur::getNom).thenComparing(Livreur::getPrenom).thenComparing(Livreur::getId).compare(this, o);
	}
	@Override
	public int hashCode() {
		// you pick a hard-coded, randomly chosen, non-zero, odd number
		// ideally different for each class
		return new HashCodeBuilder().
		  append(id).
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
		Livreur other = (Livreur) obj;
		
		return new EqualsBuilder()
                 .append(id, other.id)
                 .isEquals();
		
	}

}
