package fr.pizzeria.ihm.menu.option;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.collections4.ListUtils;

import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.doa.pizza.PizzaDaoImplFile;
import fr.pizzeria.exception.NotImplementException;
import fr.pizzeria.model.Pizza;

public class ImportPizzaOptionMenu extends AbstractOptionMenu {

	private static final String IMPORT_PIZZA_LIBELLE = "(Base de données) Importer les données";
	
	public ImportPizzaOptionMenu(IPizzaDao pizzaDao) {
		super(IMPORT_PIZZA_LIBELLE, pizzaDao);
	}

	@Override
	public boolean execute() {
		int compteur = 0;
		boolean ope;
		
		// creation d'un dao fichier pour récupérer tout les fichiers
		IPizzaDao daoFichier = new PizzaDaoImplFile();
		Set<Pizza> pizza = daoFichier.findAllPizzas();
		
		List<List<Pizza>> bestList = ListUtils.partition(pizza.stream().collect(Collectors.toList()), 3);

		for(List<Pizza> p : bestList) {
			try {
				ope = pizzaDao.transactionInsertPizza(p);
				if(ope) {
					compteur += p.size();
				}
			}catch(NotImplementException e) {
				System.out.println(e.getMessage());
				return true;
			}
		}
		System.out.println(compteur+" pizza ajouté");
		
		return true;
	}

}
