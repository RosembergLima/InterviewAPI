package com.interview.services.exception;

public class ActivedAccountException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ActivedAccountException(String msg) {
		super(msg);
	}

	public ActivedAccountException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
