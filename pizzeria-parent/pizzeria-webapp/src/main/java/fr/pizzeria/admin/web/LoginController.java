package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final String LOGIN = "login";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String adr = req.getParameter("addresse");
		String mdp = req.getParameter("mdp");

		if (StringUtils.isBlank(adr) || StringUtils.isBlank(mdp)) {
			resp.sendError(400, "nombre de paramètre incorrect");
		} else {
			if(req.getSession().getAttribute(LOGIN) == null) {
				if (adr.equals("admin@admin.fr") && mdp.equals("admin")) {
					req.getSession().setAttribute(LOGIN, true);
				}
			}
			resp.sendRedirect(req.getContextPath() + "/pizzas/list");
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute(LOGIN);
	}

}
