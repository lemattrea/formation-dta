package fr.pizzeria.doa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

import fr.pizzeria.doa.pizza.IPizzaDao;

@ContextConfiguration(classes = PizzaDaoJpaDataSpringConfTest.class)
public class PizzaDaoJpaDataTemplateTest extends PizzaDaoTest{
	@Autowired
	public void setPizzaDao(@Qualifier("pizzaDaoImplJpaDataSpring") IPizzaDao pizzaDao) {
		this.pizzaDao = pizzaDao;
	}
}
