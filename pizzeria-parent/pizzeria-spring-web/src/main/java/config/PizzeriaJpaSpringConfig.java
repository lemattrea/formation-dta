package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.pizzeria.doa.DaoFactory;
import fr.pizzeria.doa.DaoFactoryJpa;
import fr.pizzeria.doa.pizza.BatchPizza;
import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.doa.pizza.PizzaDaoImplJpaSpring;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("fr.pizzeria.repos")
public class PizzeriaJpaSpringConfig {

	@Bean
	public DaoFactory daoFactory() {
		DaoFactory facto = new DaoFactoryJpa();
		facto.setPizzaDao(iPizzaDao());
		return facto;
	}
	
	@Bean
	public IPizzaDao iPizzaDao() {
		return new PizzaDaoImplJpaSpring();
	}
	
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
		emf.setPersistenceUnitName("pizzeria-console");
		return emf;
	}
	

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}


	@Bean
	public DataSource dataSource(@Value("${dao.bdd.driver}") String driver, @Value("${dao.bdd.url}") String url,
			@Value("${dao.bdd.user}") String user, @Value("${dao.bdd.pwd}") String password) {
		DataSource source = new DriverManagerDataSource(url, user, password);
		((DriverManagerDataSource) source).setDriverClassName(driver);
		return source;
	}
	
	@Bean
	public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer prop = new PropertyPlaceholderConfigurer();
		prop.setLocation(new ClassPathResource("jdbc.properties"));
		return prop;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean
	public BatchPizza batchPizza() {
		return new BatchPizza();
	}
}
