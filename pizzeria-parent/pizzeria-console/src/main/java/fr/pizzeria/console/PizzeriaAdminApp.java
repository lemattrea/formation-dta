package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.doa.*;
import fr.pizzeria.ihm.menu.*;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminApp {

	public static void main(String[] args) {
		//new Pizza().equals(new Pizza());
		Scanner sc = new Scanner(System.in);
		IPizzaDao pizzaDao = new PizzaDaoImplMemory();
		Menu menu = new Menu(sc, pizzaDao);
		menu.afficher();

	}

}
