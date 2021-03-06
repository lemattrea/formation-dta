package fr.pizzeria.admin.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
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
import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@WebServlet("/pizzas/new")
public class NewPizzaController extends HttpServlet {

	@Inject private Event<CreePizzaEvent> EventPizzaCree;
	@Inject private PizzaService pizzaService;
	private static final Logger LOG = Logger.getLogger(NewPizzaController.class.toString());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/newPizza.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		String categ = req.getParameter("categorie");
		String prix = req.getParameter("prix");

		if (StringUtils.isBlank(code) || StringUtils.isBlank(nom) || StringUtils.isBlank(categ)
				|| StringUtils.isBlank(prix)) {
			resp.sendError(400, "nombre de paramètre incorrect");
		} else {
			try {
				Pizza newPizza = new Pizza(code, nom, new BigDecimal(prix), CategoriePizza.valueOf(categ));
				pizzaService.saveNewPizza(newPizza);
				CreePizzaEvent event = new CreePizzaEvent(newPizza, new Date());
				EventPizzaCree.fire(event);
				resp.setStatus(201);
				resp.sendRedirect(req.getContextPath() + "/pizzas/list");
			} catch (DaoException e) {
				resp.sendError(500, "Problème lors de la création de la pizza : pizza inexistante");
			} catch (NumberFormatException e) {
				resp.sendError(400, "Format des paramètres incorect");
			}

		}
	}

}
