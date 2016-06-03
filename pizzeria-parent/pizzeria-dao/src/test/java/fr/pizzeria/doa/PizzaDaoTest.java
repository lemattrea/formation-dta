package fr.pizzeria.doa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class PizzaDaoTest {

	private static final int NB_INITIAL_PIZZA = 8;
	protected IPizzaDao pizzaDao;

	@Test
	public void testfindAllPizzas() {
		Set<Pizza> pizzas = pizzaDao.findAllPizzas();
		Assert.assertEquals(NB_INITIAL_PIZZA, pizzas.size());
	}

	@Test
	public void testfullTransactionRollBack() {
		Set<Pizza> pizzas = new TreeSet<>();
		pizzas.add(new Pizza("AOR", "Reore", new BigDecimal("12.50"), CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("BAT", "Tartoni", new BigDecimal("12.50"), CategoriePizza.VIANDE));
		pizzas.add(new Pizza("FRO", "La 4 fromages", new BigDecimal("12.50"), CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("LOL", "retoit", new BigDecimal("12.50"), CategoriePizza.POISSON));
		pizzas.add(new Pizza("REO", "Reoini", new BigDecimal("12.50"), CategoriePizza.POISSON));
		pizzas.add(new Pizza("SIT", "retoit", new BigDecimal("12.50"), CategoriePizza.POISSON));
		
		pizzaDao.fullTransaction(pizzas);
			
		Assert.assertEquals(NB_INITIAL_PIZZA + 3, pizzaDao.findAllPizzas().size());
	}

	@Test
	public void testfullTransaction() {
		Set<Pizza> pizzas = new TreeSet<>();
		pizzas.add(new Pizza("AOR", "Reore", new BigDecimal("12.50"), CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("BAT", "Tartoni", new BigDecimal("12.50"), CategoriePizza.VIANDE));
		pizzas.add(new Pizza("LOL", "retoit", new BigDecimal("12.50"), CategoriePizza.POISSON));
		pizzas.add(new Pizza("REO", "Reoini", new BigDecimal("12.50"), CategoriePizza.POISSON));
		pizzas.add(new Pizza("SIT", "retoit", new BigDecimal("12.50"), CategoriePizza.POISSON));

		pizzaDao.fullTransaction(pizzas);

		Assert.assertEquals(NB_INITIAL_PIZZA + 5, pizzaDao.findAllPizzas().size());
	}

	@Test
	public void testupdatePizza() {
		Pizza piz = new Pizza("FRO", "piponi", new BigDecimal("12"), CategoriePizza.POISSON);
		pizzaDao.updatePizza("FRO", piz);

		Set<Pizza> pizzaSetTest = new TreeSet<Pizza>();
		pizzaSetTest = pizzaDao.findAllPizzas();
		Optional<Pizza> findFirst = pizzaSetTest.stream().filter(p -> "FRO".equals(p.getCode())).findFirst();
		assertTrue(findFirst.isPresent());
		Pizza pizzaATest = findFirst.get();
		assertEquals("FRO", pizzaATest.getCode());
		assertEquals("piponi", pizzaATest.getNom());
		assertTrue(BigDecimal.valueOf(12).compareTo(pizzaATest.getPrix()) == 0);
		assertEquals(CategoriePizza.POISSON, pizzaATest.getCategorie());
	}

	@Test
	public void testDeletePizza() {
		Set<Pizza> listPizza = pizzaDao.findAllPizzas();
		assertEquals(NB_INITIAL_PIZZA, listPizza.size());
		pizzaDao.deletePizza("PEP");
		listPizza = pizzaDao.findAllPizzas();
		assertEquals(NB_INITIAL_PIZZA - 1, listPizza.size());
		Optional<Pizza> findFirst = listPizza.stream().filter(p -> "PEP".equals(p.getCode())).findFirst();
		assertFalse(findFirst.isPresent());
	}

	@Test
	public void testSaveNewPizza() {
		Pizza newPizza = new Pizza("LOL", "piponi", new BigDecimal("12"), CategoriePizza.POISSON);
		pizzaDao.saveNewPizza(newPizza);
		Set<Pizza> pizzaSetTest = new TreeSet<Pizza>();
		pizzaSetTest = pizzaDao.findAllPizzas();
		assertTrue(pizzaSetTest.contains(newPizza));

	}

}
