package fr.pizzeria.doa;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplFile implements IPizzaDao {
	
	private static final String REPERTOIRE_DATA = "data";
	
	public PizzaDaoImplFile() {
		
		/*
		pizzas.put("PEP",new Pizza("PEP","Pépéroni",12.50, CategoriePizza.SANS_VIANDE));
		pizzas.put("MAR",new Pizza("MAR","Margherita",12.50, CategoriePizza.VIANDE));
		pizzas.put("REI",new Pizza("REI","La Reine",12.50, CategoriePizza.POISSON));
		pizzas.put("FRO",new Pizza("FRO","La 4 fromages",12.50, CategoriePizza.SANS_VIANDE));
		pizzas.put("CAN",new Pizza("CAN","La cannibale",12.50, CategoriePizza.VIANDE));
		pizzas.put("SAV",new Pizza("SAV","La savoyarde",15, CategoriePizza.SANS_VIANDE));
		pizzas.put("ORI",new Pizza("ORI","L'orientale",12.50, CategoriePizza.POISSON));
		pizzas.put("IND",new Pizza("IND","L'indienne",12.50, CategoriePizza.SANS_VIANDE));*/
	}

	@Override
	public Set<Pizza> findAllPizzas() {
		try (Stream<Path> stream = Files.list(Paths.get(REPERTOIRE_DATA));){
			return stream.map(path -> {
				Pizza p = new Pizza();
				p.setCode(path.getFileName().toString().replaceAll(".txt", ""));
				String line;
				try {
					line = Files.readAllLines(path).get(0);
					String[] ligneTab = line.split(";");
					p.setNom(ligneTab[0]);
					p.setPrix(Double.valueOf(ligneTab[1]));
					p.setCategorie(CategoriePizza.valueOf(ligneTab[2]));
				} catch (IOException e) {
					e.printStackTrace();
				}
				return p;
			}).collect(Collectors.toSet());
			
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

	private String convertPizzaToString(Pizza p) {
		return p.getNom() + ";" + p.getPrix() + ";" + p.getCategorie().name();
	}
	

	@Override
	public void saveNewPizza(Pizza newPizza){
		try {
			Path nouveauFichier = Paths.get(REPERTOIRE_DATA + "/" + newPizza.getCode() + ".txt");
			Files.write(nouveauFichier, Arrays.asList(convertPizzaToString(newPizza)), StandardOpenOption.CREATE_NEW);
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePizza(String codePizza) throws DaoException {
		// TODO Auto-generated method stub
		
	}
	
	
}
