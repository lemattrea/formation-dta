package fr.pizzeria.doa.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.pizzeria.model.Performance;

public class PerformanceMapper implements RowMapper<Performance> {

	public Performance mapRow(ResultSet rs, int rowNum) throws SQLException {
		Performance p = new Performance();
		p.setId(rs.getInt("id"));
		p.setService(rs.getString("service"));
		p.setDate(rs.getTimestamp("date").toLocalDateTime());
		p.setTempsExecution(rs.getInt("tempsExecution"));
		return p;
		
	}

}