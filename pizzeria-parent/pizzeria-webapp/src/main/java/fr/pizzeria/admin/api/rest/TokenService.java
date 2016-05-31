package fr.pizzeria.admin.api.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TokenService {

	private List<String> tokenValides = new ArrayList<>();

	public String generateNewToken() {
		String token = UUID.randomUUID().toString();
		tokenValides.add(token);
		return token;
	}

	public boolean isTokenValide(String token) {
		return tokenValides.contains(token);
	}

}
