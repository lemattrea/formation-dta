package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.doa.pizza.IPizzaDao;
import fr.pizzeria.doa.pizza.PizzaDaoImplMemory;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class ListerPizzaController extends HttpServlet {

	private IPizzaDao pizzaDao = IPizzaDao.DEFAULT_IMPLEMENTATION;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Set<Pizza> pizzas = pizzaDao.findAllPizzas();
			req.setAttribute("listePizza", pizzas);
			resp.setStatus(200);
			
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/listerPizza.jsp");
			dispatcher.forward(req, resp);
			
		} catch (DaoException e) {
			resp.sendError(500, "désoler");
		}
	}

}
