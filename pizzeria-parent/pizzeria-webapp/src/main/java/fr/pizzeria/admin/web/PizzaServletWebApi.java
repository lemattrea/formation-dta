package fr.pizzeria.admin.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.doa.pizza.PizzaDaoImplMemory;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaServletWebApi extends HttpServlet {

	private static final Logger LOG = Logger.getLogger(PizzaServletWebApi.class.toString());
	private IPizzaDao pizzaDao = IPizzaDao.DEFAULT_IMPLEMENTATION;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Set<Pizza> pizzas = pizzaDao.findAllPizzas();
			resp.setStatus(200);
			resp.getWriter().write(pizzas.toString());
		} catch (DaoException e) {
			resp.sendError(500, "désoler");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		String categ = req.getParameter("categorie");
		String prix = req.getParameter("prix");

		if (StringUtils.isBlank(code) || StringUtils.isBlank(nom) || StringUtils.isBlank(categ) || StringUtils.isBlank(prix)) {
			resp.sendError(400, "nombre de paramètre incorrect");
		}
		else{
			try{
				Pizza newPizza = new Pizza(code, nom,new BigDecimal(prix), CategoriePizza.valueOf(categ));
				pizzaDao.saveNewPizza(newPizza);
				resp.setStatus(201);
			}catch(DaoException e ) {
				resp.sendError(500, "Problème lors de la création de la pizza : déjà existante");
			}catch(NumberFormatException e) {
				resp.sendError(400, "Format des paramètres incorect");
			}
			
		}
	}

	/**
	 * a test
	 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		String categ = req.getParameter("categorie");
		String prix = req.getParameter("prix");
		
		if (StringUtils.isBlank(code) || StringUtils.isBlank(nom) || StringUtils.isBlank(categ) || StringUtils.isBlank(prix)) {
			resp.sendError(400, "nombre de paramètre incorrect");
		}else{
			try{
				Pizza newPizza = new Pizza(code, nom,new BigDecimal(prix), CategoriePizza.valueOf(categ));
				pizzaDao.updatePizza(code, newPizza);
				resp.setStatus(201);
			}catch(DaoException e ) {
				resp.sendError(500, "Problème lors de la création de la pizza : pizza inexistante");
			}catch(NumberFormatException e) {
				resp.sendError(400, "Format des paramètres incorect");
			}
			
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
	
	

}
