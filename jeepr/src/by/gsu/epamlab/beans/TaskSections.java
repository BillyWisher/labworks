package by.gsu.epamlab.beans;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import by.gsu.epamlab.Constants;

;

/**
 * Different sections of user's tasks
 */
public enum TaskSections {

	TODAY(Constants.SECTION_QUERY_TODAY + "'" + TaskStatus.ACTIVE + "'",
			TaskOperations.CREATE.toString(), TaskOperations.DELETE.toString(),
			TaskOperations.FIX.toString()) {

		@Override
		public Date getDate() {
			return new Date(System.currentTimeMillis());
		}
	},

	TOMORROW(Constants.SECTION_QUERY_TOMORROW + "'" + TaskStatus.ACTIVE + "'",
			TaskOperations.CREATE.toString(), TaskOperations.DELETE.toString(),
			TaskOperations.FIX.toString()) {

		@Override
		public Date getDate() {
			final long dayInMillis = 86400000;
			return new Date(System.currentTimeMillis() + dayInMillis);
		}
	},

	SOMEDAY(Constants.SECTION_QUERY_SOMEDAY + "'" + TaskStatus.ACTIVE + "'",
			TaskOperations.CREATE.toString(), TaskOperations.DELETE.toString(),
			TaskOperations.FIX.toString()),

	DELETED(Constants.SECTION_QUERY_DELETED + "'" + TaskStatus.DELETED + "'",
			TaskOperations.HARDDELETE.toString(), TaskOperations.RESTORE
					.toString()),

	FIXED(Constants.SECTION_QUERY_FIXED + "'" + TaskStatus.FIXED + "'",
			TaskOperations.DELETE.toString(), TaskOperations.UNFIX.toString());

	/**
	 * Fields
	 */
	private String sectionQuery;
	private List<String> sectionOperations;

	/**
	 * Constructor with args
	 * 
	 * @param sectionQuery
	 *            - query for current section
	 * @param sectionOperations
	 *            - operations for current section
	 */
	private TaskSections(final String sectionQuery,
			final String... sectionOperations) {
		this.sectionQuery = sectionQuery;
		this.sectionOperations = Arrays.asList(sectionOperations);
	}

	/**
	 * @return - section operations to return
	 */
	public List<String> getAllowedOperations() {
		return this.sectionOperations;
	}

	/**
	 * @return - section current date to return
	 * @throws NoSuchMethodException
	 *             - for sections without date
	 */
	public Date getDate() throws NoSuchMethodException {
		throw new NoSuchMethodException();
	}

	/**
	 * @return - section query to return
	 */
	public String getSectionQuery() {
		return this.sectionQuery;
	}
}
