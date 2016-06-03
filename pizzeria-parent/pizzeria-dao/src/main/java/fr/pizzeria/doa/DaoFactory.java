package fr.pizzeria.doa;

import fr.pizzeria.doa.client.IClientDao;
import fr.pizzeria.doa.commande.ICommandeDao;
import fr.pizzeria.doa.pizza.IPizzaDao;

public interface DaoFactory {
	IPizzaDao getPizzaDao();
	IClientDao getClientDao();
	ICommandeDao getCommandeDao();
	
	void setPizzaDao(IPizzaDao pizza);
	void setClientDao(IClientDao client);
	void setCommandeDao(ICommandeDao commande);
}
