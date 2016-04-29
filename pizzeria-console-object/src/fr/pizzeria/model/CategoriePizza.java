package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");

	private String libelle;

	private CategoriePizza(String value) {
		this.libelle = value;
	}

	public String getLibelle() {
		return libelle;
	}
}
