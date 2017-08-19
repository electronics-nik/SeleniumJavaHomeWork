package ru.stqa.training.exception;

public class NotSupportedOSException extends Exception {
	private static final long serialVersionUID = -4876413998525102629L;

	public NotSupportedOSException(final String message) {
		super(message);
	}
}
