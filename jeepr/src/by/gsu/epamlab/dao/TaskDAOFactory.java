package by.gsu.epamlab.dao;

/**
 * Factory for task DAO
 */
public class TaskDAOFactory {
	/**
	 * Hided constructor
	 */
	private TaskDAOFactory() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Factory method
	 * 
	 * @return DAO instance
	 */
	public static ITaskDAO getClassFromFactory() {
		return new DataBaseTaskDAO();
	}
}
