package by.gsu.epamlab.controllers.actions;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.beans.Task;
import by.gsu.epamlab.beans.TaskSections;
import by.gsu.epamlab.beans.TaskStatus;
import by.gsu.epamlab.beans.User;
import by.gsu.epamlab.controllers.AbstractController;
import by.gsu.epamlab.dao.TaskDAOFactory;
import by.gsu.epamlab.exceptions.DAOException;
import by.gsu.epamlab.managers.UserUtils;

/**
 * Controller for creating some task
 */
@MultipartConfig
public class CreateTaskController extends AbstractController {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constants
	 */
	private static final String CONTENT_DISPOSITION = "content-disposition";
	private static final String FILE_NAME = "filename";
	private static final String SPLITTER = ";";
	private static final String EQUAL = "=";
	private static final String SLASH = "/";
	private static final String DOUBLE_REVERSE_SLASH = "\\";

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
			final User user = UserUtils
					.getUserFromSession(request.getSession());
			final String description = request
					.getParameter(Constants.CREATE_TASK_DESCRIPTION_PARAM);
			final TaskSections section = (TaskSections) request.getSession()
					.getAttribute(Constants.ATTRIBUTE_SECTION);
			final Date date = section.equals(TaskSections.SOMEDAY) ? Date
					.valueOf(request
							.getParameter(Constants.CREATE_TASK_DATE_PARAM))
					: section.getDate();

			InputStream file = null;
			String extractedFileName = null;
			for (final Part part : request.getParts()) {
				final String fileName = this.extractFileName(part);
				if ((fileName != null) && (fileName.length() > 0)) {
					file = part.getInputStream();
					extractedFileName = fileName;
				}
			}

			if (description == null) {
				throw new IllegalArgumentException();
			}

			final Task task = new Task(user, description, date, file,
					extractedFileName, TaskStatus.ACTIVE);
			synchronized (this) {
				TaskDAOFactory.getClassFromFactory().addTask(task);
			}

			response.sendRedirect(request.getContextPath()
					+ Constants.CONTROLLER_MAIN);
		} catch (final IllegalArgumentException | NoSuchMethodException ex) {
			System.err.println("CREATETASK.IllegalArgumentException -----> "
					+ ex.getMessage());
			request.setAttribute(Constants.ATTRIBUTE_INFO,
					Constants.NULL_VALUES_EXCEPTION);
			request.getRequestDispatcher(Constants.PAGE_CREATE_TASK).forward(
					request, response);
		} catch (final DAOException ex) {
			System.err.println("CREATETASK.DAOException -----> "
					+ ex.getMessage());
			request.setAttribute(Constants.ATTRIBUTE_INFO,
					Constants.ADD_TASK_EXCEPTION);
			request.getRequestDispatcher(Constants.PAGE_CREATE_TASK).forward(
					request, response);
		}
	}

	/**
	 * Extracts file name from Part
	 * 
	 * @param part
	 *            - part to extract
	 * @return - file name
	 */
	private String extractFileName(final Part part) {
		final String contentDisp = part
				.getHeader(CreateTaskController.CONTENT_DISPOSITION);
		final String[] items = contentDisp.split(CreateTaskController.SPLITTER);
		for (final String s : items) {
			if (s.trim().startsWith(CreateTaskController.FILE_NAME)) {
				String clientFileName = s.substring(
						s.indexOf(CreateTaskController.EQUAL) + 2,
						s.length() - 1);
				clientFileName = clientFileName.replace(
						CreateTaskController.DOUBLE_REVERSE_SLASH,
						CreateTaskController.SLASH);
				final int i = clientFileName
						.lastIndexOf(CreateTaskController.SLASH);
				return clientFileName.substring(i + 1);
			}
		}
		return null;
	}
}
