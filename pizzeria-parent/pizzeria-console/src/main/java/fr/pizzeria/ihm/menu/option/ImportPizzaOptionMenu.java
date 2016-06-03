package fr.pizzeria.ihm.menu.option;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.doa.DaoFactory;
import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.doa.pizza.PizzaDaoImplFile;
import fr.pizzeria.exception.NotImplementException;
import fr.pizzeria.model.Pizza;

public class ImportPizzaOptionMenu extends AbstractOptionMenu {

	private static final String IMPORT_PIZZA_LIBELLE = "(Base de données) Importer les données";
	private static final Logger LOG = Logger.getLogger(ImportPizzaOptionMenu.class.toString());

	public ImportPizzaOptionMenu(DaoFactory daoFactory) {
		super(IMPORT_PIZZA_LIBELLE, daoFactory);
	}

	@Override
	public boolean execute() {
		int compteur = 0;
		IPizzaDao pizzaDao = factoryDao.getPizzaDao();
		// creation d'un dao fichier pour récupérer tout les fichiers
		IPizzaDao daoFichier = new PizzaDaoImplFile();
		Set<Pizza> pizza = daoFichier.findAllPizzas();

		try {
			compteur = pizzaDao.fullTransaction(pizza);
		} catch (NotImplementException e) {
			LOG.log(Level.SEVERE, e.getMessage());
			return true;
		}
		LOG.log(Level.INFO, "pizza créé:"+compteur);
		return true;
	}

}
