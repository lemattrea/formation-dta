package fr.pizzeria.admin.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "/*" })
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Boolean log = (Boolean)((HttpServletRequest)request).getSession().getAttribute("login");
		String requestURI = ((HttpServletRequest)request).getRequestURI();
		long before = System.currentTimeMillis();
		if(requestURI.contains("/login") || requestURI.contains("/api") || requestURI.contains("/Images") || requestURI.contains("/css") || (log != null && log)) {
			chain.doFilter(request, response);
		}
		else{
			((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath()+"/login");
		}
		long after = System.currentTimeMillis();
		Object time = ((HttpServletRequest)request).getServletContext().getAttribute("time_servlet");
		Map<String, Integer> list;
		if(time == null) {
			list = new HashMap<>();
		}else{
			list = (Map<String, Integer>)time;
			if(list.containsKey(requestURI)){
				list.remove(requestURI);
			}
		}
		list.put(requestURI, (int) (after-before));
		((HttpServletRequest)request).getServletContext().setAttribute("time_servlet", list);
	}

	@Override
	public void destroy() {}

}
