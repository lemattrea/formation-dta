package fr.pizzeria.configuration;

import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.pizzeria.doa.DaoFactory;
import fr.pizzeria.doa.DaoFactoryJpa;

@Configuration
public class PizzeriaJpaSpringConfig {

	@Bean
	public DaoFactory daoFactory() {
		return new DaoFactoryJpa(Persistence.createEntityManagerFactory("pizzeria-console"));
	}
	
}
