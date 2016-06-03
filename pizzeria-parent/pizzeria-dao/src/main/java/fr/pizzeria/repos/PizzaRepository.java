package fr.pizzeria.repos;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, String>{
	
	Set<Pizza> findByNom(String nom);
	Set<Pizza> findByCode(String code);
	Set<Pizza> findPeopleDistinctByNomOrCode(String nom, String code);
	Set<Pizza> findByCategorie(CategoriePizza categorie);
	
}
