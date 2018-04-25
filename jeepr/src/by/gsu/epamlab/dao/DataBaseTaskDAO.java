package by.gsu.epamlab.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.beans.Task;
import by.gsu.epamlab.beans.TaskSections;
import by.gsu.epamlab.beans.TaskStatus;
import by.gsu.epamlab.beans.User;
import by.gsu.epamlab.database.DBConnector;
import by.gsu.epamlab.exceptions.DAOException;

public class DataBaseTaskDAO implements ITaskDAO {
	/**
	 * Constants
	 */
	private static final int OWNER_QUERY_PLACE = 1;
	private static final int DESCRIPTION_QUERY_PLACE = 2;
	private static final int DATE_QUERY_PLACE = 3;
	private static final int FILE_QUERY_PLACE = 4;
	private static final int STATUS_QUERY_PLACE = 6;
	private static final int FILENAME_QUERY_PLACE = 5;
	private static final int ID_UPDATE_QUERY_PLACE = 7;
	private static final int ID_DELETE_QUERY_PLACE = 1;
	private static final int WRITE_FILE_QUERY_PLACE = 1;
	private static final int WRITE_FILENAME_QUERY_PLACE = 2;
	private static final int WRITE_ID_QUERY_PLACE = 3;
	private static final int ID_TASK_PLACE = 1;

	/**
	 * Changes task status to ACTIVE
	 * 
	 * @param task
	 *            - task to activate
	 * @throws DAOException
	 */
	@Override
	public void activateTask(final Task task) throws DAOException {
		this.changeTaskStatus(task, TaskStatus.ACTIVE);
	}

