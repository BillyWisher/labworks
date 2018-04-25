package by.gsu.epamlab.managers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.beans.User;
import by.gsu.epamlab.exceptions.AuthenticationException;

/**
 * Class for utility methods
 */
public class UserUtils {
	/**
	 * Constants
	 */
	private static final String EMPTY = "";

	/**
	 * Hided constructor
	 */
	private UserUtils() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Delete current cookies
	 * 
	 * @param response
	 *            - http response
	 */
	public static final void deleteCookies(final HttpServletResponse response) {
		final Cookie idCookie = new Cookie(Constants.USER_ID, UserUtils.EMPTY);
		idCookie.setMaxAge(Constants.MAX_COOKIE_AGE_DEAD);
		idCookie.setSecure(true);
		final Cookie loginCookie = new Cookie(Constants.USER_LOGIN,
				UserUtils.EMPTY);
		loginCookie.setMaxAge(Constants.MAX_COOKIE_AGE_DEAD);
		loginCookie.setSecure(true);
		final Cookie passwordCookie = new Cookie(Constants.USER_PASSWORD,
				UserUtils.EMPTY);
		passwordCookie.setSecure(true);
		passwordCookie.setMaxAge(Constants.MAX_COOKIE_AGE_DEAD);

		response.addCookie(idCookie);
		response.addCookie(loginCookie);
		response.addCookie(passwordCookie);
	}

	/**
	 * Gets user from current cookies
	 * 
	 * @param request
	 *            - http request
	 * @return - user
	 * @throws AuthenticationException
	 */
	public static final User getUserFromCookies(final HttpServletRequest request)
			throws AuthenticationException {
		final Cookie[] cookies = request.getCookies();
		if ((cookies != null) && (cookies.length != 0)) {
			int id = 0;
			String login = null;
			String password = null;
			for (final Cookie cookie : cookies) {
				final String cookieName = cookie.getName();
				if (Constants.USER_ID.equals(cookieName)) {
					id = Integer.parseInt(cookie.getValue());
				}
				if (Constants.USER_LOGIN.equals(cookieName)) {
					login = cookie.getValue();
				}
				if (Constants.USER_PASSWORD.equals(cookieName)) {
					password = cookie.getValue();
				}
			}
			if (!((login == null) || (password == null))) {
				return new User(id, login, password);
			}
		}
		throw new AuthenticationException(Constants.COOKIES_EXCEPTION);
	}

	/**
	 * Gets user User from current session
	 * 
	 * @param session
	 *            - current session
	 * @return - user
	 */
	public static final User getUserFromSession(final HttpSession session) {
		return (User) session.getAttribute(Constants.ATTRIBUTE_USER);
	}

	/**
	 * Sets user's cookies
	 * 
	 * @param response
	 *            - http response
	 * @param user
	 *            - user to set in cookies
	 */
	public static final void setUserCookies(final HttpServletResponse response,
			final User user) {
		final Cookie idCookie = new Cookie(Constants.USER_ID,
				Integer.toString(user.getId()));
		idCookie.setMaxAge(Constants.MAX_COOKIE_AGE);
		idCookie.setSecure(true);
		final Cookie loginCookie = new Cookie(Constants.USER_LOGIN,
				user.getLogin());
		loginCookie.setMaxAge(Constants.MAX_COOKIE_AGE);
		loginCookie.setSecure(true);
		final Cookie passwordCookie = new Cookie(Constants.USER_PASSWORD,
				user.getPassword());
		passwordCookie.setSecure(true);
		passwordCookie.setMaxAge(Constants.MAX_COOKIE_AGE);

		response.addCookie(idCookie);
		response.addCookie(loginCookie);
		response.addCookie(passwordCookie);
	}

	/**
	 * Sets user in current session
	 * 
	 * @param session
	 *            - current session
	 * @param user
	 *            - user to set
	 */
	public static final void setUserInSession(final HttpSession session,
			final User user) {
		session.setAttribute(Constants.ATTRIBUTE_USER, user);
	}

}
