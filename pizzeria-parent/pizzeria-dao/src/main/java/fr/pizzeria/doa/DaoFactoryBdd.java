package fr.pizzeria.doa;

import org.apache.commons.lang3.NotImplementedException;

import fr.pizzeria.doa.client.IClientDao;
import fr.pizzeria.doa.commande.ICommandeDao;
import fr.pizzeria.doa.pizza.IPizzaDao;

public class DaoFactoryBdd implements DaoFactory {

	private IPizzaDao pizzaDao;
	private IClientDao clientDao;
	
	/**
	 * 
	 */
	public DaoFactoryBdd (String driver, String url, String user, String password) throws ClassNotFoundException{
		throw new NotImplementedException("fonction non implémenté");
	}

	@Override
	public IPizzaDao getPizzaDao() {
		return pizzaDao;
	}

	@Override
	public IClientDao getClientDao() {
		return clientDao;
	}

	@Override
	public ICommandeDao getCommandeDao() {
		return null;
	}

}
