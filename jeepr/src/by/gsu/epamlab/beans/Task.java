package by.gsu.epamlab.beans;

import java.io.InputStream;
import java.sql.Date;

/**
 * Describes some user's task
 */
public class Task {
	/**
	 * Constants
	 */
	private static final int NO_ID = -1;
	/**
	 * Fields
	 */
	private final int id;
	private final User owner;
	private String description;
	private Date date;
	private InputStream file;
	private String fileName;
	private TaskStatus taskStatus;

	/**
	 * Constructor with args
	 * 
	 * @param id
	 *            - task's id
	 * @param owner
	 *            - task's owner
	 * @param description
	 *            - task's description
	 * @param date
	 *            - date for task
	 * @param taskStatus
	 *            - task status
	 */
	public Task(final int id, final User owner, final String description,
			final Date date, final InputStream file, final String fileName,
			final TaskStatus taskStatus) {
		this.id = id;
		this.owner = owner;
		this.description = description;
		this.date = date;
		this.file = file;
		this.fileName = fileName;
		this.taskStatus = taskStatus;
	}

	/**
	 * Constructor without task id
	 * 
	 * @param owner
	 *            - task's owner
	 * @param description
	 *            - task's description
	 * @param date
	 *            - date for task
	 * @param taskStatus
	 *            - task status
	 */
	public Task(final User owner, final String description, final Date date,
			final InputStream file, final String fileName,
			final TaskStatus taskStatus) {
		this(Task.NO_ID, owner, description, date, file, fileName, taskStatus);
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @return the file
	 */
	public InputStream getFile() {
		return this.file;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @return the owner
	 */
	public User getOwner() {
		return this.owner;
	}

	/**
	 * @return the status
	 */
	public TaskStatus getStatus() {
		return this.taskStatus;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(final Date date) {
		this.date = date;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(final InputStream file) {
		this.file = file;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(final String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @param taskStatus
	 *            the status to set
	 */
	public void setStatus(final TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.id + "; " + this.owner + "; " + this.description + "; "
				+ this.date + "; " + this.file + "; " + this.taskStatus;
	}

}
