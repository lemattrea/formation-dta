package fr.pizzeria.exception;

public class ConnectionBddException extends DaoException {

	/**
	 * 
	 */
	public ConnectionBddException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ConnectionBddException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ConnectionBddException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ConnectionBddException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ConnectionBddException(Throwable cause) {
		super(cause);
	}

}
