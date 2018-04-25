package by.gsu.epamlab.dao;

import by.gsu.epamlab.beans.User;
import by.gsu.epamlab.exceptions.AuthenticationException;
import by.gsu.epamlab.exceptions.DAOException;

/**
 * DAO for users
 */
public interface IUserDAO {

	/**
	 * Add user in database
	 * 
	 * @param name
	 *            - user's name
	 * @param password
	 *            - user's
	 */
	void addUser(final String name, final String password) throws DAOException,
			AuthenticationException;

	/**
	 * Gets some user
	 * 
	 * @param name
	 *            - user's name
	 * @param password
	 *            - user's
	 * @return - some User
	 * @throws DAOException
	 * @throws AuthenticationException
	 */
	User getUser(String name, String password) throws DAOException,
			AuthenticationException;

	/**
	 * Gets user by id
	 * 
	 * @param userId
	 *            - user id
	 * @return - user
	 * @throws DAOException
	 */
	User getUserById(int userId) throws DAOException;

}
