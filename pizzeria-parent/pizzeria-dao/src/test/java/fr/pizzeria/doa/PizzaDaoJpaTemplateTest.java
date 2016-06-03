package fr.pizzeria.doa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

import fr.pizzeria.doa.pizza.IPizzaDao;

@ContextConfiguration(classes = PizzaDaoJpaSpringConfTest.class)
public class PizzaDaoJpaTemplateTest extends PizzaDaoTest{
	@Autowired
	public void setPizzaDao(@Qualifier("pizzaDaoJpaTemplate") IPizzaDao pizzaDao) {
		this.pizzaDao = pizzaDao;
	}
}
