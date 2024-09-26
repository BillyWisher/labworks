package by.gsu.epamlab;

import by.gsu.epamlab.managers.ConfigurationManager;
import by.gsu.epamlab.managers.MessageManager;

/**
 * Class with all application constants
 */
public class Constants {

	/**
	 * Data base constants
	 */
	public static final String CONTEXT = ConfigurationManager
			.getProperty("base.connector.context");

	public static final String BASE_NAME = ConfigurationManager
			.getProperty("base.connector.basename");
	/**
	 * Page parameters constants
	 */
	public static final String LOGIN_PARAM = ConfigurationManager
			.getProperty("params.user.login");

	public static final String PASSWORD_PARAM = ConfigurationManager
			.getProperty("params.user.password");
	public static final String REMEMBER_ME_PARAM = ConfigurationManager
			.getProperty("params.cookie.remember");
	public static final String ACTION_PARAM = ConfigurationManager
			.getProperty("params.action");
	public static final String TARGETS_PARAM = ConfigurationManager
			.getProperty("params.action.targets");
	public static final String CREATE_TASK_DESCRIPTION_PARAM = ConfigurationManager
			.getProperty("params.action.createTask.description");
	public static final String CREATE_TASK_DATE_PARAM = ConfigurationManager
			.getProperty("params.action.createTask.date");
	public static final String CREATE_TASK_FILE_PARAM = ConfigurationManager
			.getProperty("params.action.createTask.file");
	public static final String DOWNLOAD_FILE_PARAM = ConfigurationManager
			.getProperty("params.action.downloadFile.taskId");
	public static final String LOAD_FILE_PARAM = ConfigurationManager
			.getProperty("params.action.loadfile.file");
	public static final String LOAD_ID_PARAM = ConfigurationManager
			.getProperty("params.action.loadfile.taskId");
	public static final String DELETE_ID_PARAM = ConfigurationManager
			.getProperty("params.action.deletefile.taskId");
	/**
	 * Attribute constants
	 */
	public static final String ATTRIBUTE_USER = ConfigurationManager
			.getProperty("attribute.user");

	public static final String ATTRIBUTE_INFO = ConfigurationManager
			.getProperty("attribute.info");
	public static final String ATTRIBUTE_TASKS = ConfigurationManager
			.getProperty("attribute.tasks");
	public static final String ATTRIBUTE_SECTION = ConfigurationManager
			.getProperty("attribute.section");
	public static final String ATTRIBUTE_OPERATIONS = ConfigurationManager
			.getProperty("attribute.operations");
	/**
	 * Page constants
	 */
	public static final String PAGE_MAIN = ConfigurationManager
			.getProperty("path.page.main");

	public static final String PAGE_LOGIN = ConfigurationManager
			.getProperty("path.page.login");
	public static final String PAGE_INDEX = ConfigurationManager
			.getProperty("path.page.index");
	public static final String PAGE_CREATE_TASK = ConfigurationManager
			.getProperty("path.page.createTask");
	/**
	 * Servlet constants
	 */
	public static final String CONTROLLER_MAIN = ConfigurationManager
			.getProperty("path.controller.main");

	/**
	 * Cookie parameters constants
	 */
	public static final String USER_ID = ConfigurationManager
			.getProperty("params.user.id");

	public static final String USER_LOGIN = ConfigurationManager
			.getProperty("params.user.login");
	public static final String USER_PASSWORD = ConfigurationManager
			.getProperty("params.user.password");
	/**
	 * Cookie attr
	 */
	public static final int MAX_COOKIE_AGE = 60 * 60 * 24 * 356;

	public static final int MAX_COOKIE_AGE_DEAD = 0;
	/**
	 * Data base queries
	 */
	public static final String QUERY_GET_USER = ConfigurationManager
			.getProperty("base.query.getUser");
	public static final String QUERY_GET_USER_BY_LOGIN = ConfigurationManager
			.getProperty("base.query.getUserByLog");

