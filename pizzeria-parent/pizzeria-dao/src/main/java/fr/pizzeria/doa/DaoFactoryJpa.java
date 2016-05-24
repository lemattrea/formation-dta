package fr.pizzeria.doa;

import javax.persistence.EntityManagerFactory;

import fr.pizzeria.doa.client.ClientDaoImplJpa;
import fr.pizzeria.doa.client.IClientDao;
import fr.pizzeria.doa.commande.CommandeDaoImplJpa;
import fr.pizzeria.doa.commande.ICommandeDao;
import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.doa.pizza.PizzaDaoImplJpa;

public class DaoFactoryJpa implements DaoFactory {

	private IPizzaDao pizzaDao;
	private IClientDao clientDao;
	private ICommandeDao commandeDao;
	
	public DaoFactoryJpa(EntityManagerFactory emf) {
		this.pizzaDao = new PizzaDaoImplJpa(emf);
		this.clientDao = new ClientDaoImplJpa(emf);
		this.commandeDao = new CommandeDaoImplJpa(emf);
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
		return commandeDao;
	}

}
