package fr.pizzeria.model;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Client implements Comparable<Client> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	@Column(unique = true)
	private String email;
	private String mdp;
	
	@OneToMany(mappedBy="client")
	private Set<Commande> commandes;
	
	public Client() {
		super();
	}
	
	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param mdp
	 */
	public Client(String nom, String prenom, String email, String mdp) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	@Override
	public int compareTo(Client o) {
		return Comparator.comparing(Client::getNom).thenComparing(Client::getPrenom).thenComparing(Client::getId).compare(this, o);
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
		Client other = (Client) obj;
		
		return new EqualsBuilder()
                 .append(this.id, other.id)
                 .isEquals();
		
	}

}
