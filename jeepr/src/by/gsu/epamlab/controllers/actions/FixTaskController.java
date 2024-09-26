package by.gsu.epamlab.controllers.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.controllers.AbstractController;
import by.gsu.epamlab.dao.ITaskDAO;
import by.gsu.epamlab.dao.TaskDAOFactory;
import by.gsu.epamlab.exceptions.DAOException;

/**
 * Controller for fixing tasks
 */
public class FixTaskController extends AbstractController {
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constants
	 */
	private static final String CSV_DELIMITER = ";";

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
			final String[] ids = request.getParameter(Constants.TARGETS_PARAM)
					.split(FixTaskController.CSV_DELIMITER);
			final ITaskDAO dao = TaskDAOFactory.getClassFromFactory();
			for (final String id : ids) {
				synchronized (this) {
					dao.fixTask(dao.getTaskById(new Integer(id)));
				}
			}
			response.sendRedirect(request.getContextPath()
					+ Constants.CONTROLLER_MAIN);
		} catch (final DAOException ex) {
			System.err.println("FIXCONTROLLER------->" + ex.getMessage());
			request.setAttribute(Constants.ATTRIBUTE_INFO,
					Constants.FIX_TASK_EXCEPTION);
			request.getRequestDispatcher(Constants.PAGE_MAIN).forward(request,
					response);
		}
	}
}
