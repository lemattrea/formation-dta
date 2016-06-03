package fr.pizzeria.doa.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaMapper implements RowMapper<Pizza> {

	public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pizza p = new Pizza();
		p.setCode(rs.getString("id"));
		p.setNom(rs.getString("nom"));
		p.setPrix(rs.getBigDecimal("prix"));
		p.setCategorie(CategoriePizza.valueOf(rs.getString("categorie")));
		return p;
	}

}