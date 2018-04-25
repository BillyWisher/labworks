package by.gsu.epamlab.controllers.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.controllers.AbstractController;

/**
 * Controller for distributing actions
 */
public class ActionController extends AbstractController {

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
		final String action = request.getParameter(Constants.ACTION_PARAM);
		request.getRequestDispatcher(action).forward(request, response);
	}

}
