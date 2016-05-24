package fr.pizzeria.model;

public enum Status {
	NON_TRAITER("Non Traité"), TRAITER("Traité"), LIVRER("Livré");

	private String libelle;

	private Status(String value) {
		this.libelle = value;
	}

	public String getLibelle() {
		return libelle;
	}
	
	@Override
	public String toString() {
		return libelle;
	}
}