	/**
	 * Add some task to base
	 * 
	 * @param task
	 *            - some task
	 * @throws DAOException
	 */
	@Override
	public void addTask(final Task task) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DBConnector.getConnection();
			statement = connection.prepareStatement(Constants.QUERY_ADD_TASK);
			statement.setInt(DataBaseTaskDAO.OWNER_QUERY_PLACE, task.getOwner()
					.getId());
			statement.setString(DataBaseTaskDAO.DESCRIPTION_QUERY_PLACE,
					task.getDescription());
			statement.setDate(DataBaseTaskDAO.DATE_QUERY_PLACE, task.getDate());
			statement.setBlob(DataBaseTaskDAO.FILE_QUERY_PLACE, task.getFile());
			statement.setString(DataBaseTaskDAO.FILENAME_QUERY_PLACE,
					task.getFileName());
			statement.setString(DataBaseTaskDAO.STATUS_QUERY_PLACE, task
					.getStatus().toString());
			synchronized (this) {
				statement.execute();
			}
		} catch (SQLException | NamingException ex) {
			throw new DAOException(ex.getMessage());
		} finally {
			DBConnector.closeResource(statement, connection);
		}
	}

	/**
	 * Changes task status
	 * 
	 * @param task
	 *            - task to change
	 * @param status
	 *            - status to set
	 * @throws DAOException
	 */
	@Override
	public void changeTaskStatus(final Task task, final TaskStatus status)
			throws DAOException {
		if (task != null) {
			task.setStatus(status);
			this.updateTask(task);
		}
	}

	/**
	 * Changes task status to DELETED
	 * 
	 * @param task
	 *            - task to delete
	 * @throws DAOException
	 */
	@Override
	public void deleteTask(final Task task) throws DAOException {
		this.changeTaskStatus(task, TaskStatus.DELETED);
	}

	/**
	 * Changes task status to FIXED
	 * 
	 * @param task
	 *            - task to fix
	 * @throws DAOException
	 */
	@Override
	public void fixTask(final Task task) throws DAOException {
		this.changeTaskStatus(task, TaskStatus.FIXED);
	}

	/**
	 * Gets task by its id
	 * 
	 * @param id
	 *            - task id
	 * @throws DAOException
	 */
	@Override
	public Task getTaskById(final int id) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DBConnector.getConnection();
			statement = connection
					.prepareStatement(Constants.QUERY_GET_TASK_BY_ID);
			statement.setInt(DataBaseTaskDAO.ID_TASK_PLACE, id);
			resultSet = statement.executeQuery();
			if (resultSet.first()) {
				final int ownerId = resultSet
						.getInt(Constants.COLUMN_TASK_OWNER);
				final String description = resultSet
						.getString(Constants.COLUMN_TASK_DESCRIPTION);
				final Date date = resultSet.getDate(Constants.COLUMN_TASK_DATE);
				final Blob fileBlob = resultSet
						.getBlob(Constants.COLUMN_TASK_FILE);
				InputStream file = null;
				if (fileBlob != null) {
					file = fileBlob.getBinaryStream();
				}
				final String fileName = resultSet
						.getString(Constants.COLUMN_TASK_FILENAME);
				final TaskStatus status = TaskStatus.valueOf(resultSet
						.getString(Constants.COLUMN_TASK_STATUS));
				return new Task(id, new DataBaseUserDAO().getUserById(ownerId),
						description, date, file, fileName, status);
			}
			return null;
		} catch (SQLException | NamingException ex) {
			throw new DAOException(ex.getMessage());
		} finally {
			DBConnector.closeResource(statement, resultSet, connection);
		}
	}

	/**
	 * Gets task from base for some user
	 * 
	 * @param user
	 *            - some user
	 * @param taskSections
	 *            - task's section
	 * @return - list of tasks
	 * @throws DAOException
	 */
	@Override
	public List<Task> getTasks(final User user, final TaskSections taskSection)
			throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Task> tasks = null;
		try {
			tasks = new ArrayList<>();
			connection = DBConnector.getConnection();
			statement = connection
					.prepareStatement(Constants.QUERY_GET_TASK_HEAD
							+ taskSection.getSectionQuery()
							+ Constants.QUERY_GET_TASK_TAIL);
			statement.setInt(DataBaseTaskDAO.OWNER_QUERY_PLACE, user.getId());
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				final int id = resultSet.getInt(Constants.COLUMN_TASK_ID);
				final int ownerId = resultSet
						.getInt(Constants.COLUMN_TASK_OWNER);
				final String description = resultSet
						.getString(Constants.COLUMN_TASK_DESCRIPTION);
				final Date date = resultSet.getDate(Constants.COLUMN_TASK_DATE);
				final Blob fileBlob = resultSet
						.getBlob(Constants.COLUMN_TASK_FILE);
				InputStream file = null;
				if (fileBlob != null) {
					file = fileBlob.getBinaryStream();
				}
				final String fileName = resultSet
						.getString(Constants.COLUMN_TASK_FILENAME);
				final TaskStatus status = TaskStatus.valueOf(resultSet
						.getString(Constants.COLUMN_TASK_STATUS));
				tasks.add(new Task(id, new DataBaseUserDAO()
						.getUserById(ownerId), description, date, file,
						fileName, status));
			}
			return tasks;
		} catch (SQLException | NamingException ex) {
			throw new DAOException(ex.getMessage());
		} finally {
			DBConnector.closeResource(statement, resultSet, connection);
		}
	}

	/**
	 * Deletes task from base
	 * 
	 * @param task
	 *            - task to delete
	 * @throws DAOException
	 */
	@Override
	public void hardDeleteTask(final Task task) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DBConnector.getConnection();
			statement = connection
					.prepareStatement(Constants.QUERY_HARD_DELETE_TASK);
			statement.setInt(DataBaseTaskDAO.ID_DELETE_QUERY_PLACE,
					task.getId());
			synchronized (this) {
				statement.execute();
			}
		} catch (SQLException | NamingException ex) {
			throw new DAOException(ex.getMessage());
		} finally {
			DBConnector.closeResource(statement, connection);
		}
	}

	/**
	 * Load some task file
	 * 
	 * @param task
	 *            - task to load
	 * @param file
	 *            - file input stream
	 * @param fileName
	 *            - file name
	 * @throws DAOException
	 */
	@Override
	public void loadTaskFile(final Task task, final InputStream file,
			final String fileName) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DBConnector.getConnection();
			statement = connection.prepareStatement(Constants.QUERY_LOADFILE);
			statement.setString(DataBaseTaskDAO.WRITE_FILENAME_QUERY_PLACE,
					fileName);
			statement.setBlob(DataBaseTaskDAO.WRITE_FILE_QUERY_PLACE, file);
			statement
					.setInt(DataBaseTaskDAO.WRITE_ID_QUERY_PLACE, task.getId());
			synchronized (this) {
				statement.execute();
			}
		} catch (SQLException | NamingException ex) {
			throw new DAOException(ex.getMessage());
		} finally {
			DBConnector.closeResource(statement, connection);
		}
	}

	/**
	 * Updates some task
	 * 
	 * @param task
	 *            - some task
	 * @throws DAOException
	 */
	@Override
	public void updateTask(final Task task) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DBConnector.getConnection();
			statement = connection
					.prepareStatement(Constants.QUERY_UPDATE_TASK);
			statement.setInt(DataBaseTaskDAO.OWNER_QUERY_PLACE, task.getOwner()
					.getId());
			statement.setString(DataBaseTaskDAO.DESCRIPTION_QUERY_PLACE,
					task.getDescription());
			statement.setDate(DataBaseTaskDAO.DATE_QUERY_PLACE, task.getDate());
			statement.setBlob(DataBaseTaskDAO.FILE_QUERY_PLACE, task.getFile());
			statement.setString(DataBaseTaskDAO.FILENAME_QUERY_PLACE,
					task.getFileName());
			statement.setString(DataBaseTaskDAO.STATUS_QUERY_PLACE, task
					.getStatus().toString());
			statement.setInt(DataBaseTaskDAO.ID_UPDATE_QUERY_PLACE,
					task.getId());
			synchronized (this) {
				statement.execute();
			}
		} catch (SQLException | NamingException ex) {
			throw new DAOException(ex.getMessage());
		} finally {
			DBConnector.closeResource(statement, connection);
		}
	}

}
