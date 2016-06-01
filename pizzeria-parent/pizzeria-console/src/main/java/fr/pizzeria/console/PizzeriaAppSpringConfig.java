package fr.pizzeria.console;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import fr.pizzeria.configuration.PizzeriaJpaSpringConfig;

@Configuration
@Import(PizzeriaJpaSpringConfig.class)
@ComponentScan("fr.pizzeria.ihm")
public class PizzeriaAppSpringConfig {
	
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
	
}
