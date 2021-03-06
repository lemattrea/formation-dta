package fr.pizzeria.doa;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.NotImplementedException;

import fr.pizzeria.doa.client.IClientDao;
import fr.pizzeria.doa.commande.ICommandeDao;
import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.doa.pizza.PizzaDaoImplBdd;
import fr.pizzeria.exception.NotImplementException;

public class DaoFactoryBdd implements DaoFactory {
	
	private static final Logger LOG = Logger.getLogger(DaoFactoryBdd.class.toString());
	private IPizzaDao pizzaDao;
	
	/**
	 * 
	 */
	public DaoFactoryBdd (String driver, String url, String user, String password) throws ClassNotFoundException{
		LOG.log(Level.INFO, "Implémentation Bdd");
		this.pizzaDao = new PizzaDaoImplBdd(driver, url, user, password);
	}

	@Override
	public IPizzaDao getPizzaDao() {
		return pizzaDao;
	}

	@Override
	public IClientDao getClientDao() {
		throw new NotImplementException("Not Implément");
	}

	@Override
	public ICommandeDao getCommandeDao() {
		throw new NotImplementException("Not Implément");
	}

	@Override
	public void setPizzaDao(IPizzaDao pizza) {
		this.pizzaDao = pizza;
		
	}

	@Override
	public void setClientDao(IClientDao client) {
		throw new NotImplementedException("fonction non implémenté");
		
	}

	@Override
	public void setCommandeDao(ICommandeDao commande) {
		throw new NotImplementedException("fonction non implémenté");
		
	}

}
