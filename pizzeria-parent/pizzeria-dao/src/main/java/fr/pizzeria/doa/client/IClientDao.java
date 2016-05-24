package fr.pizzeria.doa.client;

import fr.pizzeria.model.Client;


public interface IClientDao {
	Client identification (String name, String pwd);
	void ajouterCLient(Client newClient);
}
