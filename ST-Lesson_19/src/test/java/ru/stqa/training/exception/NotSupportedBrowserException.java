package ru.stqa.training.exception;

public class NotSupportedBrowserException extends Exception {
	private static final long serialVersionUID = -4261579213103748983L;

	public NotSupportedBrowserException(final String message) {
		super(message);
	}
}
