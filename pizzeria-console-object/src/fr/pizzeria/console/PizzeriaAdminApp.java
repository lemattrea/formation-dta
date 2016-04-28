package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.doa.*;
import fr.pizzeria.ihm.menu.*;

public class PizzeriaAdminApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PizzaDaoImpl pizzaDao = new PizzaDaoImpl();
		Menu menu = new Menu(sc, pizzaDao);
		menu.afficher();

	}

}
