package fr.pizzeria.ihm.menu.option;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.doa.pizza.PizzaDaoImplMemory;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenuTest {
	
	private NouvellePizzaOptionMenu optionMenu;
	private IPizzaDao pizzaDao;
	
	@Rule public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	@Rule public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	
	@Before
	public void setUp() throws Exception{
		Locale.setDefault(Locale.FRENCH);
		Scanner scanner = new Scanner(System.in);
		pizzaDao = new PizzaDaoImplMemory();
		optionMenu = new NouvellePizzaOptionMenu(scanner, pizzaDao);
		
	}
	@Test
	public void testExecute() throws IOException {
		systemInMock.provideLines("new", "nouvellePizz", "12,0", "0");
		boolean next = optionMenu.execute();
		assertTrue(next);
		Set<Pizza> allPizza = pizzaDao.findAllPizzas();
		Optional<Pizza> findFirst = allPizza.stream().filter(p->"new".equals(p.getCode())).findFirst();
		assertTrue(findFirst.isPresent());
		Pizza pizza = findFirst.get();
		assertEquals("new", pizza.getCode());
		assertEquals("nouvellePizz", pizza.getNom());
		assertTrue(BigDecimal.valueOf(12).compareTo(pizza.getPrix()) == 0);
		assertEquals(CategoriePizza.VIANDE, pizza.getCategorie());
		
		String outAttendu = Files.lines(Paths.get("src/test/resources/fr/pizzeria/ihm/menu/option/resultatNouvellePizza.txt")).collect(Collectors.joining(System.lineSeparator()));
		outAttendu += System.lineSeparator();
		
		
		assertEquals(outAttendu, systemOutRule.getLog());
	}

}
