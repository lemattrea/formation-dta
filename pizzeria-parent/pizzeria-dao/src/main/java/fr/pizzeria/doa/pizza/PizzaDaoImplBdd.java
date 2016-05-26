package fr.pizzeria.doa.pizza;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.inject.Named;

import fr.pizzeria.exception.ConnectionBddException;
import fr.pizzeria.exception.SqlBddException;
import fr.pizzeria.exception.StatementBddException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Named
public class PizzaDaoImplBdd implements IPizzaDao {

	private String password;
	private String user;
	private String url;

	public PizzaDaoImplBdd(String driver, String url, String user, String password) throws ClassNotFoundException {
		Class.forName(driver);
		this.url = url;
		this.user = user;
		this.password = password;
	}

	@Override
	public Set<Pizza> findAllPizzas() {

		Set<Pizza> pizzas = new TreeSet<>();
		// connection bdd
		try (Connection connection = getConnection();
				PreparedStatement statement = createStatement(connection, "SELECT * FROM pizza");
				ResultSet resultats = statement.executeQuery();) {

			while (resultats.next()) {
				String id = resultats.getString("id");
				String name = resultats.getString("nom");
				BigDecimal price = resultats.getBigDecimal("prix");
				String categ = resultats.getString("categorie");
				Pizza piz = new Pizza(id, name, price, CategoriePizza.valueOf(categ));
				pizzas.add(piz);
			}

			return pizzas;
		} catch (SQLException e) {
			throw new ConnectionBddException("Erreur lors de la connection à la BDD", e);
		}
	}

	@Override
	public void saveNewPizza(Pizza newPizza) {
		// connection bdd
		try (Connection connection = getConnection();
				PreparedStatement statement = createStatement(connection,
						"INSERT INTO pizza (id, nom, prix, categorie,url_image) VALUES (?, ?, ?, ?, ?)");) {

			statement.setString(1, newPizza.getCode());
			statement.setString(2, newPizza.getNom());
			statement.setString(3, newPizza.getPrix().toString());
			statement.setString(4, newPizza.getCategorie().name());
			statement.setString(5, "");
			int resultats = statement.executeUpdate();

			if (resultats == 0) {
				throw new SqlBddException("Pizza non crée : problème lors de la requete en Bdd");
			}
		} catch (SQLException e) {
			throw new SqlBddException("Pizza non crée : problème lors de la requete en Bdd", e);
		}

	}

	@Override
	public void updatePizza(String code, Pizza updatePizza) {
		// connection bdd
		try (Connection connection = getConnection();
				PreparedStatement statement = createStatement(connection,
						"UPDATE pizza SET id=?, nom=?, prix=?, categorie=? WHERE id=?");) {

			statement.setString(1, updatePizza.getCode());
			statement.setString(2, updatePizza.getNom());
			statement.setString(3, updatePizza.getPrix().toString());
			statement.setString(4, updatePizza.getCategorie().name());
			statement.setString(5, code);
			int resultats = statement.executeUpdate();

			if (resultats == 0) {
				throw new SqlBddException("Pizza non mise à jour : problème lors de la requete en Bdd");
			}
		} catch (SQLException e) {
			throw new ConnectionBddException("Pizza non mise à jour : problème lors de la requete en Bdd", e);
		}

	}

	@Override
	public void deletePizza(String code) {
		// connection bdd
		try (Connection connection = getConnection();
				PreparedStatement statement = createStatement(connection, "DELETE FROM pizza WHERE id=?");) {

			statement.setString(1, code);
			int resultats = statement.executeUpdate();

			if (resultats == 0) {
				throw new SqlBddException("Pizza non supprimé : problème lors de la requete en Bdd");
			}
		} catch (SQLException e) {
			throw new ConnectionBddException("Pizza non supprimé : problème lors de la requete en Bdd", e);
		}

	}

	/**
	 * 
	 * @param connection
	 * @return Statement
	 * @throws StatementBddException
	 */
	private PreparedStatement createStatement(Connection connection, String requete) {
		try {
			return connection.prepareStatement(requete);
		} catch (SQLException e) {
			throw new StatementBddException("erreur lors de la création du statement", e);
		}
	}

	/**
	 * 
	 * @return Connection
	 * @throws ConnectionBddException
	 */
	private Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new ConnectionBddException("erreur de connection à la Bdd", e);
		}
	}

	public boolean transactionInsertPizza(List<Pizza> pizzas) {
		Connection connection = getConnection();
		try (PreparedStatement statement = createStatement(connection, "INSERT INTO pizza (id, nom, prix, categorie,url_image) VALUES (?, ?, ?, ?, ?)");) {

			connection.setAutoCommit(false);
			for (Pizza pizza : pizzas) {
				statement.clearParameters();
				statement.setString(1, pizza.getCode());
				statement.setString(2, pizza.getNom());
				statement.setString(3, pizza.getPrix().toString());
				statement.setString(4, pizza.getCategorie().name());
				statement.setString(5, "");
				statement.executeUpdate();
			}
			connection.commit();
			connection.close();
			return true;

		} catch (SQLException e) {
			try {
				connection.rollback();
				connection.close();
			} catch (SQLException e1) {
				throw new ConnectionBddException("erreur de connection à la Bdd", e1);
			}
			return false;
		}
	}

}
