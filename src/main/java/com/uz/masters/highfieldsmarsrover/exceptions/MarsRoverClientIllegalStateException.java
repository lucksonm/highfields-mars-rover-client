package com.uz.masters.highfieldsmarsrover.exceptions;


public class MarsRoverClientIllegalStateException extends RuntimeException {

	private static final long serialVersionUID = -7325515764498708603L;

	public MarsRoverClientIllegalStateException() {
		super();
	}

	public MarsRoverClientIllegalStateException(String message, Throwable cause) {
		super(message, cause);
	}

	public MarsRoverClientIllegalStateException(String message) {
		super(message);
	}

}