	public static final String QUERY_GET_USER_BY_ID = ConfigurationManager
			.getProperty("base.query.getUserById");
	public static final String QUERY_ADD_USER = ConfigurationManager
			.getProperty("base.query.addUser");
	public static final String QUERY_ADD_TASK = ConfigurationManager
			.getProperty("base.query.addTask");
	public static final String QUERY_UPDATE_TASK = ConfigurationManager
			.getProperty("base.query.updateTask");
	public static final String QUERY_HARD_DELETE_TASK = ConfigurationManager
			.getProperty("base.query.hardDeleteTask");
	public static final String QUERY_GET_TASK_HEAD = ConfigurationManager
			.getProperty("base.query.getTask.head");
	public static final String QUERY_GET_TASK_TAIL = ConfigurationManager
			.getProperty("base.query.getTask.tail");
	public static final String QUERY_GET_TASK_BY_ID = ConfigurationManager
			.getProperty("base.query.getTaskById");
	public static final String SECTION_QUERY_TODAY = ConfigurationManager
			.getProperty("base.query.sectionQery.today");
	public static final String SECTION_QUERY_TOMORROW = ConfigurationManager
			.getProperty("base.query.sectionQery.tomorrow");
	public static final String SECTION_QUERY_SOMEDAY = ConfigurationManager
			.getProperty("base.query.sectionQery.someday");
	public static final String SECTION_QUERY_DELETED = ConfigurationManager
			.getProperty("base.query.sectionQery.deleted");
	public static final String SECTION_QUERY_FIXED = ConfigurationManager
			.getProperty("base.query.sectionQery.deleted");
	public static final String QUERY_LOADFILE = ConfigurationManager
			.getProperty("base.query.loadFile");
	/**
	 * Users table columns
	 */
	public static final String COLUMN_USER_NAME = ConfigurationManager
			.getProperty("base.columns.user.login");

	public static final String COLUMN_USER_PASS = ConfigurationManager
			.getProperty("base.columns.user.pass");
	public static final String COLUMN_USER_ID = ConfigurationManager
			.getProperty("base.columns.user.id");
	/**
	 * Task table columns
	 */
	public static final String COLUMN_TASK_ID = ConfigurationManager
			.getProperty("base.columns.task.id");

	public static final String COLUMN_TASK_OWNER = ConfigurationManager
			.getProperty("base.columns.task.owner");
	public static final String COLUMN_TASK_DESCRIPTION = ConfigurationManager
			.getProperty("base.columns.task.description");
	public static final String COLUMN_TASK_DATE = ConfigurationManager
			.getProperty("base.columns.task.date");
	public static final String COLUMN_TASK_FILE = ConfigurationManager
			.getProperty("base.columns.task.file");
	public static final String COLUMN_TASK_FILENAME = ConfigurationManager
			.getProperty("base.columns.task.fileName");
	public static final String COLUMN_TASK_STATUS = ConfigurationManager
			.getProperty("base.columns.task.status");
	/**
	 * Exception messages
	 */
	public static final String AUTHENTICATION_EXCEPTION = MessageManager
			.getProperty("message.loginerror");

	public static final String LOGGED_OUT_EXCEPTION = MessageManager
			.getProperty("message.loggedout");
	public static final String USER_EXISTS = MessageManager
			.getProperty("message.userexists");
	public static final String MESSAGE_SOMETHING_WENT_WRONG = MessageManager
			.getProperty("message.smthwentwrong");
	public static final String COOKIES_EXCEPTION = MessageManager
			.getProperty("message.cookiesexception");
	public static final String ILLEGAL_SECTION_EXCEPTION = MessageManager
			.getProperty("message.illegalsection");
	public static final String NULL_VALUES_EXCEPTION = MessageManager
			.getProperty("message.nullvalues");
	public static final String ADD_TASK_EXCEPTION = MessageManager
			.getProperty("message.addtaskexception");
	public static final String DELETE_TASK_EXCEPTION = MessageManager
			.getProperty("message.deleteexception");
	public static final String FIX_TASK_EXCEPTION = MessageManager
			.getProperty("message.fixexception");
	public static final String DOWNLOAD_EXCEPTION = MessageManager
			.getProperty("message.downloadexception");
	public static final String LOAD_EXCEPTION = MessageManager
			.getProperty("message.loadexception");
	public static final String WRONG_TASK_EXCEPTION = MessageManager
			.getProperty("message.wrongtask");

	/**
	 * Hided constructor
	 */
	private Constants() {
		throw new IllegalStateException("Utility class");
	}

}
