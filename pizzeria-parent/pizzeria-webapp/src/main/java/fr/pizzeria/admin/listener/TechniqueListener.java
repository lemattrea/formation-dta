package fr.pizzeria.admin.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class TechniqueListener implements HttpSessionListener {

	private static final String OPEN_SESSION = "openSession";

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		Object nbSession = se.getSession().getServletContext().getAttribute(OPEN_SESSION);
		if (nbSession == null) {
			se.getSession().getServletContext().setAttribute(OPEN_SESSION, 1);
		} else {
			se.getSession().getServletContext().setAttribute(OPEN_SESSION, (Integer) nbSession + 1);
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		Object nbSession = se.getSession().getServletContext().getAttribute(OPEN_SESSION);
		if (nbSession != null) {
			se.getSession().getServletContext().setAttribute(OPEN_SESSION, (Integer) nbSession - 1);
		}
	}

}
