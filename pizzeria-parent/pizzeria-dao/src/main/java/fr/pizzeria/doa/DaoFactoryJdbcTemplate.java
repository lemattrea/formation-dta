package fr.pizzeria.doa;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.transaction.PlatformTransactionManager;

import fr.pizzeria.doa.client.IClientDao;
import fr.pizzeria.doa.commande.ICommandeDao;
import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.doa.pizza.PizzaDaoImplJdbcTemplate;
import fr.pizzeria.exception.NotImplementException;

public class DaoFactoryJdbcTemplate implements DaoFactory {

	private static final Logger LOG = Logger.getLogger(DaoFactoryJdbcTemplate.class.toString());
	private IPizzaDao pizzaDao;
	
	public DaoFactoryJdbcTemplate(DataSource datasource,  PlatformTransactionManager txManager) {
		LOG.log(Level.INFO, "Implémentation Jdbc Template Spring");
		this.pizzaDao = new PizzaDaoImplJdbcTemplate(datasource, txManager);
	}
	
	public DaoFactoryJdbcTemplate() {
		LOG.log(Level.INFO, "Implémentation Jdbc Template Spring");
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
 