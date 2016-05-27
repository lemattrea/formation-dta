package fr.pizzeria.doa;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.lang3.NotImplementedException;

import fr.pizzeria.doa.client.IClientDao;
import fr.pizzeria.doa.commande.ICommandeDao;
import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.doa.pizza.PizzaDaoImplApi;

public class DaoFactoryApi implements DaoFactory {

	private IPizzaDao pizzaDao;
	
	public DaoFactoryApi(EntityManagerFactory emf) {
		this.pizzaDao = new PizzaDaoImplApi(emf);
	}

	@Override
	public IPizzaDao getPizzaDao() {
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

}
