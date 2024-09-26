package by.gsu.epamlab.controllers.actions;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.beans.Task;
import by.gsu.epamlab.beans.User;
import by.gsu.epamlab.controllers.AbstractController;
import by.gsu.epamlab.dao.ITaskDAO;
import by.gsu.epamlab.dao.TaskDAOFactory;
import by.gsu.epamlab.exceptions.DAOException;
import by.gsu.epamlab.managers.UserUtils;

/**
 * Controller for loading task files
 */
@MultipartConfig
public class LoadFileController extends AbstractController {

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
			final ITaskDAO dao = TaskDAOFactory.getClassFromFactory();
			final int taskId = Integer.parseInt(request
					.getParameter(Constants.LOAD_ID_PARAM));
			final Task task = dao.getTaskById(taskId);
			if ((task != null)
					&& user.getLogin().equals(task.getOwner().getLogin())) {
				InputStream file = null;
				String extractedFileName = null;
				for (final Part part : request.getParts()) {
					final String fileName = this.extractFileName(part);
					if ((fileName != null) && (fileName.length() > 0)) {
						file = part.getInputStream();
						extractedFileName = fileName;
					}
				}
				synchronized (this) {
					dao.loadTaskFile(task, file, extractedFileName);
				}
			} else {
				throw new IllegalArgumentException();
			}
			response.sendRedirect(request.getContextPath()
					+ Constants.CONTROLLER_MAIN);
		} catch (final DAOException ex) {
			System.err.println("LOADFILE.DAOException -----> "
					+ ex.getMessage());
			request.setAttribute(Constants.ATTRIBUTE_INFO,
					Constants.LOAD_EXCEPTION);
			request.getRequestDispatcher(Constants.PAGE_MAIN).forward(request,
					response);
		} catch (final IllegalArgumentException ex) {
			System.err.println("LOADFILE.IllegalArgumentException -----> "
					+ ex.getMessage());
			request.setAttribute(Constants.ATTRIBUTE_INFO,
					Constants.WRONG_TASK_EXCEPTION);
			request.getRequestDispatcher(Constants.PAGE_MAIN).forward(request,
					response);
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
				.getHeader(LoadFileController.CONTENT_DISPOSITION);
		final String[] items = contentDisp.split(LoadFileController.SPLITTER);
		for (final String s : items) {
			if (s.trim().startsWith(LoadFileController.FILE_NAME)) {
				String clientFileName = s
						.substring(s.indexOf(LoadFileController.EQUAL) + 2,
								s.length() - 1);
				clientFileName = clientFileName.replace(
						LoadFileController.DOUBLE_REVERSE_SLASH,
						LoadFileController.SLASH);
				final int i = clientFileName
						.lastIndexOf(LoadFileController.SLASH);
				return clientFileName.substring(i + 1);
			}
		}
		return null;
	}

}
