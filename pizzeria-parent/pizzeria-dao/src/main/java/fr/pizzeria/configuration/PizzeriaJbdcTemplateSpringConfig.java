package fr.pizzeria.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.pizzeria.doa.DaoFactory;
import fr.pizzeria.doa.DaoFactoryJdbcTemplate;
import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.doa.pizza.PizzaDaoImplJdbcTemplate;

@Configuration
@EnableTransactionManagement
public class PizzeriaJbdcTemplateSpringConfig {

	@Bean
	public DaoFactory daoFactory(DataSource dataSource) {
		DaoFactory dao = new DaoFactoryJdbcTemplate();
		dao.setPizzaDao(iPizzaDao(dataSource));
		return dao;
	}

	@Bean
	public PlatformTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public IPizzaDao iPizzaDao(DataSource dataSource) {
		return new PizzaDaoImplJdbcTemplate(dataSource, txManager(dataSource));
	}

	@Bean
	public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer prop = new PropertyPlaceholderConfigurer();
		prop.setLocation(new ClassPathResource("jdbc.properties"));
		return prop;
	}

	@Bean
	public DataSource dataSource(@Value("${dao.bdd.driver}") String driver, @Value("${dao.bdd.url}") String url,
			@Value("${dao.bdd.user}") String user, @Value("${dao.bdd.pwd}") String password) {
		DataSource source = new DriverManagerDataSource(url, user, password);
		((DriverManagerDataSource) source).setDriverClassName(driver);
		return source;
	}

}
