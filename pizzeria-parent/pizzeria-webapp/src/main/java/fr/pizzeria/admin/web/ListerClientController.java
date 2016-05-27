package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.ClientService;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Client;

@WebServlet("/clients")
public class ListerClientController extends HttpServlet {

	@Inject private ClientService clientService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Set<Client> client = clientService.findAll();
			req.setAttribute("listeClient", client);
			resp.setStatus(200);
			
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/listerClient.jsp");
			dispatcher.forward(req, resp);
			
		} catch (DaoException e) {
			resp.sendError(500, "désoler");
		}
	}

}
