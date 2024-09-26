package by.gsu.epamlab.controllers.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.beans.TaskSections;
import by.gsu.epamlab.controllers.AbstractController;

/**
 * Controller for changing sections
 */
public class ChangeSectionController extends AbstractController {

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void processRequest(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		try {
			final HttpSession session = request.getSession();
			final TaskSections section = TaskSections.valueOf(request
					.getParameter(Constants.ATTRIBUTE_SECTION));
			session.setAttribute(Constants.ATTRIBUTE_SECTION, section);
			response.sendRedirect(request.getContextPath()
					+ Constants.CONTROLLER_MAIN);
		} catch (final IllegalArgumentException ex) {
			System.err.println("IllegalArgumentException------->"
					+ ex.getMessage());
			request.setAttribute(Constants.ATTRIBUTE_INFO,
					Constants.ILLEGAL_SECTION_EXCEPTION);
			request.getRequestDispatcher(Constants.PAGE_MAIN).forward(request,
					response);
		}
	}

}
