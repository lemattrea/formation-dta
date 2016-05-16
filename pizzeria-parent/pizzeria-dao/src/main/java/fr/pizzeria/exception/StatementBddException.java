package fr.pizzeria.exception;

public class StatementBddException extends DaoException {

	/**
	 * 
	 */
	public StatementBddException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public StatementBddException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public StatementBddException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public StatementBddException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public StatementBddException(Throwable cause) {
		super(cause);
	}

}
