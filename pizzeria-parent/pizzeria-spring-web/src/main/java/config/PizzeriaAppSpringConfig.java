package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
//@Import(PizzeriaJpaSpringConfig.class)
@ComponentScan("fr.pizzeria.controller")
@EnableWebMvc
public class PizzeriaAppSpringConfig {
	
	
}
