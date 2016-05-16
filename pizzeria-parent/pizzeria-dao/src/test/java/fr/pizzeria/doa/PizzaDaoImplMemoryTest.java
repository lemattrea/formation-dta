package fr.pizzeria.doa;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplMemoryTest {
	
	private Set<Pizza> pizzasRef;
	private PizzaDaoImplMemory pizzaDaoRef;
	private Pizza[] arrayPizzaRef;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		pizzaDaoRef = new PizzaDaoImplMemory();
		pizzasRef = new TreeSet<Pizza>();
		pizzasRef.add(new Pizza("PEP","Pépéroni",new BigDecimal("12.50"), CategoriePizza.SANS_VIANDE));
		pizzasRef.add(new Pizza("MAR","Margherita",new BigDecimal("12.50"), CategoriePizza.VIANDE));
		pizzasRef.add(new Pizza("REI","La Reine",new BigDecimal("12.50"), CategoriePizza.POISSON));
		pizzasRef.add(new Pizza("FRO","La 4 fromages",new BigDecimal("12.50"), CategoriePizza.SANS_VIANDE));
		pizzasRef.add(new Pizza("CAN","La cannibale",new BigDecimal("12.50"), CategoriePizza.VIANDE));
		pizzasRef.add(new Pizza("SAV","La savoyarde",new BigDecimal("15"), CategoriePizza.SANS_VIANDE));
		pizzasRef.add(new Pizza("ORI","L'orientale",new BigDecimal("12.50"), CategoriePizza.POISSON));
		pizzasRef.add(new Pizza("IND","L'indienne",new BigDecimal("12.50"), CategoriePizza.SANS_VIANDE));
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAllPizzas() {
		arrayPizzaRef = pizzasRef.toArray(new Pizza[0]);
		Set<Pizza> pizzaSetTest = new TreeSet<Pizza>();
		pizzaSetTest = pizzaDaoRef.findAllPizzas();
		Pizza[] arrayPizza =  pizzaSetTest.<Pizza>toArray(new Pizza[0]);
		assertArrayEquals(arrayPizzaRef, arrayPizza);
	}

	@Test
	public void testSaveNewPizza() {
		Pizza newPizza = new Pizza("POP", "piponi", new BigDecimal("12"), CategoriePizza.POISSON);
		pizzaDaoRef.saveNewPizza(newPizza);
		Set<Pizza> pizzaSetTest = new TreeSet<Pizza>();
		pizzaSetTest = pizzaDaoRef.findAllPizzas();
		assertTrue(pizzaSetTest.contains(newPizza));
		
	}
	
	@Test(expected = SavePizzaException.class)
	public void testSaveNewPizzaExistante() {
		Pizza newPizza = new Pizza("PEP","Pépéroni",new BigDecimal("12.50"), CategoriePizza.SANS_VIANDE);
		pizzasRef.add(newPizza);
		
		arrayPizzaRef = pizzasRef.toArray(new Pizza[0]);
		pizzaDaoRef.saveNewPizza(newPizza);
		
	}

	@Test
	public void testUpdatePizza() {
		Pizza pizza = new Pizza("PEP", "piponi", new BigDecimal("12"), CategoriePizza.POISSON);
		pizzaDaoRef.updatePizza("PEP", pizza);
		Set<Pizza> pizzaSetTest = new TreeSet<Pizza>();
		pizzaSetTest = pizzaDaoRef.findAllPizzas();
		Optional<Pizza> findFirst = pizzaSetTest.stream().filter(p->"PEP".equals(p.getCode())).findFirst();
		assertTrue(findFirst.isPresent());
		Pizza pizzaATest = findFirst.get();
		assertEquals("PEP", pizzaATest.getCode());
		assertEquals("piponi", pizzaATest.getNom());
		assertTrue(BigDecimal.valueOf(12).compareTo(pizzaATest.getPrix()) == 0);
		assertEquals(CategoriePizza.POISSON, pizzaATest.getCategorie());
		
	}

	@Test
	public void testDeletePizza() {
		Set<Pizza> listPizza = pizzaDaoRef.findAllPizzas();
		assertEquals(8, listPizza.size());
		pizzaDaoRef.deletePizza("PEP");
		listPizza = pizzaDaoRef.findAllPizzas();
		assertEquals(7, listPizza.size());
		Optional<Pizza> findFirst = listPizza.stream().filter(p->"PEP".equals(p.getCode())).findFirst();
		assertFalse(findFirst.isPresent());
	}
	
	@Test(expected = DeletePizzaException.class)
	public void testDeletePizzaNonExistante() {
		pizzaDaoRef.deletePizza("PEP11");
	}

}
