package fr.pizzeria.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.pizzeria.doa.DaoFactory;
import fr.pizzeria.doa.DaoFactoryMemoire;

@Configuration
public class PizzeriaMemoireSpringConfig {

	@Bean
	public DaoFactory daoFactory() {
		return new DaoFactoryMemoire();
	}
	
}
