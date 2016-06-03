package fr.pizzeria.doa.pizza;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import fr.pizzeria.doa.mapper.PizzaMapper;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplJdbcTemplate implements IPizzaDao {
	private JdbcTemplate jdbcTemplate;
	private TransactionTemplate tx;
	Logger LOG = Logger.getLogger(IPizzaDao.class.toString());

	public PizzaDaoImplJdbcTemplate(DataSource datasource, PlatformTransactionManager tx) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
		this.tx = new TransactionTemplate(tx);
	}

	@Override
	public Set<Pizza> findAllPizzas() {
		String sql = "SELECT * FROM PIZZA";
		return this.jdbcTemplate.query(sql, new PizzaMapper()).stream().collect(Collectors.toSet());
	}

	@Override
	public void saveNewPizza(Pizza newPizza) {
		String sql = "INSERT INTO pizza (id, nom, prix, categorie,url_image) VALUES (?, ?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, newPizza.getCode(), newPizza.getNom(), newPizza.getPrix(),
				newPizza.getCategorie().name(), "");
	}

	@Override
	public void updatePizza(String code, Pizza updatePizza) {
		String sql = "UPDATE pizza SET id=?, nom=?, prix=?, categorie=? WHERE id=?";
		this.jdbcTemplate.update(sql, updatePizza.getCode(), updatePizza.getNom(), updatePizza.getPrix(),
				updatePizza.getCategorie().name(), code);
	}

	@Override
	public void deletePizza(String code) {
		String sql = "DELETE FROM pizza WHERE id=?";
		this.jdbcTemplate.update(sql, code);
	}

	@Override
	public boolean transactionInsertPizza(List<Pizza> pizzas) {
		this.tx.execute(new TransactionCallbackWithoutResult() {
			@Override
	        protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
		        try {
		        	pizzas.stream().forEach(p -> saveNewPizza(p));
		        } catch (Exception e) {
		            transactionStatus.setRollbackOnly();
		            throw new SavePizzaException(e);
		        }
			}

		});
		return true;
	}

}
