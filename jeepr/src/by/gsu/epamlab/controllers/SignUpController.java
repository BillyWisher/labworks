package by.gsu.epamlab.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.beans.User;
import by.gsu.epamlab.dao.IUserDAO;
import by.gsu.epamlab.dao.UserDAOFactory;
import by.gsu.epamlab.exceptions.AuthenticationException;
import by.gsu.epamlab.exceptions.DAOException;
import by.gsu.epamlab.managers.UserUtils;

/**
 * Servlet implementation class SignUpController
 */
public class SignUpController extends AbstractController {
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
			final IUserDAO dao = UserDAOFactory.getClassFromFactory();
			synchronized (this) {
				dao.addUser(login, password);
			}
			final User user = dao.getUser(login, password);
			final HttpSession session = request.getSession(true);
			UserUtils.setUserInSession(session, user);
			UserUtils.setUserCookies(response, user);

			response.sendRedirect(request.getContextPath()
					+ Constants.CONTROLLER_MAIN);
		} catch (final AuthenticationException ex) {
			System.err.println(ex.getMessage());
			request.setAttribute(Constants.ATTRIBUTE_INFO,
					Constants.USER_EXISTS);
			request.getRequestDispatcher(Constants.PAGE_LOGIN).forward(request,
					response);
		} catch (final DAOException ex) {
			System.err.println(ex.getMessage());
			request.setAttribute(Constants.ATTRIBUTE_INFO,
					Constants.MESSAGE_SOMETHING_WENT_WRONG);
			request.getRequestDispatcher(Constants.PAGE_LOGIN).forward(request,
					response);
		}
	}

}
