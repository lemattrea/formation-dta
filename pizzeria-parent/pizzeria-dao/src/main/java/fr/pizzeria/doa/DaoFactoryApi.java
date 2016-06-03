package fr.pizzeria.doa;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.lang3.NotImplementedException;

import fr.pizzeria.doa.client.IClientDao;
import fr.pizzeria.doa.commande.ICommandeDao;
import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.doa.pizza.PizzaDaoImplApi;

public class DaoFactoryApi implements DaoFactory {
	private static final Logger LOG = Logger.getLogger(DaoFactoryApi.class.toString());
	private IPizzaDao pizzaDao;
	
	public DaoFactoryApi(EntityManagerFactory emf) {
		this.pizzaDao = new PizzaDaoImplApi(emf);
	}

	@Override
	public IPizzaDao getPizzaDao() {
		LOG.log(Level.INFO, "Implémentation Api");
		return pizzaDao;
	}

	@Override
	public IClientDao getClientDao() {
		throw new NotImplementedException("fonction non implémenté");
	}

	@Override
	public ICommandeDao getCommandeDao() {
		throw new NotImplementedException("fonction non implémenté");
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
