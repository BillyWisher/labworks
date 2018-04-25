package by.gsu.epamlab.controllers.actions;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.beans.Task;
import by.gsu.epamlab.controllers.AbstractController;
import by.gsu.epamlab.dao.TaskDAOFactory;
import by.gsu.epamlab.exceptions.DAOException;

/**
 * Controller for downloading and deleting file from base
 */
public class TaskFileController extends AbstractController {

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
			final int id = Integer.parseInt(request
					.getParameter(Constants.DOWNLOAD_FILE_PARAM));
			final String deleteId = request
					.getParameter(Constants.DELETE_ID_PARAM);
			final Task task = TaskDAOFactory.getClassFromFactory().getTaskById(
					id);
			synchronized (this) {
				if ((deleteId == null) || (deleteId.length() == 0)) {
					final InputStream file = task.getFile();
					final String contentType = this.getServletContext()
							.getMimeType(task.getFileName());
					response.setContentType(contentType);
					response.setContentLength(file.available());
					response.setHeader("Content-Disposition",
							"attachment; filename=\"" + task.getFileName()
									+ "\"");

					final byte[] bytes = new byte[1024];
					int bytesRead;
					while ((bytesRead = file.read(bytes)) != -1) {
						response.getOutputStream().write(bytes, 0, bytesRead);
					}
					file.close();
					return;
				} else {
					TaskDAOFactory.getClassFromFactory().loadTaskFile(task,
							null, null);
					response.sendRedirect(request.getContextPath()
							+ Constants.CONTROLLER_MAIN);
				}
			}
		} catch (final DAOException ex) {
			System.err.println("DOWNLOADFILE.DAOException------->"
					+ ex.getMessage());
			request.setAttribute(Constants.ATTRIBUTE_INFO,
					Constants.DOWNLOAD_EXCEPTION);
			request.getRequestDispatcher(Constants.CONTROLLER_MAIN).forward(
					request, response);
		}
	}

}
