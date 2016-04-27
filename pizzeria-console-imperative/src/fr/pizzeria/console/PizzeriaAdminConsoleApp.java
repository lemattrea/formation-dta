package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Object[][] pizza = getTableauPizza();
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
					break;
				case(2):
					System.out.println("Ajout d’une nouvelle pizza");
					int caseVide = getNextInsert(pizza);
					pizza = changePizza(pizza, caseVide, sc);
					break;
				case(3):
					System.out.println("Mise à jour d’une pizza");
					affichePizza(pizza);
					System.out.println("Veuillez choisir la pizza à modifier.");
					System.out.println("(99 pour abandonner)");
					int numPizza = sc.nextInt();
					if (numPizza != 99) {
						pizza = changePizza(pizza, numPizza, sc);
					}
					
					break;
				case(4):
					System.out.println("Suppression d’une pizza");
					affichePizza(pizza);
					System.out.println("Veuillez choisir la pizza à supprimer.");
					System.out.println("(99 pour abandonner)");
					int numberPizza = sc.nextInt();
					if (numberPizza != 99) {
						pizza[numberPizza] = new Object[3];
					}
					break;
			}
		}while(choix != 99);
		
		System.out.println("Aurevoir :(");
		sc.close();
		
	}
	
	/**
	 * Affiche toute les pizzas
	 * @param pizza tableau d'Object contenant les pizzas format [][3]
	 */
	private static void affichePizza(Object[][] pizza) {
		for(int i = 0; i < pizza.length; i++) {
			if( pizza[i][0] != null) {
				System.out.println(i+"->"+pizza[i][0]+"->"+pizza[i][1]+"-> ("+pizza[i][2]+" €)");
			}
		}
	}
	
	/**
	 * Modifie une pizza
	 * @param pizza tableau d'Object correspondant a nos pizza
	 * @param numCase Int correspondant a l'identifiant
	 * @param sc Scanner pour la communication
	 * @return le tableau d'Object
	 */
	private static Object[][] changePizza(Object[][] pizza, int numCase, Scanner sc){
		System.out.println("Veuillez saisir le code");
		pizza[numCase][0] = sc.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		pizza[numCase][1] = sc.next();
		System.out.println("Veuillez saisir le prix");
		pizza[numCase][2] = sc.nextDouble();
		
		return pizza;
	}
	
	/**
	 * récupère l'id de la première place libre dans le tableau donnée en parametre
	 * @param pizza tableau d'Object
	 * @return l'id de la première place libre
	 */
	private static int getNextInsert(Object[][] pizza) {
		int i = 0;
		while(i < pizza.length && pizza[i][0] != null) {
			i++;
		}
		return i;
	}

	/**
	 * crée et remplie le tableau de pizza
	 * @return Object correspondant au tableau de pizza
	 */
	private static Object[][] getTableauPizza() {
		Object[][] pizza = new Object[100][3];
		pizza[0] = new Object[]{"PEP","Pépéroni",12.50};
		pizza[1] = new Object[]{"MAR","Margherita",12.50};
		pizza[2] = new Object[]{"REI","La Reine",12.50};
		pizza[3] = new Object[]{"FRO","La 4 fromages",12.50};
		pizza[4] = new Object[]{"CAN","La cannibale",12.50};
		pizza[5] = new Object[]{"SAV","La savoyarde",12.50};
		pizza[6] = new Object[]{"ORI","L’orientale",12.50};
		pizza[7] = new Object[]{"IND","L’indienne",12.50};
		return pizza;
	}
}
