package by.gsu.epamlab.managers;

import java.util.ResourceBundle;

/**
 * Class for managing configuration from properties
 */
public class ConfigurationManager {
	/**
	 * Fields
	 */
	private static final ResourceBundle resourceBundle = ResourceBundle
			.getBundle("by.gsu.epamlab.managers.config");

	/**
	 * No-arg constructor
	 */
	private ConfigurationManager() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Takes information from file
	 * 
	 * @param key
	 *            - key for parameters
	 * @return - parameter
	 */
	public static String getProperty(final String key) {
		return ConfigurationManager.resourceBundle.getString(key);
	}
}
