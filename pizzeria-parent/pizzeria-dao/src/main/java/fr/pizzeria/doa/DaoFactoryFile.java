package fr.pizzeria.doa;

import org.apache.commons.lang3.NotImplementedException;

import fr.pizzeria.doa.client.IClientDao;
import fr.pizzeria.doa.commande.ICommandeDao;
import fr.pizzeria.doa.pizza.IPizzaDao;

public class DaoFactoryFile implements DaoFactory {

	private IPizzaDao pizzaDao;
	private IClientDao clientDao;
	
	/**
	 * 
	 */
	public DaoFactoryFile() {
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

	@Override
	public void setPizzaDao(IPizzaDao pizza) {
		this.pizzaDao = pizza;
		
	}

	@Override
	public void setClientDao(IClientDao client) {
		this.clientDao = client;
		
	}

	@Override
	public void setCommandeDao(ICommandeDao commande) {
		throw new NotImplementedException("fonction non implémenté");
		
	}

}
