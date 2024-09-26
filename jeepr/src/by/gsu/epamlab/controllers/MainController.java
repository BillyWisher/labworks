package by.gsu.epamlab.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.beans.Task;
import by.gsu.epamlab.beans.TaskSections;
import by.gsu.epamlab.beans.User;
import by.gsu.epamlab.dao.ITaskDAO;
import by.gsu.epamlab.dao.TaskDAOFactory;
import by.gsu.epamlab.exceptions.DAOException;
import by.gsu.epamlab.managers.UserUtils;

/**
 * Main controller
 */
public class MainController extends AbstractController {

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
		try {
			if (request.getSession().getAttribute(Constants.ATTRIBUTE_SECTION) == null) {
				request.getSession().setAttribute(Constants.ATTRIBUTE_SECTION,
						TaskSections.TODAY);
			}
			final ITaskDAO taskDao = TaskDAOFactory.getClassFromFactory();
			final User user = UserUtils
					.getUserFromSession(request.getSession());
			final TaskSections section = (TaskSections) request.getSession()
					.getAttribute(Constants.ATTRIBUTE_SECTION);
			final List<Task> tasks = taskDao.getTasks(user, section);
			final List<String> allowedOperations = section
					.getAllowedOperations();
			request.setAttribute(Constants.ATTRIBUTE_OPERATIONS,
					allowedOperations);
			request.setAttribute(Constants.ATTRIBUTE_TASKS, tasks);
			request.getRequestDispatcher(Constants.PAGE_MAIN).forward(request,
					response);
		} catch (final DAOException ex) {
			System.err.println("DAOException------->" + ex.getMessage());
			request.setAttribute(Constants.ATTRIBUTE_INFO,
					Constants.MESSAGE_SOMETHING_WENT_WRONG);
			request.getRequestDispatcher(Constants.PAGE_MAIN).forward(request,
					response);
		}
	}

}
