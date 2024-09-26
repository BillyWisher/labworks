package by.gsu.epamlab.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
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
 * Servlet implementation class LogInController
 */
public class LogInController extends AbstractController {
	/**
	 * Constants
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Request processor
	 * 
	 * @param request
	 *            - input request
	 * @param response
	 *            - output response
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	public void processRequest(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		try {
			final String login = request.getParameter(Constants.LOGIN_PARAM);
			final String password = request
					.getParameter(Constants.PASSWORD_PARAM);
			final HttpSession session = request.getSession(true);
			final User user = UserDAOFactory.getClassFromFactory().getUser(
					login, password);
			if (UserUtils.getUserFromSession(session) != null) {
				response.sendRedirect(request.getContextPath()
						+ Constants.CONTROLLER_MAIN);
				return;
			}
			final String rememberMeParam = request
					.getParameter(Constants.REMEMBER_ME_PARAM);
			final boolean rememberMe = "true".equals(rememberMeParam);
			UserUtils.setUserInSession(session, user);
			if (rememberMe) {
				UserUtils.setUserCookies(response, user);
			} else {
				UserUtils.deleteCookies(response);
			}
			response.sendRedirect(request.getContextPath()
					+ Constants.CONTROLLER_MAIN);
		} catch (final AuthenticationException ex) {
			System.err.println("LOGIN.AuthenticationException------->"
					+ ex.getMessage());
			request.setAttribute(Constants.ATTRIBUTE_INFO,
					Constants.AUTHENTICATION_EXCEPTION);
			request.getRequestDispatcher(Constants.PAGE_LOGIN).forward(request,
					response);
		} catch (final DAOException ex) {
			System.err.println("LOGIN.DAOException------->" + ex.getMessage());
			request.setAttribute(Constants.ATTRIBUTE_INFO,
					Constants.MESSAGE_SOMETHING_WENT_WRONG);
			request.getRequestDispatcher(Constants.PAGE_LOGIN).forward(request,
					response);
		}
	}

}
