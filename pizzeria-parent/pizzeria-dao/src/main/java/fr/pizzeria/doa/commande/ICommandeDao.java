package fr.pizzeria.doa.commande;

import fr.pizzeria.model.Commande;

public interface ICommandeDao {
	void commanderPizza (Commande com);
	void listerCommande();
}
