package fr.pizzeria.admin.event;

import java.util.Date;

import fr.pizzeria.model.Pizza;

public class CreePizzaEvent {

	private Pizza pizza;
	private Date dateOpe;

	/**
	 * @param pizza
	 * @param dateOpe
	 */
	public CreePizzaEvent(Pizza pizza, Date dateOpe) {
		this.pizza = pizza;
		this.dateOpe = dateOpe;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public Date getDateOpe() {
		return dateOpe;
	}

}
