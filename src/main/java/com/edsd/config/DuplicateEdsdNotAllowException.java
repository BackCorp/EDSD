package com.edsd.config;

public class DuplicateEdsdNotAllowException extends RuntimeException {

	private static final long serialVersionUID = -1524482632510776975L;

	public DuplicateEdsdNotAllowException() {
		super();
	}
	
	public DuplicateEdsdNotAllowException(String message) {
		super(message);
	}
	
}
