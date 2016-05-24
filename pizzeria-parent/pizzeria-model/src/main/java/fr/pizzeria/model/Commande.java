package fr.pizzeria.model;

import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Commande implements Comparable<Commande> {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String numeroCommande;
	@Enumerated(EnumType.STRING)
	private Status status;
	private Date dateCommande;


	// Clée étrangère
	@ManyToOne
	@JoinColumn(name = "livreurId")
	private Livreur livreur;

	@ManyToOne
	@JoinColumn(name = "cliantId")
	private Client client;

	@ManyToMany
	@JoinTable(name = "commande_pizza",
	joinColumns = 
	@JoinColumn(name = "id_commande", referencedColumnName = "id"), 
	inverseJoinColumns = 
	@JoinColumn(name = "id_pizza", referencedColumnName = "id"))
	private Set<Pizza> pizzas;

	
	/**
	 * 
	 */
	public Commande() {
		pizzas = new TreeSet<>();
	}

	public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(Pizza pizza) {
		this.pizzas.add(pizza);
	}
	
	public void setPizzas(Set<Pizza> pizzas) {
		pizzas.stream().forEach(p -> this.pizzas.add(p));
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public String getNumeroCommande() {
		return numeroCommande;
	}

	public void setNumeroCommande(String numeroCommande) {
		this.numeroCommande = numeroCommande;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public Date getDateCommande() {
		return dateCommande;
	}
	
	@Override
	public int compareTo(Commande o) {
		return Comparator.comparing(Commande::getNumeroCommande).thenComparing(Commande::getId).compare(this, o);
	}

	@Override
	public int hashCode() {
		// you pick a hard-coded, randomly chosen, non-zero, odd number
		// ideally different for each class
		return new HashCodeBuilder().append(id).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande other = (Commande) obj;

		return new EqualsBuilder().append(id, other.id).isEquals();

	}

}
