package by.gsu.epamlab.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.beans.User;
import by.gsu.epamlab.dao.UserDAOFactory;
import by.gsu.epamlab.exceptions.AuthenticationException;
import by.gsu.epamlab.exceptions.DAOException;
import by.gsu.epamlab.managers.UserUtils;

/**
 * Filter cookies
 */
public class CookieFilter implements Filter {
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(final ServletRequest req, final ServletResponse res,
			final FilterChain chain) throws IOException, ServletException {
		final HttpServletRequest request = (HttpServletRequest) req;
		final HttpSession session = request.getSession();
		try {
			User user = UserUtils.getUserFromSession(session);
			if (user == null) {
				user = UserUtils.getUserFromCookies(request);
			}
			if ((user != null)
					&& user.equals(UserDAOFactory.getClassFromFactory()
							.getUser(user.getLogin(), user.getPassword()))) {
				UserUtils.setUserInSession(session, user);
				chain.doFilter(req, res);
			} else {
				throw new AuthenticationException(
						Constants.LOGGED_OUT_EXCEPTION);
			}
		} catch (final AuthenticationException | DAOException ex) {
			System.err.println("Filter--->" + ex.getMessage());
			final HttpServletResponse response = (HttpServletResponse) res;
			request.setAttribute(Constants.ATTRIBUTE_INFO, ex.getMessage());
			request.getRequestDispatcher(Constants.PAGE_LOGIN).forward(request,
					response);
		}
	}

	@Override
	public void init(final FilterConfig arg0) throws ServletException {
	}

}
