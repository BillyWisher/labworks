package by.gsu.epamlab.dao;

import java.io.InputStream;
import java.util.List;

import by.gsu.epamlab.beans.Task;
import by.gsu.epamlab.beans.TaskSections;
import by.gsu.epamlab.beans.TaskStatus;
import by.gsu.epamlab.beans.User;
import by.gsu.epamlab.exceptions.DAOException;

/**
 * DAO for tasks
 */
public interface ITaskDAO {

	/**
	 * Changes task status
	 * 
	 * @param task
	 *            - task to change
	 * @param status
	 *            - status to set
	 * @throws DAOException
	 */
	public void changeTaskStatus(Task task, TaskStatus status)
			throws DAOException;

	/**
	 * Changes task status to ACTIVE
	 * 
	 * @param task
	 *            - task to activate
	 * @throws DAOException
	 */
	void activateTask(Task task) throws DAOException;

	/**
	 * Add some task to base
	 * 
	 * @param task
	 *            - some task
	 * @throws DAOException
	 */
	void addTask(Task task) throws DAOException;

	/**
	 * Changes task status to DELETED
	 * 
	 * @param task
	 *            - task to delete
	 * @throws DAOException
	 */
	void deleteTask(Task task) throws DAOException;

	/**
	 * Changes task status to FIXED
	 * 
	 * @param task
	 *            - task to fix
	 * @throws DAOException
	 */
	void fixTask(Task task) throws DAOException;

	/**
	 * Gets task by its id
	 * 
	 * @param id
	 *            - task id
	 * @throws DAOException
	 */
	Task getTaskById(int id) throws DAOException;

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
	List<Task> getTasks(User user, TaskSections taskSection)
			throws DAOException;

	/**
	 * Deletes task from base
	 * 
	 * @param task
	 *            - task to delete
	 * @throws DAOException
	 */
	void hardDeleteTask(Task task) throws DAOException;

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
	void loadTaskFile(Task task, final InputStream file, final String fileName)
			throws DAOException;

	/**
	 * Updates some task
	 * 
	 * @param task
	 *            - some task
	 * @throws DAOException
	 */
	void updateTask(Task task) throws DAOException;

}
