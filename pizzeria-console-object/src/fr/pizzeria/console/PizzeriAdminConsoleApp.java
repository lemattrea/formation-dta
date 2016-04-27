package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriAdminConsoleApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Pizza[] pizza = getTableauPizza();
		int choix = 0;
		do {
			System.out.println("*****	Pizzeria	Administration	***** \n"
				+"1.	Lister les pizzas\n"	
				+"2.	Ajouter une nouvelle pizza\n"
				+"3.	Mettre à jour une pizza\n"
				+"4.	Supprimer une pizza\n"
				+"99.	Sortir");
			
			choix = sc.nextInt();
			switch(choix){
				case(1):
					System.out.println("Liste des pizzas");
					affichePizza(pizza);
					System.out.println("------- "+Pizza.nbPizzas+" pizzas créées depuis l’initialisation du programme");
					break;
				case(2):
					System.out.println("Ajout d’une nouvelle pizza");
					int caseVide = getNextInsert(pizza);
					pizza = changePizza(pizza, caseVide, sc, true);
					break;
				case(3):
					System.out.println("Mise à jour d’une pizza");
					affichePizza(pizza);
					System.out.println("Veuillez choisir la pizza à modifier.");
					System.out.println("(99 pour abandonner)");
					String numPizza = sc.next();
					if (numPizza.equals("99")) {
						int idPiz = getIdPizz(numPizza, pizza);
						if(idPiz != 100){
							pizza = changePizza(pizza, idPiz, sc, false);
						}
						System.err.println("Code incorrect");
					}
					
					break;
				case(4):
					System.out.println("Suppression d’une pizza");
					affichePizza(pizza);
					System.out.println("Veuillez choisir la pizza à supprimer.");
					System.out.println("(99 pour abandonner)");
					String numberPizza = sc.next();
					int id = getIdPizz(numberPizza, pizza);
					if (numberPizza.equals("99")) {
						pizza[id] = null;
					}
					break;
			}
		}while(choix != 99);
		
		System.out.println("Aurevoir :(");
		sc.close();
		
	}
	
	private static int getIdPizz(String numPizza, Pizza[] piz) {
		for(int i = 0; i<piz.length; i++) {
			if (piz[i].code.equals(numPizza)){
				return i;
			}
		}
		return 100;
	}

	/**
	 * Affiche toute les pizzas
	 * @param pizza tableau contenant les pizzas format [][3]
	 */
	private static void affichePizza(Pizza[] pizza) {
		for(int i = 0; i < pizza.length; i++) {
			if( pizza[i] != null) {
				System.out.println(pizza[i].code+"->"+pizza[i].nom+"-> ("+pizza[i].prix+" €)");
			}
		}
	}
	
	/**
	 * Modifie une pizza
	 * @param pizza tableau correspondant a nos pizza
	 * @param numCase Int correspondant a l'identifiant
	 * @param sc Scanner pour la communication
	 * @return le tableau de Pizza
	 */
	private static Pizza[] changePizza(Pizza[] pizza, int numCase, Scanner sc, boolean nouveau){
		System.out.println("Veuillez saisir le code");
		Pizza piz = new Pizza();
		piz.code = sc.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		piz.nom = sc.next();
		System.out.println("Veuillez saisir le prix");
		piz.prix = sc.nextDouble();
		pizza[numCase] = piz;
		if(nouveau){
			Pizza.nbPizzas++;
		}
		return pizza;
	}
	
	/**
	 * récupère l'id de la première place libre dans le tableau donnée en parametre
	 * @param pizza tableau d'Object
	 * @return l'id de la première place libre
	 */
	private static int getNextInsert(Pizza[] pizza) {
		int i = 0;
		while(i < pizza.length && pizza[i] != null) {
			i++;
		}
		return i;
	}

	/**
	 * crée et remplie le tableau de pizza
	 * @return Pizza correspondant au tableau de pizza
	 */
	private static Pizza[] getTableauPizza() {
		Pizza[] pizza = new Pizza[100];
		pizza[0] = createPizza("PEP","Pépéroni",12.50);
		pizza[1] = createPizza("MAR","Margherita",12.50);
		pizza[2] = createPizza("REI","La Reine",12.50);
		pizza[3] = createPizza("FRO","La 4 fromages",12.50);
		pizza[4] = createPizza("CAN","La cannibale",12.50);
		pizza[5] = createPizza("SAV","La savoyarde",12.50);
		pizza[6] = createPizza("ORI","L’orientale",12.50);
		pizza[7] = createPizza("IND","L’indienne",12.50);
		return pizza;
	}
	
	/**
	 * 
	 * @param code
	 * @param name
	 * @param prix
	 * @return
	 */
	private static Pizza createPizza(String code, String name, double prix){
		Pizza piz = new Pizza();
		piz.code = code;
		piz.nom = name;
		piz.prix = prix;
		Pizza.nbPizzas++;
		return piz;
	}
}
