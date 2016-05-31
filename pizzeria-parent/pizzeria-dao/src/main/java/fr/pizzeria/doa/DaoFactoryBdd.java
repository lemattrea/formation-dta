package fr.pizzeria.doa;

import fr.pizzeria.doa.client.IClientDao;
import fr.pizzeria.doa.commande.ICommandeDao;
import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.doa.pizza.PizzaDaoImplBdd;
import fr.pizzeria.exception.NotImplementException;

public class DaoFactoryBdd implements DaoFactory {

	private IPizzaDao pizzaDao;
	
	/**
	 * 
	 */
	public DaoFactoryBdd (String driver, String url, String user, String password) throws ClassNotFoundException{
		this.pizzaDao = new PizzaDaoImplBdd(driver, url, user, password);
	}

	@Override
	public IPizzaDao getPizzaDao() {
		return pizzaDao;
	}

	@Override
	public IClientDao getClientDao() {
		throw new NotImplementException("Veuillez configurer l'application avec une implémentation base de données");
	}

	@Override
	public ICommandeDao getCommandeDao() {
		throw new NotImplementException("Veuillez configurer l'application avec une implémentation base de données");
	}

}
