package fr.pizzeria.exception;

public class UpdatePizzaException extends DaoException{

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public UpdatePizzaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UpdatePizzaException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public UpdatePizzaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public UpdatePizzaException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public UpdatePizzaException() {
		// TODO Auto-generated constructor stub
	}

}
