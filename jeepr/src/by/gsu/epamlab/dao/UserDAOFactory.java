package by.gsu.epamlab.dao;

import by.gsu.epamlab.dao.DataBaseUserDAO;
import by.gsu.epamlab.dao.IUserDAO;

/**
 * Factory for user DAO
 */
public class UserDAOFactory {
	/**
	 * Hided constructor
	 */
	private UserDAOFactory() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Factory method
	 * 
	 * @return DAO instance
	 */
	public static IUserDAO getClassFromFactory() {
		return new DataBaseUserDAO();
	}
}
