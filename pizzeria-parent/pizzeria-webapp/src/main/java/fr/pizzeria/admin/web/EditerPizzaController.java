package fr.pizzeria.admin.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import fr.pizzeria.admin.event.CreePizzaEvent;
import fr.pizzeria.admin.event.ModifierPizzaEvent;
import fr.pizzeria.admin.event.SupprimerPizzaEvent;
import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@WebServlet("/pizzas/edit")
public class EditerPizzaController extends HttpServlet {
	
	@Inject private Event<ModifierPizzaEvent> EventPizzaModif;
	@Inject private Event<SupprimerPizzaEvent> EventPizzaSuppr;
	@Inject private PizzaService pizzaService;
	private static final Logger LOG = Logger.getLogger(EditerPizzaController.class.toString());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");

		if (StringUtils.isBlank(code)) {
			resp.sendError(400, "paramètre incorrect");
		}
		
		try {
			Set<Pizza> pizzas = pizzaService.findAllPizzas();
			Optional<Pizza> pizza = pizzas.stream().filter(p -> p.getCode().equals(code)).findFirst();
			req.setAttribute("pizza", pizza.get());
			req.setAttribute("categories", CategoriePizza.values());
			resp.setStatus(200);
			
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/editerPizza.jsp");
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
				pizzaService.updatePizza(code, newPizza);
				ModifierPizzaEvent event = new ModifierPizzaEvent(newPizza, new Date());
				EventPizzaModif.fire(event);
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
				Set<Pizza> pizzas = pizzaService.findAllPizzas();
				Optional<Pizza> pizza = pizzas.stream().filter(p -> p.getCode().equals(code)).findFirst();
				Pizza pizzaDelete = pizza.get();
				pizzaService.deletePizza(code);
				SupprimerPizzaEvent event = new SupprimerPizzaEvent(pizzaDelete, new Date());
				EventPizzaSuppr.fire(event);
			}catch(DaoException e ) {
				resp.sendError(500, "Problème lors de la création de la pizza : pizza inexistante");
			}catch(NumberFormatException e) {
				resp.sendError(400, "Format des paramètres incorect");
			}
			
		}
	}

}
