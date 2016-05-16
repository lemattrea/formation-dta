package fr.pizzeria.exception;

public class SqlBddException extends DaoException {

	/**
	 * 
	 */
	public SqlBddException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public SqlBddException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SqlBddException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public SqlBddException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public SqlBddException(Throwable cause) {
		super(cause);
	}

}
