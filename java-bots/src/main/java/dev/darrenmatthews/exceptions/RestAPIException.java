package dev.darrenmatthews.exceptions;

public class RestAPIException extends Exception {
	private static final long serialVersionUID = 1L;

	public RestAPIException(String message) {
		super(message);
	}
}
