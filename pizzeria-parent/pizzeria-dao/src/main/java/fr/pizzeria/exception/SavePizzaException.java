package fr.pizzeria.exception;

public class SavePizzaException extends DaoException{


	/**
	 * 
	 */
	public SavePizzaException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public SavePizzaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SavePizzaException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public SavePizzaException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public SavePizzaException(Throwable cause) {
		super(cause);
	}
	

}
