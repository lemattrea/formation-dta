package fr.pizzeria.doa;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	private Pizza[] pizzas  = new Pizza[100];
	
	public PizzaDaoImpl() {
		pizzas[0] = new Pizza("PEP","P�p�roni",12.50);
		pizzas[1] = new Pizza("MAR","Margherita",12.50);
		pizzas[2] = new Pizza("REI","La Reine",12.50);
		pizzas[3] = new Pizza("FRO","La 4 fromages",12.50);
		pizzas[4] = new Pizza("CAN","La cannibale",12.50);
		pizzas[5] = new Pizza("SAV","La savoyarde",12.50);
		pizzas[6] = new Pizza("ORI","L�orientale",12.50);
		pizzas[7] = new Pizza("IND","L�indienne",12.50);
	}
	
	@Override
	public Pizza[] findAllPizzas() {
		Pizza[] resultat = new Pizza[100];
		System.arraycopy(pizzas, 0, resultat, 0, resultat.length);
		return resultat;
	}

	@Override
	public boolean saveNewPizza(Pizza newPizza) {
		int codePiz = 0;
		boolean trouver = false;
		while(!trouver && codePiz < pizzas.length){
			if(pizzas[codePiz] == null){
				trouver = true;
				pizzas[codePiz] = newPizza;
			}
			codePiz++;
		}
		return trouver;
	}

	@Override
	public boolean updatePizza(String code, Pizza updatePizza) {
		int codePiz = 0;
		boolean trouver = false;
		while(!trouver && codePiz < pizzas.length){
			if(pizzas[codePiz] != null && pizzas[codePiz].getCode().equals(code)){
				trouver = true;
				pizzas[codePiz] = updatePizza;
			}
			codePiz++;
		}
		return trouver;
	}

	@Override
	public boolean deletePizza(String code) {
		int codePiz = 0;
		boolean trouver = false;
		while(!trouver && codePiz < pizzas.length){
			if(pizzas[codePiz].getCode().equals(code)){
				trouver = true;
				pizzas[codePiz] = null;
			}
			codePiz++;
		}
		return trouver;
	}

}