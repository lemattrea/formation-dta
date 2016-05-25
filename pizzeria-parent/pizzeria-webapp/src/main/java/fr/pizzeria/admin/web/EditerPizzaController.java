package fr.pizzeria.admin.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
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

public class EditerPizzaController extends HttpServlet {
	
	private IPizzaDao pizzaDao = IPizzaDao.DEFAULT_IMPLEMENTATION;
	private static final Logger LOG = Logger.getLogger(EditerPizzaController.class.toString());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");

		if (StringUtils.isBlank(code)) {
			resp.sendError(400, "paramètre incorrect");
		}
		
		try {
			Set<Pizza> pizzas = pizzaDao.findAllPizzas();
			Optional<Pizza> pizza = pizzas.stream().filter(p -> p.getCode().equals(code)).findFirst();
			req.setAttribute("listePizza", pizza.get());
			resp.setStatus(200);
			
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/editerPizza.jsp");
			dispatcher.forward(req, resp);
			
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
		}else{
			try{
				Pizza newPizza = new Pizza(code, nom,new BigDecimal(prix), CategoriePizza.valueOf(categ));
				pizzaDao.updatePizza(code, newPizza);
				resp.setStatus(201);
				resp.sendRedirect(req.getContextPath()+"/pizzas/list");
			}catch(DaoException e ) {
				resp.sendError(500, "Problème lors de la création de la pizza : pizza inexistante");
			}catch(NumberFormatException e) {
				resp.sendError(400, "Format des paramètres incorect");
			}
			
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		LOG.info(code);
		if (StringUtils.isBlank(code)) {
			resp.sendError(400, "nombre de paramètre incorrect");
		}else{
			try{
				pizzaDao.deletePizza(code);
			}catch(DaoException e ) {
				resp.sendError(500, "Problème lors de la création de la pizza : pizza inexistante");
			}catch(NumberFormatException e) {
				resp.sendError(400, "Format des paramètres incorect");
			}
			
		}
	}

}
