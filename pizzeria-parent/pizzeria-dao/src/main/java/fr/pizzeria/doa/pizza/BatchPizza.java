package fr.pizzeria.doa.pizza;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.repos.PizzaRepository;

public class BatchPizza {
	
	@PersistenceContext private EntityManager em;
	@Autowired(required=false) private PizzaRepository pizzaRepository;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public boolean savePizza(List<Pizza> pizzas){
		for (Pizza pizza : pizzas) {
			em.persist(pizza);
		}
		return true;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public boolean saveDataPizza(List<Pizza> pizzas){
		pizzas.stream().forEach(p -> {
			if(pizzaRepository.exists(p.getCode())) {
				throw new SavePizzaException();
			}else{
				pizzaRepository.save(p);
			}
		});
		return true;
	}
}
