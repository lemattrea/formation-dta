package fr.pizzeria.exception;

public class NotImplementException extends DaoException {

	/**
	 * 
	 */
	public NotImplementException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public NotImplementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NotImplementException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public NotImplementException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public NotImplementException(Throwable cause) {
		super(cause);
	}

}
