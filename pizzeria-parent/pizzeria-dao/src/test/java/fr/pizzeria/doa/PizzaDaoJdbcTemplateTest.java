package fr.pizzeria.doa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

import fr.pizzeria.doa.pizza.IPizzaDao;

@ContextConfiguration(classes = PizzaDaoJdbcSpringConfTest.class)
public class PizzaDaoJdbcTemplateTest extends PizzaDaoTest{
	@Autowired
	public void setPizzaDao(@Qualifier("pizzaDaoJdbcTemplate") IPizzaDao pizzaDao) {
		this.pizzaDao = pizzaDao;
	}
}
