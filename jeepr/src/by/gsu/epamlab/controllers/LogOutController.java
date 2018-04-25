package by.gsu.epamlab.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.managers.UserUtils;

public class LogOutController extends AbstractController {
	/**
	 * Serial version
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
		request.getSession().invalidate();
		UserUtils.deleteCookies(response);
		response.sendRedirect(request.getContextPath() + Constants.PAGE_LOGIN);
	}

}
