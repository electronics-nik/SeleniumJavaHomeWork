package ru.stqa.training.exception;

public class NotFoundOptionValueException extends Exception {
	private static final long serialVersionUID = -5226478672530685524L;
	
	public NotFoundOptionValueException(final String message) {
		super(message);
	}
}
