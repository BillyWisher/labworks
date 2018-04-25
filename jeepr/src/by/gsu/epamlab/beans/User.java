package by.gsu.epamlab.beans;

import java.io.Serializable;

/**
 * Describes some user
 */
public class User implements Serializable {
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Fields
	 */
	private int id;
	private String login;
	private String password;

	/**
	 * No-arg constructor
	 */
	public User() {
	}

	/**
	 * Constructor with args
	 * 
	 * @param name
	 *            - user's name
	 * @param password
	 *            - user's
	 */
	public User(final int id, final String login, final String password) {
		this.id = id;
		this.login = login;
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final User other = (User) obj;
		if (this.id != other.id) {
			return false;
		}
		if (this.login == null) {
			if (other.login != null) {
				return false;
			}
		} else if (!this.login.equals(other.login)) {
			return false;
		}
		if (this.password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!this.password.equals(other.password)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @return the name
	 */
	public String getLogin() {
		return this.login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + this.id;
		result = (prime * result)
				+ ((this.login == null) ? 0 : this.login.hashCode());
		result = (prime * result)
				+ ((this.password == null) ? 0 : this.password.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.id + "; " + this.login + "; " + this.password;
	}

}
