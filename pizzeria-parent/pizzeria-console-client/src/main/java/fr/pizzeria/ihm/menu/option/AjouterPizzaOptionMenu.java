package fr.pizzeria.ihm.menu.option;

import java.util.Calendar;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import fr.pizzeria.doa.DaoFactory;
import fr.pizzeria.doa.commande.ICommandeDao;
import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.Status;

public class AjouterPizzaOptionMenu extends AbstractOptionMenu {

	private static final String COMMENDER_PIZZA_LIBELLE = "Commander une pizza";

	public AjouterPizzaOptionMenu(Scanner scanner, DaoFactory daoFactory,Client cli) {
		super(COMMENDER_PIZZA_LIBELLE, scanner, daoFactory, cli);
	}

	@Override
	public boolean execute() {
		IPizzaDao daoPizz = daoFactory.getPizzaDao();
		Set<Pizza> listPizz = daoPizz.findAllPizzas();

		System.out.println("Sélectionner la pizza que vous voulez commandez");
		listPizz.stream().forEach(pizza -> System.out.println(pizza.toString()));
		String codePizza = sc.next();

		Optional<Pizza> pizzaSelect = listPizz.stream().filter(p -> p.getCode().equals(codePizza)).findFirst();
		Commande maCom = new Commande();
		maCom.setPizzas(pizzaSelect.get());
		maCom.setClient(this.client);
		maCom.setNumeroCommande(generateAutoNum());
		maCom.setLivreur(null);
		maCom.setStatus(Status.NON_TRAITER);
		
		ICommandeDao commandeDao = daoFactory.getCommandeDao();
		commandeDao.commanderPizza(maCom);
		
		return true;
	}

	private String generateAutoNum() {
		return "NUM_COMMANDE_"+Calendar.getInstance().getTimeInMillis();
	}

}
