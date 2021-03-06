package fr.pizzeria.ihm.menu;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.doa.DaoFactory;
import fr.pizzeria.ihm.menu.option.AbstractOptionMenu;
import fr.pizzeria.ihm.menu.option.ImportPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerBestPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerByCategPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.MajPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.NouvellePizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.QuitterOptionMenu;
import fr.pizzeria.ihm.menu.option.SupprimerPizzaOptionMenu;

@Component
public class Menu {
	private static final String PIZZERIA_ADMINISTRATION_LIBELLE = "Pizzeria Administration";
	public Map<Integer,AbstractOptionMenu> options = new TreeMap<Integer,AbstractOptionMenu>();
	private Scanner sc;
	
	@Autowired
	public Menu(Scanner sc,DaoFactory factoryDao) {
		super();
		this.sc = sc;
		initialiserOption(sc, factoryDao);
	}

	private void initialiserOption(Scanner scanner, DaoFactory factoryDao) {
		options.put(1, new ListerPizzaOptionMenu(factoryDao));
		options.put(2, new NouvellePizzaOptionMenu(scanner, factoryDao));
		options.put(3, new MajPizzaOptionMenu(scanner, factoryDao));
		options.put(99, new QuitterOptionMenu(scanner));
		options.put(4, new SupprimerPizzaOptionMenu(scanner, factoryDao));
		options.put(5, new ListerByCategPizzaOptionMenu(factoryDao));
		options.put(6, new ListerBestPizzaOptionMenu(factoryDao));
		options.put(6, new ImportPizzaOptionMenu(factoryDao));
		
	}
	
	public void afficher() {
		boolean continuer = true;
		while(continuer){
			System.out.println("***** "+PIZZERIA_ADMINISTRATION_LIBELLE+" *****");
			
			options.entrySet().stream().forEach(t -> System.out.println(t.getKey()+". "+t.getValue().getLibelle()));
			try{
				int saisie = sc.nextInt();
				if(options.containsKey(saisie)){
					continuer = options.get(saisie).execute();
				}else{
					System.err.println("Muméro de menu incorect");
				}
			}catch(InputMismatchException e){
				System.err.println("Vous avez saisie une valeur incorect :"+sc.next());
			}
		}
	}
}