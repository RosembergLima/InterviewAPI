package com.interview.services.exception;

public class IncorrectDataException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IncorrectDataException(String msg) {
		super(msg);
	}

	public IncorrectDataException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
