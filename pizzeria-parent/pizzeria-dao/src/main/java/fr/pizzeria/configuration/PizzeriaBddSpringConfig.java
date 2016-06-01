package fr.pizzeria.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import fr.pizzeria.doa.DaoFactory;
import fr.pizzeria.doa.DaoFactoryBdd;

@Configuration
public class PizzeriaBddSpringConfig {

	@Bean
	public DaoFactory daoFactory(@Value("${dao.bdd.driver}") String driver,@Value("${dao.bdd.url}") String url,@Value("${dao.bdd.user}") String user,@Value("${dao.bdd.pwd}") String password) throws ClassNotFoundException {
		return new DaoFactoryBdd(driver, url, user, password);
	}
	
	@Bean
	public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer prop = new PropertyPlaceholderConfigurer();
		prop.setLocation(new ClassPathResource("jdbc.properties"));
		return prop;
	}
	
}
