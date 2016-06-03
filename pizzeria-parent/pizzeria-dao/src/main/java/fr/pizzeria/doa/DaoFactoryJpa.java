package fr.pizzeria.doa;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;

import fr.pizzeria.doa.client.ClientDaoImplJpa;
import fr.pizzeria.doa.client.IClientDao;
import fr.pizzeria.doa.commande.CommandeDaoImplJpa;
import fr.pizzeria.doa.commande.ICommandeDao;
import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.doa.pizza.PizzaDaoImplJpa;

public class DaoFactoryJpa implements DaoFactory {

	private static final Logger LOG = Logger.getLogger(DaoFactoryJpa.class.toString());
	private IPizzaDao pizzaDao;
	private IClientDao clientDao;
	private ICommandeDao commandeDao;
	
	public DaoFactoryJpa(EntityManagerFactory emf) {
		LOG.log(Level.INFO, "Implémentation Jpa");
		this.pizzaDao = new PizzaDaoImplJpa(emf);
		this.clientDao = new ClientDaoImplJpa(emf);
		this.commandeDao = new CommandeDaoImplJpa(emf);
	}
	
	public DaoFactoryJpa() {
		LOG.log(Level.INFO, "Implémentation JpaSpring");
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
		this.commandeDao = commande;
		
	}

}
