package fr.pizzeria.doa;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.pizzeria.doa.pizza.BatchPizza;
import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.doa.pizza.PizzaDaoImplJpaSpring;

@Configuration
@EnableTransactionManagement
public class PizzaDaoJpaSpringConfTest {

	@Bean
	public PlatformTransactionManager txManager() {
		return new JpaTransactionManager();
	}

	@Bean
	public IPizzaDao pizzaDaoJpaTemplate() {
		return new PizzaDaoImplJpaSpring();
	}

	@Bean
	public LocalEntityManagerFactoryBean localEntityManagerFactoryBean() {
		LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
		emf.setPersistenceUnitName("pizzeria-console");
		return emf;
	}

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScripts("db-schema.sql")
				.addScripts("db-data.sql").build();
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
